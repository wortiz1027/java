package co.com.securityserver.repository.dao;

import co.com.securityserver.domain.TblSecUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<TblSecUsers, Integer> {

    @Query("SELECT count(u) FROM TblSecUsers u WHERE u.login = :ipLogin")
    boolean isUserAvailable(@Param("ipLogin") String login);

    @Query("SELECT u FROM TblSecUsers u WHERE u.login = :ipLogin")
    TblSecUsers loadUserByName(@Param("ipLogin") String username);

}