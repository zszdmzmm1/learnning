package day0707.postFetching;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
@AllArgsConstructor
public class Task implements Table {
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
            ppstmt.setInt(1, id);
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

    public static Task getInstance(Connection connection, int num) {
        PreparedStatement ppstmt = null;
        String query = "select id, URL, last_date, last_post from task where id = ?";


        try {
            ppstmt = connection.prepareStatement(query);
            ppstmt.setInt(1, num);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String URL = rs.getString("URL");
                Date last_date = rs.getDate("last_date");
                String last_post = rs.getString("last_post");
                return new Task(id, URL, last_date, last_post);
            }
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
        return null;
    }

    public static int getNum(Connection connection) {
        int num = 0;
        PreparedStatement ppstmt = null;
        String query = "select id from task;";
        try {
            ppstmt = connection.prepareStatement(query);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                num++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
