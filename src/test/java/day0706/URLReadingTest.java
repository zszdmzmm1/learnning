package day0706;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class URLReadingTest {
    @Test
    void readingDirectlyFromAURL() throws IOException {
        URL oracle = new URL("https://www.oracle.com/");
/*        InputStream inputStream = oracle.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader in = new BufferedReader(inputStreamReader);*/


        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }

        in.close();

    }

    @Test
    @DisplayName("测试连接时间超时。")
    void readingDirectlyFromAURL1() throws IOException {
        URL oracle = new URL("https://www.oracle.com/");

        URLConnection uc = oracle.openConnection();
        uc.setConnectTimeout(1);
        uc.setReadTimeout(2);

        Assertions.assertThrows(SocketTimeoutException.class, () -> {
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            in.close();
        });
    }

    @Test
    void readingDirectlyFromAURL2() throws IOException {
        URL url = new URL("https://www.qq.com/");

        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(1000);
        uc.setReadTimeout(2000);
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "gb2312"));
        String inputLine;
        while((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
        in.close();
    }

    @Test
    void readingDirectlyFromAURL3() throws IOException {
        URL url = new URL("https://www.douban.com/");
        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(1000);
        uc.setReadTimeout(2000);
        uc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        while((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
        in.close();
    }


    @Test
    void GetImageExample() throws IOException {
        URL url = new URL("http://www.baidu.com/img/bd_logo1.png");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


        InputStream is = urlConnection.getInputStream();
        File file = new File("src/test/java/day0706/dest.jpg");
        FileOutputStream fos = new FileOutputStream(file);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        System.out.println("图片下载完成！");
    }

    @Test
    void test() throws IOException {
        Document doc = Jsoup.connect("http://www.qq.com/").get();
        System.out.println(doc.title());
    }


    @Test
    void test1() throws IOException {
        Document doc = Jsoup.connect("http://www.baidu.com/").get();
        Elements element = doc.select("a#s-top-loginbtn");
        System.out.println(element.outerHtml());
    }

    @Test
    void test2() throws IOException {
        Document doc = Jsoup.connect("https://so.gushiwen.cn/gushi/shijing.aspx").get();
        Elements element1 = doc.select("span > a[target =_blank], span > a[style =color:#999999;]");
        Elements element2 = doc.select("div.left span:has(a)");
        Elements element3 = doc.select("div.left div.sons a");
        System.out.println(element1.size());
        System.out.println(element2.eachText());
    }
}
