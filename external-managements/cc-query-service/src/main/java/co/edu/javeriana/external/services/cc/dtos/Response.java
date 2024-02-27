package co.edu.javeriana.external.services.cc.dtos;

import co.edu.javeriana.external.services.cc.domain.CreditCard;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura con la informacion de la respuesta con informacion de la tarjeta de credito")
public class Response implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica la informacion del estado de la transaccion")
    private Status status;

    @ApiModelProperty(notes = "Estructura que reporta el detalle de la informacion de la tarjeta de credito")
    private CreditCard creditCard;

}
