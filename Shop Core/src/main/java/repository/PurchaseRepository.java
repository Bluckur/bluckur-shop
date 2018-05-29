package repository;

import domain.Customer;
import domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sguldemond on 29/05/2018.
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    public List<Purchase> findAllByProcessedFalse();

    public List<Purchase> findAllByCustomer(Customer customer);
}
