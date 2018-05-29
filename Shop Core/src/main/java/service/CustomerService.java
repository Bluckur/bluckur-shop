package service;

import domain.Customer;

import java.util.List;

public interface CustomerService {

    public Customer getCustomer(String publicKeyHash);

    public Customer getCustomer(Long id);

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public List<Customer> getAllCustomers();


}
