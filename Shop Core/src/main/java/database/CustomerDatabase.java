package database;

import Models.Customer;

import java.util.List;

/**
 * Created by sguldemond on 22/05/2018.
 */
public interface CustomerDatabase {
    void insertCustomer(Customer customer);
    Customer get(Long id);
    Customer get(String hash);
    List<Customer> getAll();
    void createTable();
}
