package service;

<<<<<<< HEAD
import models.Product;
import models.Purchase;
import dao.PurchaseDAO;
import dao.PurchaseDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
=======
import domain.Customer;
import domain.Purchase;
>>>>>>> develop
import org.springframework.stereotype.Service;

import java.util.List;

<<<<<<< HEAD
@Service
public class PurchaseService {

    @Autowired
    private ProductService productService;
=======
public interface PurchaseService {
>>>>>>> develop

    public Purchase addPurchase(Purchase purchase);

    public List<Purchase> getAllPurchases();

    public Purchase getPurchase(Long id);

    public List<Purchase> getPurchasesBy(Customer customer);

    public List<Purchase> getUnprocessedPurchases();

    public Purchase processPurchase(Purchase purchase);
}
