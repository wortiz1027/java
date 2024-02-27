package co.edu.javeriana.products.application.dtos.types;

import co.edu.javeriana.products.application.dtos.Status;

import co.edu.javeriana.products.domain.ProductType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements java.io.Serializable {

    private Status status;
    private List<ProductType> types;

}
