package co.com.service.dancarlton.services.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoHabitacionDto implements java.io.Serializable {

    private String idTipo;
    private String descripcion;

}
