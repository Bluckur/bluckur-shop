package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class ConnectionHandler {
    private static final String DATABASE_NAME = "Database";
    private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + DATABASE_NAME;

    public static Connection connect() {
        Connection connection = null;

        try {
//            System.out.println("Connecting to database...");
//            System.out.println("URL: " + URL);
            connection = DriverManager.getConnection(URL);
            enableForeignKeys(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static void enableForeignKeys(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("PRAGMA foreign_keys = ON;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(Connection connection) {
        try {
//            System.out.println("Disconnecting from database...");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeStatement(String sql) {
        try {
            Connection connection = ConnectionHandler.connect();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            ConnectionHandler.disconnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
