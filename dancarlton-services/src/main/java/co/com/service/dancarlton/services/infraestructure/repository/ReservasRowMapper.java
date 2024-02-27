package co.com.service.dancarlton.services.infraestructure.repository;

import co.com.service.dancarlton.services.domain.dtos.ReservaDto;
import co.com.service.dancarlton.services.domain.dtos.TipoHabitacionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservasRowMapper implements RowMapper<ReservaDto> {

    @Override
    public ReservaDto mapRow(ResultSet rs, int i) throws SQLException {
        TipoHabitacionDto habitacion = new TipoHabitacionDto();
        habitacion.setIdTipo(String.valueOf(rs.getBigDecimal("id_tipo")));
        habitacion.setDescripcion(rs.getString("descripcion"));

        ReservaDto reserva = new ReservaDto();
        reserva.setIdReserva(String.valueOf(rs.getBigDecimal("idReserva")));
        reserva.setCodigoReserva(rs.getString("codigoReserva"));
        reserva.setFechaInicio(rs.getString("fechaInicio"));
        reserva.setFechaFin(rs.getString("fechaFin"));
        reserva.setNombreHuesped(rs.getString("nombreHuesped"));
        reserva.setTienePasaporte(rs.getString("tienePasaporte"));
        reserva.setNumeroPasaporte(rs.getString("numeroPasaporte"));
        reserva.setNumeroDocumento(rs.getString("numeroDocumento"));
        reserva.setObservaciones(rs.getString("observaciones"));
        reserva.setTipoHabitacion(habitacion);

        return reserva;
    }
}
