package co.com.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyController {

    @GetMapping("/{nombre}")
    public ResponseEntity<String> saludo(@PathVariable String nombre){
        return new ResponseEntity<String>(String.format("Hola Mundo! %s", nombre),HttpStatus.OK);
    }

}