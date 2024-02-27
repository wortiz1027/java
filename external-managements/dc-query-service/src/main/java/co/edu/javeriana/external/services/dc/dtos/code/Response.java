package co.edu.javeriana.external.services.dc.dtos.code;

import co.edu.javeriana.external.services.dc.domain.Reserva;
import co.edu.javeriana.external.services.dc.domain.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura con la informacion de la respuesta de la reserva consultada por codigo")
public class Response implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica la informacion del estado de la transaccion")
    private Status status;

    @ApiModelProperty(notes = "Campo que indica el detalle de la reserva por codigo")
    private Reserva reserva;

}
