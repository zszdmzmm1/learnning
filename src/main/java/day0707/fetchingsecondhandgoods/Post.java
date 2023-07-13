package day0707.fetchingsecondhandgoods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class Post {
    private int id;
    private String uid;
    private String title;
    private Date publishDate;
    private String content;

    public Post(String uid, String title, Date publishDate, String content) {
        this.uid = uid;
        this.title = title;
        this.publishDate = publishDate;
        this.content = content;
    }
}
