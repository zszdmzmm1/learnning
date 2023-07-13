package day0707.fetchingpost;

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

}