package dao;

import Models.Customer;
import Models.Product;
import Models.Purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseDAOImpl implements PurchaseDAO {

    private List<Purchase> purchaseMocks;

    public PurchaseDAOImpl() {
        this.purchaseMocks = new ArrayList<>();
        Product product1 = new Product(1, 12, "/img/products/0001/001", "Java Sleutelhanger", "Flitse flexe sleutelhanger met ledlampje & JTech logo.", 200);
        Product product2 = new Product(2, 20, "/img/products/0002/007", "Korting bij Artis", "20 euro korting bij je volgende kaartje voor Artis.", 30);
        Customer customer1 = new Customer("publickeyhash1", "Schoolstraat 105");
        List<Product> productsList1 = new ArrayList<>();
        productsList1.add(product1);
        productsList1.add(product2);
        purchaseMocks.add(new Purchase(1, 40, customer1, productsList1));
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return this.purchaseMocks;
    }

    @Override
    public Purchase getPurchase(int id) {
        return this.purchaseMocks.stream()
                .filter(purchase -> purchase.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Purchase> getPurchasesBy(String publicKeyHash) {
        return this.purchaseMocks.stream()
                .filter(purchase -> purchase.getCustomer().getPublicKeyHash() == publicKeyHash)
                .collect(Collectors.toList());
    }
}
