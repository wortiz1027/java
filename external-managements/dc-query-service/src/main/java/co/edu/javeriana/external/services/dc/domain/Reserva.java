package co.edu.javeriana.external.services.dc.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Estructura con el detalle de la reserva del hotel dan carlton")
public class Reserva implements java.io.Serializable {

    @ApiModelProperty(notes = "Campo que indica el id de reservas del hotel dan carlton")
    private String idReserva;

    @ApiModelProperty(notes = "Campo que indica el codigo de reserva para el hotel dan carlton")
    private String codigoReserva;

    @ApiModelProperty(notes = "Campo que indica la fecha de inicio de la reserva de la habitacion")
    private String fechaInicio;

    @ApiModelProperty(notes = "Campo que indica la fecha de finalizacion de la reserva de la habitacion")
    private String fechaFin;

    @ApiModelProperty(notes = "Campo que indica el nombre del huesped")
    private String nombreHuesped;

    @ApiModelProperty(notes = "Campo que indica si el huesped cuenta con pasaporte")
    private String tienePasaporte;

    @ApiModelProperty(notes = "Campo que indica el numero de pasaporte")
    private String numeroPasaporte;

    @ApiModelProperty(notes = "Campo que indica el numero de documento del huesped")
    private String numeroDocumento;

    @ApiModelProperty(notes = "Campo que indica la observaciones de la reserva")
    private String observaciones;

    @ApiModelProperty(notes = "Campo que indica el tipo de habitacion seleccionada por el cliente")
    private TipoHabitacion tipoHabitacion;

}
