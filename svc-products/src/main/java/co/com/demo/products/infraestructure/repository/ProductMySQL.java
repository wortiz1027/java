package co.com.demo.products.infraestructure.repository;

import co.com.demo.products.domain.database.Product;
import co.com.demo.products.infraestructure.repository.mappers.ProductRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductMySQL implements ProductRepository {

    private final JdbcTemplate template;

    @Override
    public Optional<Product> findByCode(String code) {
        try {
            String sql = "SELECT * " +
                    "FROM PRODUCTS B " +
                    "WHERE PRODUCT_CODE = ?";

            return template.queryForObject(sql,
                    new Object[]{code},
                    (rs, rowNum) ->
                            Optional.of(new Product(
                                            rs.getString("PRODUCT_ID"),
                                            rs.getString("PRODUCT_CODE"),
                                            rs.getString("PRODUCT_NAME"),
                                            rs.getString("PRODUCT_DESCRIPTION"),
                                            rs.getBigDecimal("PRODUCT_PRICE")
                                    )
                            )
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Product>> findAlls() {
        try {
            String sql = "SELECT * " +
                         "FROM PRODUCTS C " ;

            List<Product> clients = template.query(sql, new ProductRowMapper());
            return Optional.of(clients);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
