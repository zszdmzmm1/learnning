package day0707.fetchingsecondhandgoods;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.net.MalformedURLException;
import java.net.URL;

public class Fetching {
    public static void main(String[] args) throws IOException {
        for(int i = 1 ;; i++){
            Document doc = Jsoup.connect("http://bbs.xmfish.com/thread-htm-fid-55-search-all-orderway-postdate-asc-DESC-page-" + i + ".html").get();
            Elements elements = doc.select("tr.tr3 td.subject a[class =subject_t f14]:eq(1)");
            if(i == 4){
                break;
            }
            for(Element e : elements){
                System.out.println(elements.html());
            }
        }



    }
}
