package database;

import Models.Product;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class ProductDatabaseImpl implements ProductDatabase {
    private static final String DATABASE_NAME = "Products";
    private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + DATABASE_NAME;

    private static ProductDatabaseImpl instance = null;

    private static Connection connection = null;

    public static ProductDatabaseImpl getInstance() {
        if(instance == null) {
            instance = new ProductDatabaseImpl();
        }

        return instance;
    }

    private ProductDatabaseImpl() {
        createProductTable();
    }

    @Override
    public void insertProduct(Product product) {
        String sql = "INSERT INTO Products (price, image_path, product_name, description, quantity, available) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            connect();
            PreparedStatement insertProduct = connection.prepareStatement(sql);
            insertProduct.setInt(1, product.getPrice());
            insertProduct.setString(2, product.getImagePath());
            insertProduct.setString(3, product.getName());
            insertProduct.setString(4, product.getDescription());
            insertProduct.setInt(5, product.getQuantity());
            insertProduct.setBoolean(6, product.isAvailable());
            insertProduct.executeUpdate();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Product inserted succesfully");
    }

    @Override
    public ArrayList<Product> getAllProducts(boolean available) {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM Products WHERE available = ?";

        try {
            connect();
            PreparedStatement getAllProducts = connection.prepareStatement(sql);
            getAllProducts.setBoolean(1, available);
            ResultSet rs = getAllProducts.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int price = rs.getInt("price");
                String image_path = rs.getString("image_path");
                String product_name = rs.getString("product_name");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                boolean product_available = rs.getBoolean("available");
                products.add(new Product(id, price, image_path, product_name, description, quantity, product_available));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    private static void createProductTable() {
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
