package day0613.news;

import java.util.Date;

public class News {
    private String title;
    private String author;
    private String content;
    private Date publishDate;


    public News(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


    public void printNews() {
        System.out.println(getTitle());
    }


    public boolean equals(News anotherNews) {
        return this.getTitle().equals(anotherNews.getTitle());
    }

    public void showNews(){
        System.out.println(this.getTitle());
        System.out.println("  作者：" + this.getAuthor());
        System.out.println("  内容：" + this.getContent());
        System.out.println("  时间：" + this.getPublishDate());
        System.out.println("--------------------");
    }

}
