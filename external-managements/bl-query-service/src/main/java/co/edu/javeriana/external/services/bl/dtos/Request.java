package co.edu.javeriana.external.services.bl.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura del Request con informacion de las solicitudes para viajes de bolivariano")
public class Request implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica los valores a consultar")
    private String key;
    
}
