package co.com.userservice.repository;

import co.com.userservice.domain.TblNegocioPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personasRepository")
public interface PersonasRepository extends JpaRepository<TblNegocioPersona, Long>{


}