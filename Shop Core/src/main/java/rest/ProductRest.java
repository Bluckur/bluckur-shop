package rest;

import Models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;

import java.util.List;

@RestController
public class ProductRest {

    private ProductService productService;

    public ProductRest() {
        this.productService = new ProductService();
    }

    @RequestMapping("product/get/all")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @RequestMapping("product/get/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return this.productService.getProduct(id);
    }

    @RequestMapping(value = "product/add", method = RequestMethod.POST)
    public int addProduct(Product product) {
        return this.productService.addProduct(product);
    }

    @RequestMapping(value = "product/update", method = RequestMethod.POST)
    public Product updateProduct(Product product) {
        return this.productService.updateProduct(product);
    }
}
