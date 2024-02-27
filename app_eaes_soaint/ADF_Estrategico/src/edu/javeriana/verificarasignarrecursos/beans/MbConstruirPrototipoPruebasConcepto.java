package edu.javeriana.verificarasignarrecursos.beans;

import co.edu.javeriana.configuracion.extend.AbstractBPMManageBeanBase;
import co.edu.javeriana.configuracion.utils.JsfUtils;
import co.edu.javeriana.configuracion.utils.error.ProcessError;
import co.edu.javeriana.facade.FacadeContent;
import co.edu.javeriana.facade.FacadeDatabase;
import co.edu.javeriana.facade.FacadeDatabase2;
import co.edu.javeriana.negocio.Prototipo;

import co.edu.javeriana.negocio.Recomendacion;
import co.edu.javeriana.wcc.Documento;
import co.edu.javeriana.wcc.VisorDocumentoBean;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class MbConstruirPrototipoPruebasConcepto extends AbstractBPMManageBeanBase implements Serializable {
    @SuppressWarnings("compatibility:4898903779838100144")
    private static final long serialVersionUID = 1L;
    private static ADFLogger logger = ADFLogger.createADFLogger(MbConstruirPrototipoPruebasConcepto.class);
    
    private final Integer VISOR_HEIGHT = 800;
    private final Integer VISOR_WIDTH  = 1113;
    
    private Prototipo prototipo;
    private VisorDocumentoBean visor;
    private Documento documento;
    
    private String observacion;
    
    private transient RichTable tblDocumentos;
    private transient RichPopup ppVisorDocumento;
    private transient RichPopup ppCargarArchvo;
    
    public MbConstruirPrototipoPruebasConcepto() {
        super();
    }
    
    @Override
    public String inicializarManageBean() {      
        logger.begin(Level.INFO,String.format("Ingreso initializeServices %s", ""));
        
        try {
            
            this.documento = new Documento();
            
            this.visor = new VisorDocumentoBean();
            
            final String codigoPrototipo = (String) JsfUtils.getElObject("#{bindings.codigo.inputValue}");
            final String queryText = "dDocType <matches> `Document` <AND> xIdcProfile <matches> `005` <AND> xIdPrototipo = `"+codigoPrototipo+"`";
            
            List<Documento> documentos = new ArrayList<>();
            List<Recomendacion> recomendaciones = new ArrayList<>();
            
            FacadeDatabase.consultarPrototipo(new BigDecimal(codigoPrototipo), this.prototipo);
            FacadeDatabase2.consultarRecomendaciones(recomendaciones, new BigDecimal(codigoPrototipo));
            FacadeContent.busquedaAvanzada(queryText, documentos);
            
            this.prototipo.setRecomendaciones(recomendaciones);
                                    
            for (Documento documento : documentos) {
                co.edu.javeriana.negocio.Documento item = new co.edu.javeriana.negocio.Documento();
                item.setIdDoc(String.valueOf(documento.getDID()));
                item.setNombre(documento.getTitulo());
                
                this.prototipo.getDocumentos().add(item);
            }
            
        } catch(Exception e) {
            final ProcessError process = new ProcessError();
            process.setMethodCode(ProcessError.MethodIdentifier.M03.getID());
            process.process(e, this);
        }
        
        logger.end(Level.INFO,String.format("Salida initializeServices %s", ""));
        return MbConstruirPrototipoPruebasConcepto.NAVEGACION_CONTINUAR;
    }
    
    @Override
    public void finalizarActionListener(ActionEvent actionEvent) {
        //TODO Realizo las actividades intermedias que crea necesarias
    }

    @Override
    public Boolean finalizarActividad() {
        //TODO Se realizar actividades de validaciÃ³n para determinar si debo o no terminar la tarea
        return Boolean.TRUE;
    }
    
    public String finalizarPantalla() {
        String response = "";
        FacadeDatabase.insertarProtipo(this.prototipo, response);
        return MbConstruirPrototipoPruebasConcepto.NAVEGACION_FINALIZAR;
    }
    
    public void onClickAgregarRecomendaciones(ActionEvent actionEvent) {
        this.observacion = "";
        
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.ppCargarArchvo.show(hints);
        
        Recomendacion recomendacion = new Recomendacion();
        recomendacion.setCodigoPrototipo(this.prototipo.getCodigo());
        recomendacion.setObservacion(this.observacion);
        recomendacion.setSeleccionado(Boolean.FALSE);
        
        this.prototipo.getRecomendaciones().add(recomendacion);
    }

    public void onClickEliminarRecomendaciones(ActionEvent actionEvent) {
        this.prototipo
            .getRecomendaciones().forEach(tmp -> {
                            if (tmp.getSeleccionado()) {
                                this.prototipo.getRecomendaciones().remove(tmp);
                            }
            });
    }
    
    public void onClickVer(ActionEvent actionEvent) {
        String idDoc = (String) tblDocumentos.getSelectedRowData();
        
        this.visor.setAlto(VISOR_HEIGHT);
        this.visor.setAncho(VISOR_WIDTH);
        this.visor.setIdDocumento(idDoc);
        this.visor.setUrlDocumento(VisorDocumentoBean.URL + idDoc);
        
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.ppVisorDocumento.show(hints);
    }

    public void setPrototipo(Prototipo prototipo) {
        this.prototipo = prototipo;
    }

    public Prototipo getPrototipo() {
        return prototipo;
    }

    public void setVisor(VisorDocumentoBean visor) {
        this.visor = visor;
    }

    public VisorDocumentoBean getVisor() {
        return visor;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setTblDocumentos(RichTable tblDocumentos) {
        this.tblDocumentos = tblDocumentos;
    }

    public RichTable getTblDocumentos() {
        return tblDocumentos;
    }

    public void setPpVisorDocumento(RichPopup ppVisorDocumento) {
        this.ppVisorDocumento = ppVisorDocumento;
    }

    public RichPopup getPpVisorDocumento() {
        return ppVisorDocumento;
    }

    public void setPpCargarArchvo(RichPopup ppCargarArchvo) {
        this.ppCargarArchvo = ppCargarArchvo;
    }

    public RichPopup getPpCargarArchvo() {
        return ppCargarArchvo;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

}
