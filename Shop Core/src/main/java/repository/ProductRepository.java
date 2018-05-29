package repository;

import Models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sguldemond on 29/05/2018.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
}
