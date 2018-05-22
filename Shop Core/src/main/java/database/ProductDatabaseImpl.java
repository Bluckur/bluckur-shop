package database;

import Models.Product;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class ProductDatabaseImpl implements ProductDatabase {
    private static ProductDatabaseImpl instance = null;

    public static ProductDatabaseImpl getInstance() {
        if(instance == null) {
            instance = new ProductDatabaseImpl();
        }

        return instance;
    }

    @Override
    public void insertProduct(Product product) {
        String sql = "INSERT INTO product (price, image_path, product_name, description, quantity, available) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = ConnectionHandler.connect();
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
    public Product get(Long id) {
        String sql = "SELECT * FROM product WHERE id = ?";

        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement getById = connection.prepareStatement(sql);
            getById.setLong(1, id);
            ResultSet rs = getById.executeQuery();
            rs.next();

            int product_id = rs.getInt("id");
            int price = rs.getInt("price");
            String image_path = rs.getString("image_path");
            String product_name = rs.getString("product_name");
            String description = rs.getString("description");
            int quantity = rs.getInt("quantity");
            boolean product_available = rs.getBoolean("available");

            ConnectionHandler.disconnect(connection);
            return new Product(product_id, price, image_path, product_name, description, quantity, product_available);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Product();
        }
    }

    @Override
    public ArrayList<Product> getAll(boolean available) {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM product WHERE available = ?";

        try {
            Connection connection = ConnectionHandler.connect();
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

            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return products;
        }
    }

    @Override
    public void createTable() {
        String tableName = "product";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "price INT, " +
                "image_path VARCHAR(255), " +
                "product_name VARCHAR(255), " +
                "description TEXT, " +
                "quantity INT, " +
                "available INT)";

        ConnectionHandler.executeStatement(sql);

        System.out.println("Table '" + tableName + "' created successfully");
    }
}
