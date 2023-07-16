package day0707.postFetching;

import lombok.Getter;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Mythread implements Runnable{
    private final int TASK_NUM;
    private final Connection CONNECTION;
    private final String TARGET;
    private List<Elements> postList = new ArrayList();


    public Mythread(int num, String target, Connection connection){
        this.TASK_NUM = num;
        this.CONNECTION = connection;
        this.TARGET = target;
    }


    @Override
    public void run() {
        //计数，仅用于记录，可删
        int itemC = 0;
        //记录本次运行需要用于发送信息的Elements

        //初始化
        Post post;
        PostElement postElement = new PostElement();
        //获取任务
        Task task = Task.getInstance(CONNECTION, TASK_NUM);
        Date lastDate = task.getLastTime();
        String lastPost = task.getLastUid();
        String url = task.getURL();

        boolean isFirst = true;
        A:
        for (int i = 1;; i++) {
            url = url.replaceFirst("page-\\d*", "page-" + i);

            Document doc = null;
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Elements elements = doc.select("tr.tr3:has(a[title=开放主题]), tr.tr3:has(a[title=热门主题])");
            //进一步提取有用信息
            for (Element e : elements) {
                Elements item = e.select("a[class=subject_t f14]");
                Elements date = e.select("p:not(:has(a))");
                String uid = item.attr("id");
                Date sqlDate = Date.valueOf(date.html());
                String content;
                String postURL = item.attr("abs:href");
                if (isFirst) {
                    task = new Task(url, sqlDate, uid);
                    task.update(CONNECTION);
                    isFirst = false;
                }
                //记录需要的物品
                if (sqlDate.compareTo(lastDate) >= 0) {
                    if (lastPost != null && (uid.compareTo(lastPost) <= 0)) {
                        break A;
                    }
                    content = postElement.postDealer(CONNECTION, postURL, uid);
                    post = new Post(uid, item.html(), sqlDate, content);
                    post.add(CONNECTION);
                    System.out.println(item.html());
                    if (item.html().contains(TARGET)) {
                        postList.add(item);
                    }
                    itemC++;
                } else {
                    break A;
                }
            }
        }
    }
}
