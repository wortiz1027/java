package co.com.securityserver.repository.dao;

import co.com.securityserver.domain.TblSecRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<TblSecRoles, Integer>{

    @Query("SELECT r FROM TblSecRoles r")
    List<TblSecRoles> getRoleListNq();

}