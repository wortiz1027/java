package co.edu.javeriana.external.services.avianca.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Estructura del Request con los datos para consultar la informacion de los vuelos de avianca")
public class Request {

    @ApiModelProperty(notes = "Campo que indica la fecha de partida")
    private Date departureDate;

    @ApiModelProperty(notes = "Campo que indica el lugar de destino")
    private String destinationCityDescription;

    @ApiModelProperty(notes = "Campo que indica si es vuelo sin retorno")
    private Boolean oneWay;

    @ApiModelProperty(notes = "Campo que indica el lugar de origen")
    private String originCityDescription;

    @ApiModelProperty(notes = "Campo que indica el numero de pasajeros")
    private Integer passengersNumber;

    @ApiModelProperty(notes = "Campo que indica la fecha de regreso")
    private Date returnDate;

}
