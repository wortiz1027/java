package co.edu.javeriana.external.services.dc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoHabitacion implements java.io.Serializable {

    private String idTipo;
    private String descripcion;

}
