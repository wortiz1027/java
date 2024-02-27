package co.com.demo.clients.infraestructure.repository.mappers;

import co.com.demo.clients.domain.database.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int i) throws SQLException {
        return new Client(rs.getString("CLIENT_ID"),
                        rs.getString("CLIEN_DNI"),
                        rs.getString("CLIENT_NAME"),
                        rs.getString("CLIENT_EMAIL"),
                        rs.getString("CLIENT_PHONE"));
    }

}
