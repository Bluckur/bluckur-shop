package controller;

import domain.Customer;
import domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CustomerService;
import service.PurchaseService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("purchase/get/all")
    public ResponseEntity getAllPurchases() {
        List<Purchase> allPurchases = this.purchaseService.getAllPurchases();
        return new ResponseEntity(allPurchases, HttpStatus.OK);
    }

    @RequestMapping("purchase/get/{id}")
    public ResponseEntity getPurchase(@PathVariable("id") Long id) {
        Purchase purchase = this.purchaseService.getPurchase(id);
        return new ResponseEntity(purchase, HttpStatus.OK);
    }

    @RequestMapping("purchase/get/by/{publicKeyHash}")
    public ResponseEntity getPurchasesBy(@PathVariable("publicKeyHash") String publicKeyHash) {
        Customer customer = customerService.getCustomer(publicKeyHash);
        List<Purchase> purchasesBy = this.purchaseService.getPurchasesBy(customer);
        return new ResponseEntity(purchasesBy, HttpStatus.OK);
    }

    @RequestMapping("purchase/get/unprocessed")
    public ResponseEntity getUnprocessedPurchases() {
        List<Purchase> unprocessedPurchases = this.purchaseService.getUnprocessedPurchases();
        return new ResponseEntity(unprocessedPurchases, HttpStatus.OK);
    }

    @RequestMapping("purchase/process/{id}")
    public ResponseEntity processPurchase(@PathParam("id") Long id) {
        Purchase purchase = this.purchaseService.getPurchase(id);
        return new ResponseEntity(purchase, HttpStatus.OK);

    }
}
