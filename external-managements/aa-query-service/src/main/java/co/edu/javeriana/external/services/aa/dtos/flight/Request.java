package co.edu.javeriana.external.services.aa.dtos.flight;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura del Request con la informacion de la ciudad a consultar los vuelos disponibles")
public class Request implements java.io.Serializable {

    @ApiModelProperty(notes = "Ciudad a consultar vuelos")
    private String city;

}
