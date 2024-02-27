package co.edu.javeriana.campaigns.infraestructure.repository.campaign;

import co.edu.javeriana.campaigns.domain.CampaignProduct;
import co.edu.javeriana.campaigns.domain.Campaigns;
import co.edu.javeriana.campaigns.domain.Image;
import co.edu.javeriana.campaigns.domain.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
@RequiredArgsConstructor
public class CampaignRepositoryImpl implements CampaignRepository {

    private final JdbcTemplate template;

    @Override
    public Optional<Campaigns> findById(String id) {
        try {
            String sql = "SELECT * FROM CAMPAIGNS WHERE CAMPAIGNS_ID = ?";

            return template.queryForObject(sql,
                    new Object[]{id},
                    (rs, rowNum) ->
                            Optional.of(new Campaigns(
                                    rs.getString("CAMPAIGNS_ID"),
                                    rs.getString("CAMPAIGNS_CODE"),
                                    rs.getString("CAMPAIGNS_NAME"),
                                    rs.getString("CAMPAIGNS_DESC"),
                                    new Image(rs.getString("IMAGE_ID"), ""),
                                    rs.getDate("START_DATE").toLocalDate(),
                                    rs.getDate("END_DATE").toLocalDate(),
                                    rs.getBigDecimal("DISCOUNT"),
                                    rs.getString("STATUS"),
                                    ""
                            ))
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public CompletableFuture<String> create(Campaigns campaigns) {
        try {
            if (findById(campaigns.getCampaignId()).isPresent()) return CompletableFuture.completedFuture(Status.EXIST.name());

            String sql = "INSERT INTO CAMPAIGNS (CAMPAIGNS_ID, " +
                                                "CAMPAIGNS_CODE, " +
                                                "CAMPAIGNS_NAME, " +
                                                "CAMPAIGNS_DESC, " +
                                                "IMAGE_ID, " +
                                                "START_DATE, " +
                                                "END_DATE, " +
                                                "DISCOUNT, " +
                                                "STATUS ) " +
                                                "VALUES (?,?,?,?,?,?,?,?,?)";

            template.update(sql,
                            campaigns.getCampaignId(),
                            campaigns.getCampaignCode(),
                            campaigns.getCampaignName(),
                            campaigns.getCampaignDescription(),
                            campaigns.getImage().getId(),
                            campaigns.getStartDate(),
                            campaigns.getEndDate(),
                            campaigns.getDiscount(),
                            campaigns.getStatus());

            return CompletableFuture.completedFuture(Status.CREATED.name());
        } catch(Exception e) {
            return CompletableFuture.completedFuture(Status.ERROR.name());
        }
    }

    @Override
    public CompletableFuture<String> update(Campaigns campaigns) {
        try {
            if (!findById(campaigns.getCampaignId()).isPresent()) return CompletableFuture.completedFuture(Status.NO_EXIST.name());

            String sql = "UPDATE CAMPAIGNS SET " +
                                "CAMPAIGNS_CODE = ?, " +
                                "CAMPAIGNS_NAME = ?, " +
                                "CAMPAIGNS_DESC = ?, " +
                                "IMAGE_ID = ?, " +
                                "START_DATE = ?, " +
                                "END_DATE = ?, " +
                                "DISCOUNT = ?, " +
                                "STATUS = ? " +
                         "WHERE CAMPAIGNS_ID = ? " ;

            this.template.update(sql,
                                campaigns.getCampaignCode(),
                                campaigns.getCampaignName(),
                                campaigns.getCampaignDescription(),
                                campaigns.getImage().getId(),
                                campaigns.getStartDate(),
                                campaigns.getEndDate(),
                                campaigns.getDiscount(),
                                campaigns.getStatus(),
                                campaigns.getCampaignId());

            return CompletableFuture.completedFuture(Status.UPDATED.name());
        } catch (Exception e) {
            return CompletableFuture.completedFuture(Status.ERROR.name());
        }
    }

    @Override
    public CompletableFuture<String> delete(Campaigns campaigns) {
        try {
            if (findById(campaigns.getCampaignId()).isEmpty()) return CompletableFuture.completedFuture(Status.NO_EXIST.name());

            if (existCampaignProduct(campaigns.getCampaignId()) > 0) {
                String sql = "DELETE FROM CAMPAIGNS_PRODUCTS WHERE CAMPAIGNS_ID = ?";

                this.template.update(sql, campaigns.getCampaignId());
            }

            String sql = "DELETE FROM CAMPAIGNS WHERE CAMPAIGNS_ID = ?";

            this.template.update(sql, campaigns.getCampaignId());

            return CompletableFuture.completedFuture(Status.DELETED.name());
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(Status.ERROR.name());
        }
    }

    private int existCampaignProduct(String campaignId) {
        try {
            String sql = "SELECT count(*) " +
                         "FROM CAMPAIGNS C JOIN CAMPAIGNS_PRODUCTS P on C.CAMPAIGNS_ID = P.CAMPAIGNS_ID " +
                         "WHERE C.CAMPAIGNS_ID = ?";

            return this.template.queryForObject(sql, Integer.class, campaignId);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
