package co.com.userservice.controller;

import co.com.userservice.domain.TblNegocioPersona;
import co.com.userservice.service.PersonaServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaServiceDao serviceDao;

    @GetMapping("/todos")
    public ResponseEntity<List<TblNegocioPersona>> obtenerTodos(){
        List<TblNegocioPersona> listado = null;

        try {
            listado = serviceDao.getTodos();
        } catch (Exception e) {
            return new ResponseEntity<List<TblNegocioPersona>>(listado, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<TblNegocioPersona>>(listado, HttpStatus.OK);
    }

}