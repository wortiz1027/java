package co.edu.javeriana.bpm.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "Estructura que enmarca el estado de instanciación del proceso de gestión de ordenes")
public class Status implements Serializable {
    @ApiModelProperty(notes = "Código del estado de respuesta determinado por la aplicación.")
    private String code;
    @ApiModelProperty(notes = "Descripción detallada del estado de respuesta determinado por la aplicación.")
    private String description;

}
