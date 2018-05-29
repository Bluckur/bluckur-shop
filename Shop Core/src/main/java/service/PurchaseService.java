package service;

import domain.Customer;
import domain.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PurchaseService {

    public Purchase addPurchase(Purchase purchase);

    public List<Purchase> getAllPurchases();

    public Purchase getPurchase(Long id);

    public List<Purchase> getPurchasesBy(Customer customer);

    public List<Purchase> getUnprocessedPurchases();

    public Purchase processPurchase(Purchase purchase);
}
