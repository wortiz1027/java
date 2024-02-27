package co.edu.javeriana.external.services.paywaoint.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura con la informacion de la tarjeta de credito")
public class CreditCard implements java.io.Serializable{

    @ApiModelProperty(notes = "Campo que contiene el numero de tarteja de credito")
    private String number;

    @ApiModelProperty(notes = "Campo que contiene el tipo de tarjeta de credito")
    private String type;

    @ApiModelProperty(notes = "Campo que contiene el monto a cargar en la tarjeta de credito")
    private Double mount;

}
