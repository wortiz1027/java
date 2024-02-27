package edu.javeriana.verificarasignarrecursos.beans;

import co.edu.javeriana.configuracion.extend.AbstractBPMManageBeanBase;
import co.edu.javeriana.configuracion.utils.JsfUtils;
import co.edu.javeriana.facade.FacadeDatabase;
import co.edu.javeriana.negocio.Prototipo;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;

public class MbSolicitarRecursos extends AbstractBPMManageBeanBase implements Serializable {
    @SuppressWarnings("compatibility:-577466769385564085")
    private static final long serialVersionUID = 1L;
    private static ADFLogger logger = ADFLogger.createADFLogger(MbSolicitarRecursos.class);
    
    private Prototipo prototipo;
    
    public MbSolicitarRecursos() {
        super();
    }
    
    @Override
    public String inicializarManageBean() {      
        String codigoPrototipo = (String) JsfUtils.getElObject("#{bindings.codigoPrototipo.inputValue}");
        logger.info("codigoPrototipo: " + codigoPrototipo);
        
        Prototipo prototipo = new Prototipo();
        FacadeDatabase.consultarPrototipo(new BigDecimal(codigoPrototipo), prototipo);
        
        return MbSolicitarRecursos.NAVEGACION_CONTINUAR;
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
        return MbSolicitarRecursos.NAVEGACION_FINALIZAR;
    }
    
    public void setPrototipo(Prototipo prototipo) {
        this.prototipo = prototipo;
    }

    public Prototipo getPrototipo() {
        return prototipo;
    }
}
