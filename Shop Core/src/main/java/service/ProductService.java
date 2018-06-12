package service;

import domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct(Long id);

    List<Product> getProduct(String name);

    void lowerStock(Product product, int quantity);

    Product addProduct(Product product);

    Product updateProduct(Product product);

}
