package service;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.util.List;

/**
 * Created by sguldemond on 29/05/2018.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer getCustomer(String publicKeyHash) {
        return repository.findByPublicKeyHash(publicKeyHash);
    }

    @Override
    public Customer getCustomer(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
