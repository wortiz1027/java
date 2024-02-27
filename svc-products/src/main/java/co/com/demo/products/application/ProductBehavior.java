package co.com.demo.products.application;

import co.com.demo.products.domain.database.Product;

import java.util.List;
import java.util.Optional;

public interface ProductBehavior {

    Optional<List<Product>> getProductByCode(String code);
    Optional<List<Product>> getAllProducts();

}
