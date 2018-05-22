import Models.Customer;
import Models.Product;
import Models.Purchase;
import database.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class main {
    public static void main(String[] argv) {
        ProductDatabase productDatabase = ProductDatabaseImpl.getInstance();
        CustomerDatabase customerDatabase = CustomerDatabaseImpl.getInstance();
        PurchaseDatabase purchaseDatabase = PurchaseDatabaseImp.getInstance();

        productDatabase.createTable();
        customerDatabase.createTable();
        purchaseDatabase.createTable();


        Product product1 = new Product(10, "image.path1", "product name1", "this is a product1", 20, true);
        Product product2 = new Product(5, "image.path2", "product name2", "this is a product2", 10, false);
        Map<Product, Integer> products = new HashMap<>();

        productDatabase.insertProduct(product1);
        productDatabase.insertProduct(product2);

        product1 = productDatabase.get(1l);
        product2 = productDatabase.get(2l);

        products.put(product1, 1);
        products.put(product2, 3);

        Customer customer1 = new Customer("test_hash", "test_details");
        customerDatabase.insertCustomer(customer1);
        customer1 = customerDatabase.get(1l);


        Purchase purchase1 = new Purchase(customer1, products);

        purchaseDatabase.insertPurchase(purchase1);

        Purchase purchase = purchaseDatabase.get(1l);

        System.out.println("END!");
    }
}
