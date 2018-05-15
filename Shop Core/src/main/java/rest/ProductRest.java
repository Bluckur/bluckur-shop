package rest;

import Models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
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
    public Product getProduct(@PathParam("id") String id) {
        return this.productService.getProduct(id);
    }
}
