package day0707.postFetching;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Getter
@Setter
public class Post implements Table {
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


    @Override
    public void add(Connection connection) {
        PreparedStatement ppstmt = null;

        String insertSql = "insert into post(id, uid, title, publish_date, content) values(?, ?, ?, ?, ?);";

        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setInt (1, id);
            ppstmt.setString(2, uid);
            ppstmt.setString(3, title);
            ppstmt.setDate(4, publishDate);
            ppstmt.setString(5, content);

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
