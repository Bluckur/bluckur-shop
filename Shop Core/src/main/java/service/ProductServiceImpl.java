package service;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by sguldemond on 29/05/2018.
 */
@Service
//@ComponentScan(basePackageClasses = { ProductRepository.class })
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Product> getProduct(String name) {
        return repository.findByName(name);
    }

    @Override
    public void lowerStock(Product product, int quantity) {
        throw new NotImplementedException();
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
}
