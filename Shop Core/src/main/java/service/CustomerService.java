package service;

import Models.Customer;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAOImpl();
    }

    public Customer getCustomer(String publicKeyHash) {
        if (publicKeyHash == null || publicKeyHash.isEmpty()) {
            throw new IllegalArgumentException("publicKeyHash can neither be null nor empty.");
        }
        return this.customerDAO.getCustomer(publicKeyHash);
    }
}
