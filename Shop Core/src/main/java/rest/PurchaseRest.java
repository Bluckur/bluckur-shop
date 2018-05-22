package rest;

import Models.Customer;
import Models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.PurchaseService;

import java.util.List;

@RestController
public class PurchaseRest {
    private PurchaseService purchaseService;

    public PurchaseRest() {
        this.purchaseService = new PurchaseService();
    }

    @RequestMapping("purchase/get/all")
    public List<Product> getAllProducts() {
        return this.purchaseService.getAllPurchases();
    }

    @RequestMapping("purchase/get/{id}")
    public Product getPurchase(@PathVariable("id") String id) {
        return this.purchaseService.getPurchase(id);
    }

    @RequestMapping("purchase/get/by/{publicKeyHash}")
    public List<Product> getPurchasesBy(@PathVariable("publicKeyHash") String publicKeyHash) {
        return this.purchaseService.getPurchaseBy(publicKeyHash);
    }
}
