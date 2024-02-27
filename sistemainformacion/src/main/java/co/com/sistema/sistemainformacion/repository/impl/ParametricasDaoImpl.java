package co.com.sistema.sistemainformacion.repository.impl;

import co.com.sistema.sistemainformacion.domain.CaracterEntidad;
import co.com.sistema.sistemainformacion.domain.EstadoCivil;
import co.com.sistema.sistemainformacion.domain.NivelEstudios;
import co.com.sistema.sistemainformacion.domain.OtrosEstudios;
import co.com.sistema.sistemainformacion.domain.Referencia;
import co.com.sistema.sistemainformacion.repository.dao.ParametricasDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("parametricasDao")
public class ParametricasDaoImpl implements ParametricasDao {
    
    @Autowired
    JdbcTemplate template;
    
    @Override
    public List<CaracterEntidad> getCaracter() {
        List<CaracterEntidad> caracter = null;
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT caracter.caracter_key, caracter.caracter_entidad ");
        sbQuery.append("FROM politica.tbl_param_caracter_entidad caracter");
        
        try {
            caracter = template.queryForList(sbQuery.toString(), CaracterEntidad.class);
        } catch (Exception e) {
            return caracter;
        }
        return caracter;
    }
    
    @Override
    public List<EstadoCivil> getEstado() {
        List<EstadoCivil> estado = null;
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT estado.estado_key, estado.nombre_estado ");
        sbQuery.append("FROM politica.tbl_param_estado_civil estado");
        
        try {
            estado = template.queryForList(sbQuery.toString(), EstadoCivil.class);
        } catch (Exception e) {
            return estado;
        }
        return estado;
    }
    
    @Override
    public List<NivelEstudios> getNiveles() {
    List<NivelEstudios> niveles = null;
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT niveles.nivel_estudio_key, niveles.nombre_estudios ");
        sbQuery.append("FROM politica.tbl_param_nivel_estudios niveles");
        
        try {
            niveles = template.queryForList(sbQuery.toString(), NivelEstudios.class);
        } catch (Exception e) {
            return niveles;
        }
        return niveles;
    }
    
    @Override
    public List<OtrosEstudios> getOtros() {
        List<OtrosEstudios> otros = null;
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT otros.otros_estudios_key, otros.nombre_otros ");
        sbQuery.append("FROM politica.tbl_param_otros_estudios otros");
        
        try {
            otros = template.queryForList(sbQuery.toString(), OtrosEstudios.class);
        } catch (Exception e) {
            return otros;
        }
        return otros;
    }

    @Override
    public List<Referencia> getReferencia() {
        List<Referencia> referencias = null;
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT referencia.referencia_type_key, referencia.referencia_nombre ");
        sbQuery.append("FROM politica.tbl_param_referencia referencia");
        
        try {
            referencias = template.queryForList(sbQuery.toString(), Referencia.class);
        } catch (Exception e) {
            return referencias;
        }
        return referencias;
    }

    @Override
    public String getCaracterById(int id) {
        String caracter = "";
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT caracter.caracter_entidad ");
        sbQuery.append("FROM politica.tbl_param_caracter_entidad caracter ");
        sbQuery.append("WHERE caracter.caracter_key = ? ");
        
        try {
            caracter = template.queryForObject(sbQuery.toString(), new Object[]{id}, String.class);
        } catch (Exception e) {
            return null;
        }
        return caracter;
    }

    @Override
    public String getEstadoById(int id) {
        String estado = "";
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT estado.nombre_estado ");
        sbQuery.append("FROM politica.tbl_param_estado_civil estado ");
        sbQuery.append("WHERE estado.estado_key = ? ");
        
        try {
            estado = template.queryForObject(sbQuery.toString(), new Object[]{id}, String.class);
        } catch (Exception e) {
            return null;
        }
        return estado;
    }
    
    @Override
    public String getNivelById(int id) {
        String nivel = "";
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT nivel.nombre_estudios ");
        sbQuery.append("FROM politica.tbl_param_nivel_estudios nivel ");
        sbQuery.append("WHERE nivel.nivel_estudio_key = ? ");
        
        try {
            nivel = template.queryForObject(sbQuery.toString(), new Object[]{id}, String.class);
        } catch (Exception e) {
            return null;
        }
        return nivel;
    }
    
    @Override
    public String getOtrosById(int id) {
        String otro = "";
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT otro.nombre_otros ");
        sbQuery.append("FROM politica.tbl_param_otros_estudios otro ");
        sbQuery.append("WHERE otro.otros_estudios_key = ? ");
        
        try {
            otro = template.queryForObject(sbQuery.toString(), new Object[]{id}, String.class);
        } catch (Exception e) {
            return null;
        }
        return otro;
    }

    @Override
    public String getReferenciaById(int id) {
        String referencia = "";
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT referencia.referencia_nombre ");
        sbQuery.append("FROM politica.tbl_param_referencia referencia ");
        sbQuery.append("WHERE referencia.referencia_type_key = ? ");
        
        try {
            referencia = template.queryForObject(sbQuery.toString(), new Object[]{id}, String.class);
        } catch (Exception e) {
            return null;
        }
        return referencia;
    }

}