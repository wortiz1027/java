package co.edu.javeriana.external.services.dc.dtos.code;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Estructura para recibir solicitudes de reservas")
public class Request implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo para consultar la reserva por código")
    private String code;

}
