package co.edu.javeriana.external.services.aa.dtos.all;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura con la informacion de entrada para consultar vuelos disponibles")
public class Request implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica el vuelos disponibles")
    protected String available;

}
