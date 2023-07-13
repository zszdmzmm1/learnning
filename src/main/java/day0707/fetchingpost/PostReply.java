package day0707.fetchingpost;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter

public class PostReply implements table {
    private int id;
    private String postId;
    private String reply;

    public PostReply(String postId, String reply) {
        this.postId = postId;
        this.reply = reply;
    }

    @Override
    public void add(Connection connection) {
        PreparedStatement ppstmt = null;

        String insertSql = "insert into postReply(id, postid, reply) values(?, ?, ?);";

        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setInt (1, id);
            ppstmt.setString(2, postId);
            ppstmt.setString(3, reply);

            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
