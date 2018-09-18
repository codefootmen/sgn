package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Database {
    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/sgn", "root", "");
    }

    public static void closeConnection(Connection connection, Statement command) {
        try {
            if (command != null) {
                command.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ignored) {

        }
    }
}
