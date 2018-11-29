package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Database {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgn", "root", "password");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
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
