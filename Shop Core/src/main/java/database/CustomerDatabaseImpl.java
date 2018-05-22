package database;

import Models.Customer;
import Models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sguldemond on 22/05/2018.
 */
public class CustomerDatabaseImpl implements CustomerDatabase {

    private static CustomerDatabaseImpl instance = null;

    public static CustomerDatabaseImpl getInstance() {
        if(instance == null) {
            instance = new CustomerDatabaseImpl();
        }

        return instance;
    }

    @Override
    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO customer (key_hash, shipment_details) VALUES(?, ?)";

        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement insertCustomer = connection.prepareStatement(sql);
            insertCustomer.setString(1, customer.getPublicKeyHash());
            insertCustomer.setString(2, customer.getDetails());
            insertCustomer.executeUpdate();
            ConnectionHandler.disconnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Customer inserted succesfully");
    }

    @Override
    public Customer get(String hash) {
        String sql = "SELECT * FROM customer WHERE key_hash = ?";

        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement getByHash = connection.prepareStatement(sql);
            getByHash.setString(1, hash);
            ResultSet rs = getByHash.executeQuery();
            rs.next();

            long id = rs.getLong("id");
            String customer_hash = rs.getString("key_hash");
            String details = rs.getString("shipment_details");

            ConnectionHandler.disconnect(connection);
            return new Customer(id, customer_hash, details);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Customer();
        }
    }

    @Override
    public Customer get(Long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";

        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement getById = connection.prepareStatement(sql);
            getById.setLong(1, id);
            ResultSet rs = getById.executeQuery();
            rs.next();

            long customer_id = rs.getLong("id");
            String customer_hash = rs.getString("key_hash");
            String details = rs.getString("shipment_details");

            ConnectionHandler.disconnect(connection);
            return new Customer(customer_id, customer_hash, details);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Customer();
        }
    }

    @Override
    public List<Customer> getAll() {
        ArrayList<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customer";

        try {
            Connection connection = ConnectionHandler.connect();
            PreparedStatement getAllCustomers = connection.prepareStatement(sql);
            ResultSet rs = getAllCustomers.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String hash = rs.getString("key_hash");
                String details = rs.getString("shipment_details");
                customers.add(new Customer(id, hash, details));
            }
            ConnectionHandler.disconnect(connection);

            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return customers;
        }

    }

    @Override
    public void createTable() {
        String tableName = "customer";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "key_hash TEXT, " +
                "shipment_details TEXT)";

        System.out.println(sql);

        ConnectionHandler.executeStatement(sql);

        System.out.println("Table '" + tableName + "' created successfully");
    }

}
