package day0707.postFetching;


import org.jsoup.select.Elements;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 在厦门小鱼网爬取二手信息，挑选需要的发送至邮箱
 */
public class Fetching {
    public static void main(String[] args) throws InterruptedException {
        JDBCItem jdbcItem = new JDBCItem();
        Connection connection = jdbcItem.getConnection();
        List<Elements> post = new ArrayList<>();

        int missionNum = Task.getNum(connection);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入关键词：");
        String target = scanner.next();
        for(int i = 1; i <= missionNum; i++){
            Mythread mythread = new Mythread(i, target, connection);
            mythread.start();
            mythread.join();
            post.addAll(mythread.getPostList());
        }
/*        if (post.size() != 0) {
            System.out.println("找到" + post.size() + "个匹配帖子");
            ItemListElements itemListElements = new ItemListElements(System.getenv("qqEmail"), System.getenv("password"), System.getenv("toEmail"));
            itemListElements.sentMessage(post);
        }*/
    }
}
