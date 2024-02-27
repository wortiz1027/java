package co.com.demo.products.application;

import co.com.demo.products.domain.database.Product;
import co.com.demo.products.exceptions.bussines.ProductCodeEmptyOrNullExpection;
import co.com.demo.products.exceptions.bussines.ProductNotFoundException;
import co.com.demo.products.infraestructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductBehavior {

    private final ProductRepository repository;

    @Override
    public Optional<List<Product>> getProductByCode(String codes) {
        if (codes.isEmpty()) throw new ProductCodeEmptyOrNullExpection("Product code can not be null or empty");

        List<String> ids = Arrays.asList(codes.split(","));
        List<Product> products = new ArrayList<>();

        for (String row : ids) {
            Optional<Product> product = this.repository.findByCode(row);
            products.add(product.get());
        }

        return Optional.of(products);
    }

    @Override
    public Optional<List<Product>> getAllProducts() {
        Optional<List<Product>> products = this.repository.findAlls();

        if (products.isEmpty()) throw new ProductNotFoundException("There is no products registers");

        return products;
    }
}
