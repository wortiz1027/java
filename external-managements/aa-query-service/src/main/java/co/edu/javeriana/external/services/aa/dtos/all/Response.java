package co.edu.javeriana.external.services.aa.dtos.all;

import co.edu.javeriana.external.services.aa.domain.Flight;
import co.edu.javeriana.external.services.aa.dtos.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "Estructura con la informacion de los vuelos de american airlines")
public class Response implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica el estado de la consulta")
    private Status status;

    @ApiModelProperty(notes = "Listado con la informacion de los vuelos de american airlines")
    private List<Flight> flights;

}
