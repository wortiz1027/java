package edu.javeriana.filtradoseleccioncandidato.beans;

import co.edu.javeriana.configuracion.extend.AbstractBPMManageBeanBase;
import co.edu.javeriana.configuracion.utils.JsfUtils;
import co.edu.javeriana.configuracion.utils.PopupUtils;
import co.edu.javeriana.configuracion.utils.error.ProcessError;
import co.edu.javeriana.negocio.Entrevista;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichTable;

import org.apache.myfaces.trinidad.event.SelectionEvent;

public class MbEvaluarSeleccionarCandidato extends AbstractBPMManageBeanBase implements Serializable {
    @SuppressWarnings("compatibility:-2397921064087203517")
    private static final long serialVersionUID = 1L;
    private static ADFLogger logger = ADFLogger.createADFLogger(MbEvaluarSeleccionarCandidato.class);
    
    private List<Entrevista> entrevistas;
    private Entrevista entrevista;
    private boolean mostrarPanelEntrevista;

    public MbEvaluarSeleccionarCandidato() {
        super();
    }
    
    @Override
    public String inicializarManageBean() {
        logger.begin(Level.INFO,String.format("Ingreso initializeServices %s", ""));
        this.entrevistas = new ArrayList<Entrevista>(0);
        
        try {
            final BigDecimal codigoVacante = new BigDecimal((String) JsfUtils.getElObject("#{bindings.codigoVacante.inputValue}"));
            logger.info("codigoVacante: " + codigoVacante);
            //TODO FacadeDatabase2.consultarCurriculum(entrevistas, codigoVacante);
            
        } catch(Exception e) {
            final ProcessError process = new ProcessError();
            process.setMethodCode(ProcessError.MethodIdentifier.M03.getID());
            process.process(e, this);
        }
        
        logger.end(Level.INFO,String.format("Salida initializeServices %s", ""));
        return MbEvaluarSeleccionarCandidato.NAVEGACION_CONTINUAR;
    }
    
    @Override
    public void finalizarActionListener(ActionEvent actionEvent) {
        //TODO Realizo las actividades intermedias que crea necesarias
    }

    @Override
    public Boolean finalizarActividad() {
        //TODO Se realizar actividades de validación para determinar si debo o no terminar la tarea
        //1. Guardar la información de la entrevista
        for (Entrevista entrevista : entrevistas) {
            //TODO FacadeDatabase2.insertarEntrevista(entrevista);
        }//End foreach
        
        return Boolean.TRUE;
    }
    
    public String finalizarPantalla() {
        //TODO Da por sentado que la pantalla ya se debe cerrar y la actividad debe viajar                  
        return MbEvaluarSeleccionarCandidato.NAVEGACION_FINALIZAR;
    }

    public void candidatosSelectionListiner(SelectionEvent selectionEvent) {
        //1. Obtenemos la tabla desde selectionEvent
        final RichTable richTable = (RichTable) selectionEvent.getSource();
        //2. Obtenemos el candidato seleccionado
        this.entrevista = (Entrevista) richTable.getSelectedRowData();
        //. Mostramos el panel de entrevista
        mostrarPanelEntrevista = Boolean.TRUE;
        JsfUtils.refreshComponent(JsfUtils.findComponentInRoot("pgl6"));
    }
    
    public void onClickVer(ActionEvent actionEvent) {
        this.entrevista = (Entrevista) actionEvent.getComponent().getAttributes().get("entrevista");
        PopupUtils.mostrarPopUpComponet("p1");
    }

    public void setEntrevistas(List<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

    public List<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

    public Entrevista getEntrevista() {
        return entrevista;
    }

    public boolean isMostrarPanelEntrevista() {
        return mostrarPanelEntrevista;
    }
}