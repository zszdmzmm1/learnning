package day0707.postFetching;


import org.jsoup.select.Elements;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


/**
 * 在厦门小鱼网爬取二手信息，挑选需要的发送至邮箱
 */
public class Fetching {
    public static void main(String[] args) throws Exception {
        JDBCItem jdbcItem = new JDBCItem();
        Connection connection = jdbcItem.getConnection();
        List<Elements> post = new ArrayList<>();

        for(int i = 1; i <= 3; i++){
            Mythread mythread = new Mythread(i, connection);
            mythread.start();
            //post.addAll(mythread.getPostList());
        }
/*        if (post.size() != 0) {
            ItemListElements itemListElements = new ItemListElements(System.getenv("qqEmail"), System.getenv("password"), System.getenv("toEmail"));
            itemListElements.sentMessage(post);
        }*/
        System.out.println("跑完啦");
    }
}
