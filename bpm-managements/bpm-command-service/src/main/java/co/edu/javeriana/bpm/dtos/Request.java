package co.edu.javeriana.bpm.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Determina la estructura de entrada para realizar la instanciación del proceso BPM.")
public class Request implements java.io.Serializable {
    @ApiModelProperty(notes = "Define el número de solicitud con el cual se piensa dar inicio al proceso de Gestión de Ordenes.")
    private String numeroSolicitud;
}
