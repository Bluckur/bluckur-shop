package service;

import Models.Product;
import Models.Purchase;
import dao.PurchaseDAO;
import dao.PurchaseDAOImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseService {
    private ProductService productService;

    private PurchaseDAO purchaseDAO;


    public PurchaseService() {
        this.productService = new ProductService();

        this.purchaseDAO = new PurchaseDAOImpl();
    }

    public List<Purchase> getAllPurchases() {
        return this.purchaseDAO.getAllPurchases();
    }

    public Purchase getPurchase(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be a negative value.");
        }

        return this.purchaseDAO.getPurchase(id);
    }

    public List<Purchase> getPurchasesBy(String publicKeyHash) {
        if (publicKeyHash == null || publicKeyHash.isEmpty()) {
            throw new IllegalArgumentException("publicKeyHash can neither be null nor empty.");
        }

        return this.purchaseDAO.getPurchasesBy(publicKeyHash);
    }

    public List<Purchase> getUnprocessedPurchases() {
        return this.purchaseDAO.getAllPurchases().stream()
                .filter(purchase -> !purchase.isProcessed())
                .collect(Collectors.toList());
    }

    public boolean processPurchase(Purchase purchase) {
        if (purchase == null) {
            throw new IllegalArgumentException("purchase cannot be null.");
        }
        
        if (purchase.isProcessed()) {
            return false;
        }

        purchase.setProcessed(true);

        for(Map.Entry<Product, Integer> productQuantity : purchase.getProducts().entrySet()) {
            Product product = productQuantity.getKey();
            int quantity = productQuantity.getValue();

            productService.lowerStock(product, quantity);
        }

        return true;
    }
}
