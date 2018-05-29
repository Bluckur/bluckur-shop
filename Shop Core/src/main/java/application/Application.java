package application;

import domain.Customer;
import domain.Product;
import domain.ProductLine;
import domain.Purchase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.ProductRepository;
import service.CustomerService;
import service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import service.PurchaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication(scanBasePackageClasses = { ProductService.class, ProductRepository.class })
@EntityScan("domain")
@EnableJpaRepositories("repository")
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger("DB TEST");

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PurchaseService purchaseService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("START TEST");

        Product productMug = productService.addProduct(new Product(1000, "image path 1", "mug", "to drink from", 100));
        Product productShirt = productService.addProduct(new Product(2000, "image path 2", "shirt", "to wear", 20));
        Product productCar = productService.addProduct(new Product(3000, "image path 3", "car", "to drive", 1));

        ArrayList<ProductLine> products = new ArrayList<>();

        int i = 1;
        for(Product product : productService.getAllProducts()) {
            products.add(new ProductLine(product, i));
            log.info(product.toString());
            i++;
        }


        Customer customerStan = customerService.addCustomer(new Customer("123", "Stan"));
        Customer customerPim = customerService.addCustomer(new Customer("456", "Pim"));

        Purchase purchase = purchaseService.addPurchase(new Purchase(customerStan, products));

        List<Purchase> purchasesByStan = purchaseService.getPurchasesBy(customerStan);


        log.info("END TEST");
    }
}