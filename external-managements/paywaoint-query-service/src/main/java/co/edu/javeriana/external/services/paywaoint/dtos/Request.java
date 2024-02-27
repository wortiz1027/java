package co.edu.javeriana.external.services.paywaoint.dtos;

import co.edu.javeriana.external.services.paywaoint.domain.CreditCard;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura con la informacion de la tarjeta de credito")
public class Request implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que contiene todo el detalle de la tarjeta de credito")
    protected CreditCard creditCard;

}
