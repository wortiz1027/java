package edu.javeriana.verificarasignarrecursos.beans;

import co.edu.javeriana.configuracion.extend.AbstractBPMManageBeanBase;
import co.edu.javeriana.configuracion.utils.JsfUtils;
import co.edu.javeriana.configuracion.utils.error.ProcessError;
import co.edu.javeriana.facade.FacadeContent;
import co.edu.javeriana.facade.FacadeDatabase;
import co.edu.javeriana.negocio.Prototipo;

import co.edu.javeriana.wcc.CheckinResult;
import co.edu.javeriana.wcc.Documento;
import co.edu.javeriana.wcc.NameValue;
import co.edu.javeriana.wcc.VisorDocumentoBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class MbDiseniarProductos extends AbstractBPMManageBeanBase implements Serializable {
    @SuppressWarnings("compatibility:-3355526945637132008")
    private static final long serialVersionUID = 1L;
    private static ADFLogger logger = ADFLogger.createADFLogger(MbDiseniarProductos.class);
    
    private final Integer VISOR_HEIGHT = 800;
    private final Integer VISOR_WIDTH  = 1113;
    
    private Prototipo prototipo;
    private VisorDocumentoBean visor;
    private Documento documento;
    
    private boolean opcion1 = Boolean.FALSE;
    private boolean opcion2 = Boolean.FALSE;
    
    private transient RichTable tblDocumentos;
    private transient RichPopup ppVisorDocumento;
    private transient RichPopup ppCargarArchvo;
    
    public MbDiseniarProductos() {
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
            
            FacadeDatabase.consultarPrototipo(new BigDecimal(codigoPrototipo), this.prototipo);
            FacadeContent.busquedaAvanzada(queryText, documentos);
            
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
        return MbDiseniarProductos.NAVEGACION_CONTINUAR;
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
        return MbDiseniarProductos.NAVEGACION_FINALIZAR;
    }
    
    public void onClickAdjuntar(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.ppCargarArchvo.show(hints);
    }

    @SuppressWarnings("unused")
    public void onClickVer(ActionEvent actionEvent) {        
        String idDoc = (String) tblDocumentos.getSelectedRowData();
        
        visor.setAlto(VISOR_HEIGHT);
        visor.setAncho(VISOR_WIDTH);
        visor.setIdDocumento(idDoc);
        visor.setUrlDocumento(VisorDocumentoBean.URL + idDoc);
        
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        ppVisorDocumento.show(hints);
    }

    public void subirArchivo(ValueChangeEvent valueChangeEvent) {
        try {
            UploadedFile ufile = (UploadedFile) valueChangeEvent.getNewValue();
            
            File file = new File(ufile.getFilename());
            
            FileInputStream fis = new FileInputStream(file);

            // In android the result of file.length() is long
            long byteLength = file.length(); // byte count of the file-content

            byte[] content = new byte[(int) byteLength];
            fis.read(content, 0, (int) byteLength);
            
            this.documento.setNombreOriginal(ufile.getFilename());
            this.documento.setTipo("Document");
            this.documento.setGrupoSeguridad("Public");
            this.documento.getArchivoPrimario().setNombreArchivo(ufile.getFilename());
            this.documento.getArchivoPrimario().setContenidoArchivo(content);
            
            NameValue xNumeroID = new NameValue();
            xNumeroID.setName("xNumeroID");
            xNumeroID.setValue("951235789");
            
            NameValue xTelefono = new NameValue();
            xTelefono.setName("xTelefono");
            xTelefono.setValue("3109876542");
            
            NameValue xFolderID = new NameValue();
            xFolderID.setName("xFolderID");
            xFolderID.setValue("SOAint-123456");
            
            NameValue xIdcProfile = new NameValue();
            xIdcProfile.setName("xIdcProfile");
            xIdcProfile.setValue("005");
                        
            documento.getCustomDocMetaData().add(xNumeroID);
            documento.getCustomDocMetaData().add(xTelefono);
            documento.getCustomDocMetaData().add(xFolderID);
            documento.getCustomDocMetaData().add(xIdcProfile);
        } catch (Exception e) {
            logger.severe("", e);
        }
    }
    
    public void aceptarPopUpAdjuntarDocumento(DialogEvent dialogEvent) {
        LOGGER.begin(Level.INFO,"Ingreso aceptarPopUpAdjuntarDocumento ");
        try{
            if(dialogEvent.getOutcome() == DialogEvent.Outcome.ok) {
                CheckinResult response = new CheckinResult();
                FacadeContent.checkIn(this.documento, response);
            }
        } catch (Exception e) {
            logger.severe("Error subiendo el archivo al content", e);
        }
        LOGGER.end(Level.INFO,"Salida aceptarPopUpAdjuntarDocumento ");
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

    public void setOpcion1(boolean opcion1) {
        this.opcion1 = opcion1;
    }

    public boolean isOpcion1() {
        return opcion1;
    }

    public void setOpcion2(boolean opcion2) {
        this.opcion2 = opcion2;
    }

    public boolean isOpcion2() {
        return opcion2;
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
}
