package service;

<<<<<<< HEAD
import models.Product;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;
=======
import domain.Product;

import java.util.List;

public interface ProductService {
>>>>>>> develop

    public List<Product> getAllProducts();

    public Product getProduct(Long id);

    public List<Product> getProduct(String name);

    public void lowerStock(Product product, int quantity);

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

}
