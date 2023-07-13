package day0707.fetchingsecondhandgoods;

import java.sql.*;

public class JDBCitem implements JDBC{
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/item?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "0521");
        System.out.println("Connected to database");
        return conn;
    }

    public Task getInstance(Connection connection) {
        PreparedStatement ppstmt = null;
        String query = "select id, URL, last_date, last_post from task where URL = ?";

        try {
            ppstmt = connection.prepareStatement(query);
            ppstmt.setString(1, "http://bbs.xmfish.com/thread-htm-fid-55-search-all-orderway-postdate-asc-DESC-page-1.html");
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


    public void add(Connection connection, Post post) {
        PreparedStatement ppstmt = null;

        String insertSql = "insert into secondItem(id, uid, title, publish_date, content) values(?, ?, ?, ?, ?);";

        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setInt (1, post.getId());
            ppstmt.setString(2, post.getUid());
            ppstmt.setString(3, post.getTitle());
            ppstmt.setDate(4, post.getPublishDate());
            ppstmt.setString(5, post.getContent());

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

    public void add(Connection connection, PostReply rp) {
        PreparedStatement ppstmt = null;

        String insertSql = "insert into postReply(id, postid, reply) values(?, ?, ?);";

        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setInt (1, rp.getId());
            ppstmt.setString(2, rp.getPostId());
            ppstmt.setString(3, rp.getReply());

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


    public void add(Connection connection, Task task) {
        PreparedStatement ppstmt = null;

        String insertSql = "insert into secondItem(id, URL, last_date, last_post) values(?, ?, ?, ?);";

        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setInt (1, task.getId());
            ppstmt.setString(2, task.getURL());
            ppstmt.setDate(3, task.getLastTime());
            ppstmt.setString(4, task.getLastUid());

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


    public void update(Connection connection, Task task) {
        PreparedStatement ppstmt = null;
        String updateSql = "update task set last_date = ?, last_post = ? where URL = ?";
        try {
            ppstmt = connection.prepareStatement(updateSql);
            ppstmt.setDate(1, task.getLastTime());
            ppstmt.setString(2, task.getLastUid());
            ppstmt.setString(3, task.getURL());
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