package service;

import domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(String publicKeyHash);

    Customer getCustomer(Long id);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    List<Customer> getAllCustomers();
}
