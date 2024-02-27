package co.edu.javeriana.external.services.aa.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Informacion del detalle de las sillas disponibles reportadas por la aerolinea")
public class Seat implements java.io.Serializable {

    @ApiModelProperty(notes = "Indicador del numero de silla")
    private String number;

    @ApiModelProperty(notes = "Indicador de disponibilidad de las sillas")
    private String available;
}
