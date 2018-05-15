package database;

import Models.Purchase;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by sguldemond on 15/05/2018.
 */
public interface PurchaseDatabase {
    void insertPurchase(Purchase purchase);
    ArrayList<Purchase> getAllPurchases();
}
