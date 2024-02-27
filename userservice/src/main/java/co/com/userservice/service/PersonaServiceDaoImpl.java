package co.com.userservice.service;

import co.com.userservice.domain.TblNegocioPersona;
import co.com.userservice.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceDaoImpl implements PersonaServiceDao {

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    @Transactional
    public List<TblNegocioPersona> getTodos() {
        return personasRepository.findAll();
    }
}