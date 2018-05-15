import Models.Product;
import database.ProductDatabaseImpl;
import database.PurchaseDatabaseImp;

import java.util.ArrayList;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class main {
    public static void main(String[] argv) {
        ProductDatabaseImpl productDatabaseImp = ProductDatabaseImpl.getInstance();
        PurchaseDatabaseImp purchaseDatabaseImp = PurchaseDatabaseImp.getInstance();

        productDatabaseImp.createProductTable();
        purchaseDatabaseImp.createPurchaseTable();
        purchaseDatabaseImp.createPurchaseDetailTable();


//        productDatabase.insertProduct(new Product(10, "image.path", "product name", "this is a product", 10, true));
//        productDatabase.insertProduct(new Product(10, "image.path", "product name", "this is a product", 10, false));
//
//        ArrayList<Product> allProducts1 = productDatabase.getAllProducts(true);
//        ArrayList<Product> allProducts2 = productDatabase.getAllProducts(false);
//        System.out.println(allProducts1.size());
//        System.out.println(allProducts2.size());


        System.out.println("END!");
    }
}
