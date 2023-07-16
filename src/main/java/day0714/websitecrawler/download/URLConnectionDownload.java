package day0714.websitecrawler.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDownload extends HTMLDownloader{
    @Override
    String getHTML(URL url) {
        StringBuilder html = new StringBuilder();
        try {
            URLConnection uc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                html.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return html.toString();
    }
}
