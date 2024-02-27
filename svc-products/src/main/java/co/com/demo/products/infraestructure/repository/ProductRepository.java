package co.com.demo.products.infraestructure.repository;

import co.com.demo.products.domain.database.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findByCode(String code);
    Optional<List<Product>> findAlls();

}
