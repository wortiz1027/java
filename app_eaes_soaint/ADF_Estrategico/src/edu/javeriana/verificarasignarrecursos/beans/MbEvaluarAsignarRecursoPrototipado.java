package edu.javeriana.verificarasignarrecursos.beans;

import co.edu.javeriana.configuracion.extend.AbstractBPMManageBeanBase;
import co.edu.javeriana.configuracion.utils.JsfUtils;
import co.edu.javeriana.configuracion.utils.error.ProcessError;
import co.edu.javeriana.facade.FacadeDatabase;
import co.edu.javeriana.negocio.Colaborador;
import co.edu.javeriana.negocio.Prototipo;
import co.edu.javeriana.wcc.VisorDocumentoBean;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;

public class MbEvaluarAsignarRecursoPrototipado extends AbstractBPMManageBeanBase implements Serializable {
    @SuppressWarnings("compatibility:1486569441254227635")
    private static final long serialVersionUID = 1L;
    private static ADFLogger logger = ADFLogger.createADFLogger(MbEvaluarAsignarRecursoPrototipado.class);
    
    private Prototipo prototipo;
    private List<Colaborador> colaboradores;
    
    private final Integer VISOR_HEIGHT = 800;
    private final Integer VISOR_WIDTH  = 1113;
    
    private VisorDocumentoBean visor;
    
    public MbEvaluarAsignarRecursoPrototipado() {
        super();
    }
    
    @Override
    public String inicializarManageBean() {      
        logger.begin(Level.INFO,String.format("Ingreso initializeServices %s", ""));
        
        try {
            this.colaboradores = new ArrayList<>();           
            this.visor = new VisorDocumentoBean();
            
            final String codigoPrototipo = (String) JsfUtils.getElObject("#{bindings.codigo.inputValue}");
            
            FacadeDatabase.consultarPrototipo(new BigDecimal(codigoPrototipo), this.prototipo);
            
        } catch(Exception e) {
            final ProcessError process = new ProcessError();
            process.setMethodCode(ProcessError.MethodIdentifier.M03.getID());
            process.process(e, this);
        }
        
        logger.end(Level.INFO,String.format("Salida initializeServices %s", ""));       
        return MbEvaluarAsignarRecursoPrototipado.NAVEGACION_CONTINUAR;
    }
    
    @Override
    public void finalizarActionListener(ActionEvent actionEvent) {
        //TODO Realizo las actividades intermedias que crea necesarias
    }

    @Override
    public Boolean finalizarActividad() {
        //TODO Se realizar actividades de validación para determinar si debo o no terminar la tarea
        return Boolean.TRUE;
    }
    
    public String finalizarPantalla() {
        //TODO Da por sentado que la pantalla ya se debe cerrar y la actividad debe viajar
        return MbEvaluarAsignarRecursoPrototipado.NAVEGACION_FINALIZAR;
    }

    public void setPrototipo(Prototipo prototipo) {
        this.prototipo = prototipo;
    }

    public Prototipo getPrototipo() {
        return prototipo;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void onClickVer(ActionEvent actionEvent) {
        // Add event code here...
    }
}
