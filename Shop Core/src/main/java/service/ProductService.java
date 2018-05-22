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
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID can neither be null nor empty");
        }

        return this.productDAO.getProduct(id);
    }

    protected void lowerStock(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product can not be null.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        product.setQuantity(product.getQuantity() - quantity);
        productDAO.updateProduct(product);
    }

    public int addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can not be null.");
        }

        return this.productDAO.addProduct(product);
    }

    public Product updateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can not be null.");
        }

        return this.productDAO.updateProduct(product);
    }
}
