package co.edu.javeriana.external.services.aa.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "Estructura del vuelo con detalle de su informacion")
public class Flight implements java.io.Serializable {

    @ApiModelProperty(notes = "Indicador del numero de vuelo retornado por la aerolinea")
    private String number;

    @ApiModelProperty(notes = "Lugar de origen del vuelo reportado por la aerolinea")
    private String source;

    @ApiModelProperty(notes = "Lugar de destino del vuelo reportado por la aerolinea")
    private String destination;

    @ApiModelProperty(notes = "Fecha delvuelo reportado por la aerolinea")
    private String date;

    @ApiModelProperty(notes = "Listado de sillas disponibles del vuelo")
    private List<Seat> seats;

}
