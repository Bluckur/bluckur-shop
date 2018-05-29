package rest;

import domain.Customer;
import domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.PurchaseService;
import service.PurchaseServiceImpl;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PurchaseRest {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("purchase/get/all")
    public List<Purchase> getAllPurchases() {
        return this.purchaseService.getAllPurchases();
    }

    @RequestMapping("purchase/get/{id}")
    public Purchase getPurchase(@PathVariable("id") Long id) {
        return this.purchaseService.getPurchase(id);
    }

    @RequestMapping("purchase/get/by/{publicKeyHash}")
    public List<Purchase> getPurchasesBy(@PathVariable("publicKeyHash") String publicKeyHash) {
        Customer customer = customerService.getCustomer(publicKeyHash);

        return this.purchaseService.getPurchasesBy(customer);
    }

    @RequestMapping("purchase/get/unprocessed")
    public List<Purchase> getUnprocessedPurchases() {
        return this.purchaseService.getUnprocessedPurchases();
    }

    @RequestMapping("purchase/process/{id}")
    public Purchase processPurchase(@PathParam("id") Long id) {
        Purchase purchase = this.purchaseService.getPurchase(id);

        if (purchase != null) {
            return this.purchaseService.processPurchase(purchase);
        }

        return new Purchase();
    }
}
