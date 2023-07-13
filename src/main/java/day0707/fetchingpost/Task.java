package day0707.fetchingpost;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
public class Task implements table{
    private int id;
    private String URL;
    private Date lastTime;
    private String lastUid;

    public Task(String url, Date lastTime, String lastPost) {
        this.URL = url;
        this.lastTime = lastTime;
        this.lastUid = lastPost;
    }

    @Override
    public void add(Connection connection) {
        PreparedStatement ppstmt = null;

        String insertSql = "insert into task(id, URL, last_date, last_post) values(?, ?, ?, ?);";

        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setInt (1, id);
            ppstmt.setString(2, URL);
            ppstmt.setDate(3, lastTime);
            ppstmt.setString(4, lastUid);

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

    public void update(Connection connection) {
        PreparedStatement ppstmt = null;
        String updateSql = "update task set last_date = ?, last_post = ? where URL = ?";
        try {
            ppstmt = connection.prepareStatement(updateSql);
            ppstmt.setDate(1, lastTime);
            ppstmt.setString(2, lastUid);
            ppstmt.setString(3, URL);
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
