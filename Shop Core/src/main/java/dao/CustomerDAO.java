package dao;

import Models.Customer;

public interface CustomerDAO {
    Customer getCustomer(String publicKeyHash);
}
