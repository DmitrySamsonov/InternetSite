package good.team.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlJdbcUtil {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://remotemysql.com:3306/ppVLywhE9a";
    private static final String JDBC_USER = "ppVLywhE9a";
    private static final String JDBC_PASSWORD = "dcZHIrjrwU";

    private boolean checkMySqlJdbcDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Connection getConnection() {
        if (checkMySqlJdbcDriver()) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                return connection;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
