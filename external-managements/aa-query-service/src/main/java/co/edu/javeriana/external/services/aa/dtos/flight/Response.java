package co.edu.javeriana.external.services.aa.dtos.flight;

import co.edu.javeriana.external.services.aa.domain.Flight;
import co.edu.javeriana.external.services.aa.dtos.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura del Response con el resultado de la consulta de informacion de los vuelos")
public class Response implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica el estado de la consulta")
    private Status status;

    @ApiModelProperty(notes = "Entidad con la informacion del detalle del vuelo")
    private Flight flight;

}
