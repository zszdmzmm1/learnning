package day0707.postFetching;

import java.sql.Connection;
import java.sql.SQLException;

public interface JDBC {
    Connection getConnection() throws SQLException;
}
