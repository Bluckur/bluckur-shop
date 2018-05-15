package dao;

import Models.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();

    Product getProduct(String id);
}
