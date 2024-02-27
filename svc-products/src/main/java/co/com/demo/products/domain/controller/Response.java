package co.com.demo.products.domain.controller;

import co.com.demo.products.domain.database.Product;
import lombok.Data;

import java.util.List;

@Data
public class Response implements java.io.Serializable {

    private List<Product> products;

}