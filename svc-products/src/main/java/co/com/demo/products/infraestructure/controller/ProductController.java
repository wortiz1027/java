package co.com.demo.products.infraestructure.controller;

import co.com.demo.products.application.ProductBehavior;
import co.com.demo.products.domain.controller.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductBehavior services;

    @GetMapping("/products")
    public ResponseEntity<Response> products() {
        Response response = new Response();
        response.setProducts(services.getAllProducts().get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Response> productsByCode(@RequestParam(required = true) String codes) {
        Response response = new Response();
        response.setProducts(services.getProductByCode(codes).get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
