package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC管理连接的工具类，可以获取连接和关闭连接
 */
public class DBUtil {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/nteaag";
    public static final String USER = "root";
    public static final String PASSWORD = "123.";

    /**
     * 获取连接对象
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    /**
     * 关闭连接对象
     * @param connection
     * @throws SQLException
     */
    public static void close(Connection connection) throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getConnection());
    }
}
