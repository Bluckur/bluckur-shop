package database;

import Models.Customer;
import Models.Product;
import Models.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class PurchaseDatabaseImp implements PurchaseDatabase {
    private static PurchaseDatabaseImp instance = null;

    public static PurchaseDatabaseImp getInstance() {
        if(instance == null) {
            instance = new PurchaseDatabaseImp();
        }

        return instance;
    }

    @Override
    public void insertPurchase(Purchase purchase) {
        if(purchase.getCustomer().getId() == null) {
            System.out.println("Customer is not yet persisted");
            return;
        }

        String sql = "INSERT INTO purchase (costumer_id, approved, total_amount, purchase_time, processed) VALUES(?, ?, ?, ?, ?)";
        Long purchaseId = null;

        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement insertPurchase = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            insertPurchase.setLong(1, purchase.getCustomer().getId());
            insertPurchase.setBoolean(2, purchase.isApproved());
            insertPurchase.setLong(3, purchase.getTotalAmount());
            insertPurchase.setLong(4, purchase.getTimestamp());
            insertPurchase.setBoolean(5, purchase.isProcessed());
            insertPurchase.executeUpdate();

            ResultSet generatedKeys = insertPurchase.getGeneratedKeys();
            if(generatedKeys.next()) {
                purchaseId = generatedKeys.getLong(1);
            }

            ConnectionHandler.disconnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Map.Entry<Product, Integer> product : purchase.getProducts().entrySet()) {
            insertPurchaseDetail(purchaseId, Integer.toUnsignedLong(product.getKey().getId()), product.getValue().longValue());
        }

        System.out.println("Purchase inserted succesfully");
    }

    private void insertPurchaseDetail(Long purchaseId, Long productId, Long quantity) {
        if(productId == null) {
            System.out.println("Product is not yet persisted");
            return;
        }

        String sql = "INSERT INTO purchase_detail (purchase_id, product_id, quantity) VALUES(?, ?, ?)";

        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement insertPurchaseDetail = connection.prepareStatement(sql);
            insertPurchaseDetail.setLong(1, purchaseId);
            insertPurchaseDetail.setLong(2, productId);
            insertPurchaseDetail.setLong(3, quantity);
            insertPurchaseDetail.executeUpdate();

            ConnectionHandler.disconnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Purchase get(Long id) {
        String sql = "SELECT * FROM purchase AS p INNER JOIN customer AS c ON p.costumer_id = c.id WHERE p.id = ?";
        Purchase purchase = null;

        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement getById = connection.prepareStatement(sql);
            getById.setLong(1, id);
            ResultSet rs = getById.executeQuery();
            rs.next();

            int p_id = rs.getInt(1);
            boolean p_approved = rs.getBoolean("approved");
            int p_total_amount = rs.getInt("total_amount");
            Long p_purchase_time = rs.getLong("purchase_time");
            boolean p_processed = rs.getBoolean("processed");

            Long c_id = rs.getLong(7);
            String c_hash = rs.getString("key_hash");
            String c_details = rs.getString("shipment_details");

            Customer customer = new Customer(c_id, c_hash, c_details);
            purchase = new Purchase(p_id, p_total_amount, customer, p_approved, p_processed, null, p_purchase_time);

            ConnectionHandler.disconnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchase;
    }

    private void getPurchaseDetail(Long purchaseId) {
        String sql = "SELECT * FROM purchase_detail WHERE purchase_id = ?";
        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement getByPurchaseId = connection.prepareStatement(sql);
            getByPurchaseId.setLong(1, purchaseId);
            ResultSet rs = getByPurchaseId.executeQuery();

            while(rs.next()) {
                rs.getLong("")
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public ArrayList<Purchase> getAll() {
        return null;
    }

    @Override
    public void createTable() {
        createPurchaseTable();
        createPurchaseDetailTable();
    }

    private void createPurchaseTable() {
        String tableName = "purchase";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "costumer_id REFERENCES customer(id) , " +
                "approved INT, " +
                "total_amount INT, " +
                "purchase_time INT, " +
                "processed INT)";

        System.out.println(sql);

        ConnectionHandler.executeStatement(sql);

        System.out.println("Table '" + tableName + "' created successfully");
    }

    private void createPurchaseDetailTable() {
        String tableName = "purchase_detail";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(purchase_id REFERENCES purchase(id), " +
                "product_id REFERENCES product(id), " +
                "quantity INT)";

        System.out.println(sql);

        ConnectionHandler.executeStatement(sql);

        System.out.println("Table '" + tableName + "' created successfully");
    }

}
