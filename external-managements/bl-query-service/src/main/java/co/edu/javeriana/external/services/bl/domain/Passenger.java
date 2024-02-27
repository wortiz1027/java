package co.edu.javeriana.external.services.bl.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura con la informacion de los pasajeros de bolivariano express")
public class Passenger implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica el nombre del pasajero")
    private String nombres;

    @ApiModelProperty(notes = "Campo que indica los apellidos del pasajero")
    private String apellidos;

    @ApiModelProperty(notes = "Campo que indica el tipo de documento del pasajero")
    private String tipoDocumento;

    @ApiModelProperty(notes = "Campo que indica el numero de documento del pasajero")
    private String numeroDocumento;

    @ApiModelProperty(notes = "Campo que indica la fecha del viaje")
    private String fecha;

    @ApiModelProperty(notes = "Campo que indica la hora del viaje")
    private String hora;

    @ApiModelProperty(notes = "Campo que indica el origen del viaje")
    private String origen;

    @ApiModelProperty(notes = "Campo que indica el destino del viaje")
    private String destino;

}
