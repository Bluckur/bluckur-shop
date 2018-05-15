package dao;

import Models.Customer;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer getCustomer(String publicKeyHash) {
        return new Customer(publicKeyHash, "Rachelsmolen R1 Eindhoven\np.janissen@student.fontys.nl");
    }
}
