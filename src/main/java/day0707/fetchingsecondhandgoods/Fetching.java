package day0707.fetchingsecondhandgoods;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * 在厦门小鱼网爬取二手信息，挑选需要的发送至邮箱
 */
public class Fetching {
    public static void main(String[] args) throws Exception {
        //将需要处理后发送的html存在这里
        List<Elements> itemList = new ArrayList<>();
        int itemC = 0;
        int sentItem = 0;
        //判断是否覆写最新时间
        boolean isFirst = true;
        A:
        for (int i = 1; ; i++) {
            Document doc = Jsoup.connect("http://bbs.xmfish.com/thread-htm-fid-55-search-all-orderway-postdate-asc-DESC-page-" + i + ".html").get();

            Elements elements = doc.select("tr.tr3:has(a[title=开放主题])");
            File file = new File("src/main/java/day0707/fetchingsecondhandgoods/time.txt");
            //首次使用写入时间信息
            byte[] bytes = new byte[1024];
            if (!file.exists()) {
                file.createNewFile();
                OutputStream outputStream = new FileOutputStream(file);
                String sLocalDate = LocalDate.now().toString();
                bytes = sLocalDate.getBytes();
                outputStream.write(bytes);
                outputStream.close();
            }
            //爬取数据前获取上一次爬取的日期
            InputStream inputStream = new FileInputStream(file);
            inputStream.read(bytes);
            inputStream.close();
            String s = new String(bytes);
            //进一步提取有用信息
            for (Element e : elements) {
                Elements item = e.select("a[class=subject_t f14]");
                Elements date = e.select("p");
                //Elements date = e.select("p:not(:has(a))");
                //首次提取写入最新时间
                if (isFirst) {
                    OutputStream outputStream = new FileOutputStream(file);
                    outputStream.write(date.html().split("<")[0].getBytes());
                    //outputStream.write(date.html().getBytes());

                    outputStream.close();
                    isFirst = false;
                }
                //记录需要的物品
                if (date.html().compareTo(s) >= 0) {
                    //System.out.println(item.html());
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
        ElementsDealing elementsDealing = new ElementsDealing("*****", "*******", "********");
        elementsDealing.sentMessage(itemList);
    }
}
