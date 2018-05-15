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
        return this.customerDAO.getCustomer(publicKeyHash);
    }
}
