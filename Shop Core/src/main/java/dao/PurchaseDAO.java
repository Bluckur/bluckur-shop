package dao;

import Models.Purchase;

import java.util.List;

public interface PurchaseDAO {
    List<Purchase> getAllPurchases();

    Purchase getPurchase(int id);

    List<Purchase> getPurchasesBy(String publicKeyHash);
}
