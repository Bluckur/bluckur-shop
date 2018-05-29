package application;

<<<<<<< HEAD
=======
import domain.Customer;
import domain.Product;
import domain.ProductLine;
import domain.Purchase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.ProductRepository;
import service.CustomerService;
import service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
>>>>>>> develop
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dao", "models", "rest", "service"})
public class Application {
=======
import org.springframework.beans.factory.annotation.Autowired;
import service.PurchaseService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = { "rest", "service", "repository" })
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


>>>>>>> develop
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) {
        log.info("START TEST");

        Product productMug = productService.addProduct(new Product(1, "image path 1", "mug", "to drink from", 100));
        Product productShirt = productService.addProduct(new Product(2, "image path 2", "shirt", "to wear", 20));
        Product productCar = productService.addProduct(new Product(3, "image path 3", "car", "to drive", 1));

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

        Customer customer = customerService.getCustomer("123");
        log.info(customer.getDetails());

        log.info("END TEST");
    }
}