package co.com.demo.products.domain.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements java.io.Serializable {

    private String id;
    private String Code;
    private String name;
    private String description;
    private BigDecimal price;

}