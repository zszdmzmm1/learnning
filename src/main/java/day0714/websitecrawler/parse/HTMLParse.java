package day0714.websitecrawler.parse;

import org.jsoup.select.Elements;

public abstract class HTMLParse {
    abstract Elements getElements(String html);

}
