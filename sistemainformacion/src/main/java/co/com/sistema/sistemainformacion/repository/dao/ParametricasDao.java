package co.com.sistema.sistemainformacion.repository.dao;

import co.com.sistema.sistemainformacion.domain.CaracterEntidad;
import co.com.sistema.sistemainformacion.domain.EstadoCivil;
import co.com.sistema.sistemainformacion.domain.NivelEstudios;
import co.com.sistema.sistemainformacion.domain.OtrosEstudios;
import co.com.sistema.sistemainformacion.domain.Referencia;
import java.util.List;

public interface ParametricasDao {
    
    List<CaracterEntidad> getCaracter();
    List<EstadoCivil> getEstado();
    List<OtrosEstudios> getOtros();
    List<NivelEstudios> getNiveles();
    List<Referencia> getReferencia();
    
    String getCaracterById(int id);
    String getEstadoById(int id);
    String getNivelById(int id);
    String getOtrosById(int id);
    String getReferenciaById(int id); 
    
}
