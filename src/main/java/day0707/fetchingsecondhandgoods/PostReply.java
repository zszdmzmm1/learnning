package day0707.fetchingsecondhandgoods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter

public class PostReply {
    private int id;
    private String postId;
    private String reply;

    public PostReply(String postId, String reply) {
        this.postId = postId;
        this.reply = reply;
    }
}
