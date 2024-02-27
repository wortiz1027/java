package co.edu.javeriana.external.services.paywaoint.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura con la informacion de la respuesta de la tarjeta de credito")
public class Response implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica la informacion del estado de la transaccion")
    private Status status;

    @ApiModelProperty(notes = "Campo que indica el resultado de la transaccion")
    private boolean result;

}
