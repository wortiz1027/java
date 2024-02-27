package co.com.demo.products.infraestructure.repository.mappers;

import co.com.demo.products.domain.database.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {


    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return new Product(
                rs.getString("PRODUCT_ID"),
                rs.getString("PRODUCT_CODE"),
                rs.getString("PRODUCT_NAME"),
                rs.getString("PRODUCT_DESCRIPTION"),
                rs.getBigDecimal("PRODUCT_PRICE"));
    }
}
