package controller;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/get/all")
    public ResponseEntity getAllProducts() {
        List<Product> allProducts = this.productService.getAllProducts();
        return new ResponseEntity(allProducts, HttpStatus.OK);
    }

    @RequestMapping("/product/get/{id}")
    public ResponseEntity getProduct(@PathVariable("id") String id) {
        Product getProduct = this.productService.getProduct(Long.parseLong(id));
        return new ResponseEntity(getProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public ResponseEntity addProduct(@RequestBody Product product) {
        Product addProduct = this.productService.addProduct(product);
        return new ResponseEntity(addProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public ResponseEntity updateProduct(@RequestBody Product product) {
        Product updateProduct = this.productService.updateProduct(product);
        return new ResponseEntity(updateProduct, HttpStatus.OK);
    }
}
