package dao;

import Models.Customer;

public interface CustomerDAO {
    Customer getCustomer(String publicKeyHash);

    int addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);
}
