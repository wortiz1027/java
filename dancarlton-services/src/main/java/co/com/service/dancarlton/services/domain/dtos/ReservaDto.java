package co.com.service.dancarlton.services.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDto implements java.io.Serializable {

    private String idReserva;
    private String codigoReserva;
    private String fechaInicio;
    private String fechaFin;
    private String nombreHuesped;
    private String tienePasaporte;
    private String numeroPasaporte;
    private String numeroDocumento;
    private String observaciones;
    private TipoHabitacionDto tipoHabitacion;
    
}
