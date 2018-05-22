package rest;

import Models.Purchase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<Purchase> getAllPurchases() {
        return this.purchaseService.getAllPurchases();
    }

    @RequestMapping("purchase/get/{id}")
    public Purchase getPurchase(@PathVariable("id") int id) {
        return this.purchaseService.getPurchase(id);
    }

    @RequestMapping("purchase/get/by/{publicKeyHash}")
    public List<Purchase> getPurchasesBy(@PathVariable("publicKeyHash") String publicKeyHash) {
        return this.purchaseService.getPurchasesBy(publicKeyHash);
    }

    @RequestMapping("purchase/get/unprocessed")
    public List<Purchase> getUnprocessedPurchases() {
        return this.purchaseService.getUnprocessedPurchases();
    }
}
