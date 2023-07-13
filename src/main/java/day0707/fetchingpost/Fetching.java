package day0707.fetchingpost;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * 在厦门小鱼网爬取二手信息，挑选需要的发送至邮箱
 */
public class Fetching {
    public static void main(String[] args) throws Exception {
        int sentItem = 0, itemC = 0;
        List<Elements> itemList = new ArrayList();
        Post post;
        PostReply postReply;
        JDBCitem jdbcTest = new JDBCitem();
        Connection connection = jdbcTest.getConnection();
        Task task = jdbcTest.getInstance(connection);
        Date lastDate = task.getLastTime();
        String lastPost = task.getLastUid();
        String url = task.getURL();
        boolean isFirst = true;
        A:
        for (int i = 1; i < 100; i++) {
            url = url.replaceFirst("page-\\d*", "page-" + i);
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("tr.tr3:has(a[title=开放主题]), tr.tr3:has(a[title=热门主题])");
            //进一步提取有用信息
            for (Element e : elements) {
                Elements item = e.select("a[class=subject_t f14]");
                Elements date = e.select("p:not(:has(a))");
                String uid = item.attr("id");
                Date sqlDate = Date.valueOf(date.html());
                String content;
                String postURL = item.attr("abs:href").replace(".html", "");
                if (isFirst) {
                    task = new Task(url, sqlDate, uid);
                    task.update(connection);
                    isFirst = false;
                }
                //记录需要的物品
                if (sqlDate.compareTo(lastDate) >= 0) {
                    if (lastPost != null && (uid.compareTo(lastPost) <= 0)) {
                        System.out.println("共发现" + itemC + "个新物品。");
                        System.out.println("已为您找出" + sentItem + "个匹配物品。");
                        break A;
                    }
                    for(int j = 1; ; j++){
                        String rPostURL = postURL + "-page-" + j + ".html";
                        Document postDoc = Jsoup.connect(rPostURL).get();
                        Elements reply = postDoc.select("div[id~=read_\\d+]");
                        Element page = postDoc.selectFirst("div.pages > span.fl");
                        content = postDoc.select("div[id=read_tpc]").text();
                        int pages = 1;
                        if(j == 1 && page != null){
                            pages = Integer.parseInt(page.html().replaceAll("共(\\d+)页", "$1"));
                        }
                        for(Element r: reply){
                            String text = r.html();
                            postReply = new PostReply(uid,  text);
                            if(!text.trim().equals("")){
                                postReply.add(connection);
                            }
                        }
                        if(j == pages){
                            break;
                        }
                    }
                    post = new Post(uid, item.html(), sqlDate, content);
                    post.add(connection);
                    System.out.println(item.html());
                    if (item.html().contains("转让")) {
                        itemList.add(item);
                        sentItem++;
                    }
                    itemC++;
                } else {
                    System.out.println("共发现" + itemC + "个新物品。");
                    System.out.println("已为您找出" + sentItem + "个匹配物品。");
                    break A;
                }
            }
        }
        //发送消息
/*        if (itemList.size() != 0) {
            ElementsDealing elementsDealing = new ElementsDealing(System.getenv("qqEmail"), System.getenv("password"), System.getenv("toEmail"));
            elementsDealing.sentMessage(itemList);
        }*/
    }
}