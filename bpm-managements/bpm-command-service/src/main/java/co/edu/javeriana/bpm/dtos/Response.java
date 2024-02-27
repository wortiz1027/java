package co.edu.javeriana.bpm.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "Estructura de reespuesta asociada al comportamiento de un inicio de instancia de proceso BPM.")
public class Response implements Serializable {
    @ApiModelProperty(notes = "Descripción de la respuesta determinada por la instanciación del proceso BPM.")
    private String respuesta;
    @ApiModelProperty(notes = "Estado de la repuesta.")
    private Status status;
}
