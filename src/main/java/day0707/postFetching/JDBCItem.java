package day0707.postFetching;

import java.sql.*;

public class JDBCItem implements JDBC{
    @Override
    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/item?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "0521");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to database");
        return conn;
    }

}