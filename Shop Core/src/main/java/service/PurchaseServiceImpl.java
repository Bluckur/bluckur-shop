package service;

import domain.Customer;
import domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.PurchaseRepository;

import java.util.List;

/**
 * Created by sguldemond on 29/05/2018.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    @Override
    public Purchase addPurchase(Purchase purchase) {
        return repository.save(purchase);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return repository.findAll();
    }

    @Override
    public Purchase getPurchase(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Purchase> getPurchasesBy(Customer customer) {
        return repository.findAllByCustomer(customer);
    }

    @Override
    public List<Purchase> getUnprocessedPurchases() {
        return repository.findAllByProcessedFalse();
    }

    @Override
    public Purchase processPurchase(Purchase purchase) {
        return repository.save(purchase);
    }
}
