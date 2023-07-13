package day0707.fetchingsecondhandgoods;

import java.sql.Connection;
import java.sql.SQLException;

public interface JDBC {
    Connection getConnection() throws SQLException;
}
