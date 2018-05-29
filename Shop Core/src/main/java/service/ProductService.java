package service;

import domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProduct(Long id);

    public List<Product> getProduct(String name);

    public void lowerStock(Product product, int quantity);

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

}
