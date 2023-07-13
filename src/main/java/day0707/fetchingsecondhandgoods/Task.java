package day0707.fetchingsecondhandgoods;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    private int id;
    private String URL;
    private Date lastTime;
    private String lastUid;

    public Task(String url, Date lastTime, String lastPost) {
        this.URL = url;
        this.lastTime = lastTime;
        this.lastUid = lastPost;
    }

}
