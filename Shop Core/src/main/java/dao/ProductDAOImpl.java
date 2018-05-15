package dao;

import Models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, 12, "/img/products/0001/001", "Java Sleutelhanger", "Flitse flexe sleutelhanger met ledlampje & JTech logo.", 200));
        return products;
    }

    @Override
    public Product getProduct(String id) {
        return new Product(Integer.parseInt(id), 12, "/img/products/0001/001", "Java Sleutelhanger", "Flitse flexe sleutelhanger met ledlampje & JTech logo.", 200);
    }
}
