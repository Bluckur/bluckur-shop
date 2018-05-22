package service;

import Models.Purchase;
import dao.PurchaseDAO;
import dao.PurchaseDAOImpl;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseService {
    private PurchaseDAO purchaseDAO;

    public PurchaseService() {
        this.purchaseDAO = new PurchaseDAOImpl();
    }

    public List<Purchase> getAllPurchases() {
        return this.purchaseDAO.getAllPurchases();
    }

    public Purchase getPurchase(int id) {
        return this.purchaseDAO.getPurchase(id);
    }

    public List<Purchase> getPurchasesBy(String publicKeyHash) {
        return this.purchaseDAO.getPurchasesBy(publicKeyHash);
    }

    public List<Purchase> getUnprocessedPurchases() {
        return this.purchaseDAO.getAllPurchases().stream()
                .filter(purchase -> !purchase.isProcessed())
                .collect(Collectors.toList());
    }
}
