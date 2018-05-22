package database;

import Models.Product;

import java.util.ArrayList;

/**
 * Created by sguldemond on 15/05/2018.
 */
public interface ProductDatabase {
    void insertProduct(Product product);
    Product get(Long id);
    ArrayList<Product> getAll(boolean available);
    void createTable();
}
