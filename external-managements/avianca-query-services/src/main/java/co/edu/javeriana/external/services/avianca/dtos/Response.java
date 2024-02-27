package co.edu.javeriana.external.services.avianca.dtos;
import co.edu.javeriana.external.services.avianca.domain.AvalaibleFlight;
import co.edu.javeriana.external.services.avianca.dtos.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Estructura del Response con el resultado de la consulta de informacion de los vuelos")
public class Response implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica el estado de la consulta")
    private Status status;

    @ApiModelProperty(notes = "Campo que indica los vuelos de salida disponibles")
    private List<AvalaibleFlight> departureFlights;

    @ApiModelProperty(notes = "Campo que indica los vuelos de regreso disponibles")
    private List<AvalaibleFlight> returnFlights;

}
