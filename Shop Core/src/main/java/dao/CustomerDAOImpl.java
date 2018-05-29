package dao;

import models.Customer;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer getCustomer(String publicKeyHash) {
        return new Customer(publicKeyHash, "Rachelsmolen R1 Eindhoven\np.janissen@student.fontys.nl");
    }

    @Override
    public int addCustomer(Customer customer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        throw new UnsupportedOperationException();
    }
}
