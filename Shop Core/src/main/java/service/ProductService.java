package service;

import Models.Product;
import dao.ProductDAO;
import dao.ProductDAOImpl;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAOImpl();
    }

    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }

    public Product getProduct(String id) {
        return this.productDAO.getProduct(id);
    }
}
