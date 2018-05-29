package rest;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;

@RestController
public class ProductRest {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/get/all")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @RequestMapping("/product/get/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return this.productService.getProduct(id);
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public Product addProduct(Product product) {
        return this.productService.addProduct(product);
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public Product updateProduct(Product product) {
        return this.productService.updateProduct(product);
    }
}
