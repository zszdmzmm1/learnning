package day0707.postFetching;

import tool.AppConfig;

import java.sql.*;

public class JDBCItem implements JDBC{
    @Override
    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(AppConfig.get("sqlURL"), "root", AppConfig.get("sqlPassword"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to database");
        return conn;
    }

}