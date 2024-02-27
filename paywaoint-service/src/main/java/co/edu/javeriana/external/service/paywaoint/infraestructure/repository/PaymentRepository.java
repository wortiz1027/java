package co.edu.javeriana.external.service.paywaoint.infraestructure.repository;

import co.edu.javeriana.external.service.paywaoint.domain.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PaymentRepository implements PayRepository {

    private final JdbcTemplate template;

    @Override
    public Optional<CreditCard> findByCreditCardNumber(String number) {
        try {
            String sql = "SELECT * " +
                         "FROM TC_INFORMATION " +
                         "WHERE TC_NUMBER =  ?";
            return template.queryForObject(sql,
                    new Object[]{number},
                    (rs, rowNum) ->
                            Optional.of(new CreditCard(
                                    rs.getString("TC_ID"),
                                    rs.getString("TYPE_TC"),
                                    rs.getString("TC_NUMBER"),
                                    rs.getBigDecimal("AMOUNT")
                            ))
            );
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean chargeAmountCreditCard(CreditCard card) {
        try {
            String sql = "UPDATE TC_INFORMATION SET " +
                         "AMOUNT = ? " +
                         "WHERE TC_NUMBER = ? " ;

            this.template.update(sql, card.getAmount(),
                                card.getNumber());

            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
