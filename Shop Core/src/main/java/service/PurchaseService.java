package service;

import Models.Product;
import dao.PurchaseDAO;
import dao.PurchaseDAOImpl;

import java.util.List;

public class PurchaseService {
    private PurchaseDAO purchaseDAO;

    public PurchaseService() {
        this.purchaseDAO = new PurchaseDAOImpl();
    }

    public List<Product> getAllPurchases() {
        return this.purchaseDAO.getAllPurchases();
    }

    public Product getPurchase(String id) {
        return this.purchaseDAO.getPurchase(id);
    }

    public List<Product> getPurchasesBy(String publicKeyHash) {
        return this.purchaseDAO.getPurchasesBy(publicKeyHash);
    }
}
