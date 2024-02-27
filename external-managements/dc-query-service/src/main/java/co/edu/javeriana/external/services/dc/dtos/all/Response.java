package co.edu.javeriana.external.services.dc.dtos.all;

import co.edu.javeriana.external.services.dc.domain.Reserva;
import co.edu.javeriana.external.services.dc.domain.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "Estructura con la informacion de la respuesta de reservas del hotel dan carlton")
public class Response implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica la informacion del estado de la transaccion")
    private Status status;

    @ApiModelProperty(notes = "Campo que indica las reservas disponibles para el hotel dan carlton")
    private List<Reserva> reservas;

}
