package co.com.demo.clients.infraestructure.repository;

import co.com.demo.clients.domain.database.Client;
import co.com.demo.clients.infraestructure.repository.mappers.ClientRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientMySQL implements ClientRepository {

    private final JdbcTemplate template;

    @Override
    public Optional<Client> findClientById(String dni) {
        try {
            String sql = "SELECT * " +
                    "FROM CLIENTS B " +
                    "WHERE CLIEN_DNI = ?";

            return template.queryForObject(sql,
                    new Object[]{dni},
                    (rs, rowNum) ->
                            Optional.of(new Client(
                                            rs.getString("CLIENT_ID"),
                                            rs.getString("CLIEN_DNI"),
                                            rs.getString("CLIENT_NAME"),
                                            rs.getString("CLIENT_EMAIL"),
                                            rs.getString("CLIENT_PHONE")
                                    )
                            )
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Client>> findAllClients() {
        try {
            String sql = "SELECT * " +
                         "FROM CLIENTS C " ;

            List<Client> clients = template.query(sql, new ClientRowMapper());
            return Optional.of(clients);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
