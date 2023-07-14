package day0707.postFetching;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.sql.Connection;


public class PostElement {
    public String postDealer(Connection connection, String url, String uid)  {
        String content;
        for (int j = 1; ; j++) {
            String rURL = url.replace(".html", "") + "-page-" + j + ".html";
            Document postDoc = null;
            try {
                postDoc = Jsoup.connect(rURL).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Elements reply = postDoc.select("div[id~=read_\\d+]");
            Element page = postDoc.selectFirst("div.pages > span.fl");
            content = postDoc.select("div[id=read_tpc]").text();
            int pages = 1;
            if (j == 1 && page != null) {
                pages = Integer.parseInt(page.html().replaceAll("共(\\d+)页", "$1"));
            }
            for (Element r : reply) {
                String text = r.html();
                PostReply postReply = new PostReply(uid, text);
                if (!text.trim().equals("")) {
                    postReply.add(connection);
                }
            }
            if (j == pages) {
                break;
            }
        }
        return content;
    }
}
