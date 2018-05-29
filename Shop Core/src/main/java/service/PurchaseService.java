package service;


import domain.Customer;
import domain.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {

    Purchase addPurchase(Purchase purchase);

    List<Purchase> getAllPurchases();

    Purchase getPurchase(Long id);

    List<Purchase> getPurchasesBy(Customer customer);

    List<Purchase> getUnprocessedPurchases();

    Purchase processPurchase(Purchase purchase);
}
