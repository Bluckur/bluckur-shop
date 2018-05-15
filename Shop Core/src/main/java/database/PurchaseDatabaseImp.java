package database;

import Models.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by sguldemond on 15/05/2018.
 */
public class PurchaseDatabaseImp implements PurchaseDatabase {
    private static PurchaseDatabaseImp instance = null;
    private static Connection connection = null;

    public static PurchaseDatabaseImp getInstance() {
        if(instance == null) {
            instance = new PurchaseDatabaseImp();
        }

        return instance;
    }

    @Override
    public void insertPurchase(Purchase purchase) {
    }

    @Override
    public ArrayList<Purchase> getAllPurchases() {
        return null;
    }

    public void createPurchaseTable() {
        String tableName = "purchase";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "costumer_hash TEXT, " +
                "approved INT, " +
                "total_amount INT, " +
                "purchase_time INT, " +
                "processed INT)";

        ConnectionHandler.executeStatement(sql, connection);

        System.out.println("Table '" + tableName + "' created successfully");
    }

    public void createPurchaseDetailTable() {
        String tableName = "purchase_detail";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(FOREIGN KEY (purchase_id) REFERENCES purchase(id), " +
                "(FOREIGN KEY (product_id) REFERENCES product(id), " +
                "quantity INT)";

        ConnectionHandler.executeStatement(sql, connection);

        System.out.println("Table '" + tableName + "' created successfully");
    }

}
