package co.com.service.dancarlton.services.infraestructure.repository;

import co.com.service.dancarlton.services.domain.dtos.ReservaDto;
import co.com.service.dancarlton.services.domain.dtos.TipoHabitacionDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReservasRepositoryImpl implements ReservasRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ReservasRepositoryImpl.class);
    private final JdbcTemplate template;

    @Override
    public Optional<List<ReservaDto>> findAllBookings() {
        try {
            String sql = "SELECT * " +
                         "FROM reserva R INNER JOIN tipo_habitacion TH on R.tipoHabitacion = TH.id_tipo " +
                         "ORDER BY codigoReserva ASC";

            List<ReservaDto> reservas = this.template.query(sql, new ReservasRowMapper());

            return Optional.of(reservas);
        } catch (Exception e) {

            return Optional.empty();
        }

    }

    @Override
    public Optional<ReservaDto> findBookinByCode(String code) {
        try {
            String sql = "SELECT * " +
                         "FROM reserva R INNER JOIN tipo_habitacion TH on R.tipoHabitacion = TH.id_tipo " +
                         "WHERE codigoReserva = ?";

            return template.queryForObject(sql,
                    new Object[]{code},
                    (rs, rowNum) ->
                            Optional.of(new ReservaDto(String.valueOf(rs.getBigDecimal("idReserva")),
                                                       rs.getString("codigoReserva"),
                                                       rs.getString("fechaInicio"),
                                                       rs.getString("fechaFin"),
                                                       rs.getString("nombreHuesped"),
                                                       rs.getString("tienePasaporte"),
                                                       rs.getString("numeroPasaporte"),
                                                       rs.getString("numeroDocumento"),
                                                       rs.getString("observaciones"),
                                                       new TipoHabitacionDto(String.valueOf(rs.getBigDecimal("id_tipo")),
                                                                             rs.getString("descripcion"))
                            ))
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
