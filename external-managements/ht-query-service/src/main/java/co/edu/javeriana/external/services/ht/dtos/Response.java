package co.edu.javeriana.external.services.ht.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@RequiredArgsConstructor
@ApiModel(description = "Estructura con la informacion de la respuesta de reservas del hotel hilton")
public class Response implements Serializable {

     @ApiModelProperty(notes = "Fecha de reserva de la habitacion")
     private final Date date;

     @ApiModelProperty(notes = "valor de solicitud")
     private final String request;

     @ApiModelProperty(notes = "Campo que indica estado de la transaccion")
     private final boolean response;
}
