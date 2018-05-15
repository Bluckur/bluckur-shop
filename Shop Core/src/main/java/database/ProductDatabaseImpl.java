package database;

import Models.Product;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class ProductDatabaseImpl implements ProductDatabase {
    private static ProductDatabaseImpl instance = null;
    private static Connection connection = null;

    public static ProductDatabaseImpl getInstance() {
        if(instance == null) {
            instance = new ProductDatabaseImpl();
        }

        return instance;
    }

    @Override
    public void insertProduct(Product product) {
        String sql = "INSERT INTO Products (price, image_path, product_name, description, quantity, available) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionHandler.connect();
            PreparedStatement insertProduct = connection.prepareStatement(sql);
            insertProduct.setInt(1, product.getPrice());
            insertProduct.setString(2, product.getImagePath());
            insertProduct.setString(3, product.getName());
            insertProduct.setString(4, product.getDescription());
            insertProduct.setInt(5, product.getQuantity());
            insertProduct.setBoolean(6, product.isAvailable());
            insertProduct.executeUpdate();
            ConnectionHandler.disconnect(connection);
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
            connection = ConnectionHandler.connect();
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
            ConnectionHandler.disconnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void createProductTable() {
        String tableName = "product";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "price INT, " +
                "image_path VARCHAR(255), " +
                "product_name VARCHAR(255), " +
                "description TEXT, " +
                "quantity INT, " +
                "available INT)";

        ConnectionHandler.executeStatement(sql, connection);

        System.out.println("Table '" + tableName + "' created successfully");
    }
}
