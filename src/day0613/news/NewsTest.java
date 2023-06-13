package day0613.news;

import java.util.*;

public class NewsTest {
    public static void main(String[] args) {
        News news1 = new News("中国多地遭雾霾笼罩空气质量再成热议话题");
        News news2 = new News("民进党台北举行”火大游行“");
        News news3 = new News("春节临近北京”卖房热“");
        News news4 = new News("春节临近北京”卖房热“");
        List<News> newsList = new ArrayList<>();
        newsList.add(news1);
        newsList.add(news2);
        newsList.add(news3);
        newsList.add(news4);
        System.out.println("新闻标题列表：");

        for (int i = 0; i < newsList.size(); i++) {
            System.out.println("新闻" + (i + 1) + ":" + newsList.get(i).getTitle());
        }


        //____________________________________
        System.out.println("----------------------");
        //____________________________________


        if (news1.equals(news2)) {
            System.out.println("新闻一与新闻二相同");
        } else {
            System.out.println("新闻一与新闻二不相同");
        }
        if (news3.equals(news4)) {
            System.out.println("新闻三与新闻四不相同");
        } else {
            System.out.println("新闻三与新闻四不相同");
        }
        System.out.println("-----------------");


        Map<Integer, News> newsMap = new HashMap<>();
        newsMap.put(1, news1);
        newsMap.put(2, news2);
        newsMap.put(3, news3);
        newsMap.put(4, news4);

        System.out.println("共有" + newsMap.size() + "条新闻:");


        for (int i = 0; i < newsMap.size(); i++) {
            System.out.print((i + 1) + ".");
            newsMap.get(i + 1).showNews();
        }

    }
}
