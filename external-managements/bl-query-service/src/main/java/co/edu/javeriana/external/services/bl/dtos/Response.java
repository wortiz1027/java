package co.edu.javeriana.external.services.bl.dtos;

import co.edu.javeriana.external.services.bl.domain.Passenger;
import co.edu.javeriana.external.services.bl.domain.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "Estructura del Response con el resultado de la consulta de informacion de los viajes de bolivariano")
public class Response implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica el estado de la consulta")
    private Status status;

    @ApiModelProperty(notes = "Campo que indica los pasajeros de los viajes de bolivariano")
    private List<Passenger> passengers;

}
