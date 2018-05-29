package service;

<<<<<<< HEAD
import models.Customer;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import org.springframework.stereotype.Service;

@Service
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
=======
import domain.Customer;

import java.util.List;

public interface CustomerService {

    public Customer getCustomer(String publicKeyHash);

    public Customer getCustomer(Long id);

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public List<Customer> getAllCustomers();


>>>>>>> develop
}
