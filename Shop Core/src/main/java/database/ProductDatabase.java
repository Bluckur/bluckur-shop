package database;

import java.net.URI;
import java.sql.*;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class ProductDatabase {
    private static final String DATABASE_NAME = "Products";
    private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + DATABASE_NAME;

    private static Connection connection = null;

    public static void main(String args[]) {
        createProductTable();
        insertProduct(10l, "http://www.image.path", "Test Product", "This is a test product", 10l, true);
    }

    public static void createProductTable() {
        String tableName = "Products";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "price INT, " +
                "image_path VARCHAR(255), " +
                "product_name VARCHAR(255), " +
                "description TEXT, " +
                "quantity INT, " +
                "available INT)";

        try {
            connect();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Table " + tableName + " created successfully");
    }

    public static void insertProduct(Long price, String imagePath, String name, String description, Long quantity, boolean available) {
        String sql = "INSERT INTO Products (price, image_path, product_name, description, quantity, available) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            connect();
            PreparedStatement insertProduct = connection.prepareStatement(sql);
            insertProduct.setLong(1, price);
            insertProduct.setString(2, imagePath);
            insertProduct.setString(3, name);
            insertProduct.setString(4, description);
            insertProduct.setLong(5, quantity);
            insertProduct.setBoolean(6, available);
            insertProduct.executeUpdate();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Product inserted succesfully");
    }

    public static void getAllProducts() {

    }

    private static void connect() {
        try {
            System.out.println("Connecting to database...");
            System.out.println("URL: " + URL);
            connection = DriverManager.getConnection(URL);
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void disconnect() {
        try {
            System.out.println("Disconnecting from database...");
            connection.close();
            System.out.println("Disconnected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
