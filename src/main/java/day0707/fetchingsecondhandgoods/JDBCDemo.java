package day0707.fetchingsecondhandgoods;

import java.sql.*;

public class JDBCDemo {

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/item?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false", "root", System.getenv("sqlPassword"));
        System.out.println("Connected to database");
        return conn;
    }

    public void testStatement(Connection connection) {
        Statement stmt = null;
        String query = "select id, uid, title, publish_date from seconditem";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String uid = rs.getString("uid");
                String title = rs.getString("title");
                Date publishDate =  rs.getDate("publish_date");
                System.out.println(id + "\t" + uid + "\t" + title + "\t" + publishDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
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

        String insertSql = "insert into secondItem(id, uid, title, publish_date) values(?, ?, ?, ?);";

        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setInt (1, post.getId());
            ppstmt.setString(2, post.getUid());
            ppstmt.setString(3, post.getTitle());
            ppstmt.setDate(4, post.getPublishDate());

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
            ppstmt.setString(4, task.getLastPost());

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

    public void batchAdd(Connection connection) {
        PreparedStatement ppstmt = null;

        String insertSql = "insert into user(name, balance) values(?, ?);";

        try {
            ppstmt = connection.prepareStatement(insertSql);

            ppstmt.setString(1, "alex");
            ppstmt.setInt(2, 50);
            ppstmt.addBatch();

            ppstmt.setString(1, "bob");
            ppstmt.setInt(2, 30);
            ppstmt.addBatch();

            ppstmt.executeBatch();
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
            ppstmt.setString(2, task.getLastPost());
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

    public void delete(Connection connection) {
        PreparedStatement ppstmt = null;

        String updateSql = "delete from user where name = ?";

        try {
            ppstmt = connection.prepareStatement(updateSql);
            ppstmt.setString(1, "alex");
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

    public void testTransactions(Connection connection) {
        PreparedStatement ppstmt1 = null;
        PreparedStatement ppstmt2 = null;
        String update1 = "update user set balance = balance - 10 where id = ?";
        String update2 = "update user set balance = balance + 10 where id = ?";

        try {
            connection.setAutoCommit(false);

            ppstmt1 = connection.prepareStatement(update1);
            ppstmt1.setInt(1, 1);
            ppstmt1.executeUpdate();

            int i = 2 / 0;

            ppstmt2 = connection.prepareStatement(update2);
            ppstmt2.setInt(1, 2);
            ppstmt2.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ppstmt1 != null) {
                    ppstmt1.close();
                }
                if (ppstmt2 != null) {
                    ppstmt2.close();
                }
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void tableLocate(String table, String... fields) {
        String query = "select id, name, balance from user";
        for(String field: fields){
            query += "field";
        }
    }

}