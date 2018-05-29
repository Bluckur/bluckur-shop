package repository;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sguldemond on 29/05/2018.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByPublicKeyHash(String publicKeyHash);
}
