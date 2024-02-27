package co.edu.javeriana.external.services.avianca.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Estructura de los vuelos disponibles de avianca")
public class AvalaibleFlight {

    @ApiModelProperty(notes = "Campo que indica la informacion de la aerolinea")
    @JsonProperty("airLine")
    protected String airLine;

    @ApiModelProperty(notes = "Campo que indica el valor del vuelo")
    @JsonProperty("amount")
    protected Double amount;

    @ApiModelProperty(notes = "Campo que indica la ciudad de origen")
    @JsonProperty("cityFrom")
    protected String cityFrom;

    @ApiModelProperty(notes = "Campo que indica la ciudad de destino")
    @JsonProperty("cityTo")
    protected String cityTo;

    @ApiModelProperty(notes = "Campo que indica codigo del aeropuerto de destino")
    @JsonProperty("destinationAirportCode")
    protected Integer destinationAirportCode;

    @ApiModelProperty(notes = "Campo que indica el nombre del aeropuerto de destino")
    @JsonProperty("destinationAirportName")
    protected String destinationAirportName;

    @ApiModelProperty(notes = "Campo que indica la duracion aproximada del vuelo")
    @JsonProperty("durationString")
    protected String durationString;

    @ApiModelProperty(notes = "Campo que indica el vuelo")
    @JsonProperty("flightEnd")
    protected Date flightEnd;

    @ApiModelProperty(notes = "Campo que indica el numero de vuelo")
    @JsonProperty("flightNumber")
    protected String flightNumber;

    @ApiModelProperty(notes = "Campo que indica si el vuelo tiene escalas")
    @JsonProperty("flightScale")
    protected String flightScale;

    @ApiModelProperty(notes = "Campo que indica si el numero de escalas del vuelo")
    @JsonProperty("flightScaleNumber")
    protected Integer flightScaleNumber;

    @ApiModelProperty(notes = "Campo que indica el la fecha de partida del vuelo")
    @JsonProperty("flightStart")
    protected Date flightStart;

    @ApiModelProperty(notes = "Campo que indica el id del vuelo")
    @JsonProperty("id")
    protected Integer id;

    @ApiModelProperty(notes = "Campo que indica el aeropuerto de origen")
    @JsonProperty("originAirportCode")
    protected Integer originAirportCode;

    @ApiModelProperty(notes = "Campo que indica el nombre del aeropuerto de origen")
    @JsonProperty("originAirportName")
    protected String originAirportName;

    @ApiModelProperty(notes = "Campo que indica el numero de pasajeros")
    @JsonProperty("passengersNumber")
    protected Integer passengersNumber;

    @ApiModelProperty(notes = "Campo que indica el el total en minutos de duracion del vuelo")
    @JsonProperty("totalDurationInMinutes")
    protected Double totalDurationInMinutes;

}
