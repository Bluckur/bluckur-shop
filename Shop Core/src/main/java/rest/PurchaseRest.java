package rest;

import models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PurchaseService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PurchaseRest {

    @Autowired
    private PurchaseService purchaseService;

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

    @RequestMapping("purchase/process/{id}")
    public boolean processPurchase(@PathParam("id") int id) {
        Purchase purchase = this.purchaseService.getPurchase(id);

        if (purchase != null) {
            return this.purchaseService.processPurchase(purchase);
        }

        return false;
    }
}
