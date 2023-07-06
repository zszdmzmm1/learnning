package day0706;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
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
}
