package dao;

import models.Purchase;

import java.util.List;

public interface PurchaseDAO {
    List<Purchase> getAllPurchases();

    Purchase getPurchase(int id);

    List<Purchase> getPurchasesBy(String publicKeyHash);

    int addPurchase(Purchase purchase);

    Purchase updatePurchase(Purchase purchase);
}
