package good.team.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://remotemysql.com:3306/ppVLywhE9a" ;
    private static final String JDBC_USER = "ppVLywhE9a";
    private static final String JDBC_PASSWORD = "dcZHIrjrwU";

    private Connection connection = null;
    private Statement statement = null;

    private boolean JdbcSqlDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Connection getConnection() {
        if (connection == null) {
            if (!JdbcSqlDriver()) {
                return null;
            }
            try {
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public Statement getStatement() {
        if (statement == null) {
            try {
                statement = getConnection().createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statement;
    }

    public void closeStatement() {
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
