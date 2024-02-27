package co.edu.javeriana.external.services.cc.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura con la informacion de la tarjeta de credito del cliente")
public class CreditCard implements java.io.Serializable{

    @ApiModelProperty(notes = "Campo que indica el franquicia de la tarjeta de credito")
    private String emisorTarjeta;

    @ApiModelProperty(notes = "Campo que indica el numero de tarjeta de credito")
    private String numero;

    @ApiModelProperty(notes = "Campo que indica el monto disponible de la tarjeta de credito")
    private double balance;

}
