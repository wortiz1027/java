package co.edu.javeriana.configuracion.utils.error;

import co.edu.javeriana.configuracion.annotations.error.ClassIdentifier;

import co.edu.javeriana.configuracion.error.MessageUtils;
import co.edu.javeriana.configuracion.service.ResponseService;
import co.edu.javeriana.configuracion.utils.BooleanUtils;
import co.edu.javeriana.configuracion.utils.JsfUtils;

import java.io.Serializable;

import java.util.Iterator;
import java.util.List;

import oracle.adf.share.logging.ADFLogger;

public class ProcessError implements Serializable {
    @SuppressWarnings("compatibility:3589868575442489548")
    private static final long serialVersionUID = 1L;
    public static final String NULL_POINTER_MSJ="Variable no inicializada.";
    private static final String MSJ_CODIGO="<b>C\u00f3digo:</b> ";
    private static final String MSJ_DESCRIPCION="<b>Descripci\u00f3n:</b> ";
    private static final String MSJ_GENERICO="Ha ocurrido un error inesperado.";
    private static final String MSJ_SEPARADOR="<br>";
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(ProcessError.class);
    private String methodCode;
    private String type;
    public enum MethodIdentifier {
        M01("01"),
        M02("02"),
        M03("03"),
        M04("04"),
        M05("05"),
        M06("06"),
        M07("07"),
        M08("08"),
        M09("09"),
        M10("10"),
        M11("11"),
        M12("12"),
        M13("13"),
        M14("14"),
        M15("15"),
        M16("16"),
        M17("17"),
        M18("18"),
        M19("19"),
        M20("20"),
        M21("21"),
        M22("22"),
        M23("23"),
        M24("24"),
        M25("25"),
        M26("26"),
        M27("27"),
        M28("28"),
        M29("29"),
        M30("30");
        private String id;

        MethodIdentifier(final String id) {
            this.id = id;
        }

        public String getID() {
            return id;
        }
    };

    public ProcessError() {
        super();
    }
    private String getClassIdentifier(final Object obj) {
        String res = "";
        if (obj.getClass().isAnnotationPresent(ClassIdentifier.class)) {
            final ClassIdentifier temp = obj.getClass().getAnnotation(ClassIdentifier.class);
            res = temp.value();
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    private String getClassIdentifier(final Class clase) {
        String res = "";
        if (clase.isAnnotationPresent(ClassIdentifier.class)) {
            final ClassIdentifier temp =(ClassIdentifier) clase.getAnnotation(ClassIdentifier.class);
            res = temp.value();
        }
        return res;
    }
    private String getCode(final Object obj) {
        String res = "";
        res = this.getClassIdentifier(obj) + "-" + this.methodCode;
        return res;
    }
    private String getCode(final Class clase) {
        String res = "";
        res = this.getClassIdentifier(clase) + "-" + this.methodCode;
        return res;
    }
    public void process(final Exception e, final Class clase) {
        final String classCode = this.getCode(clase);
        LOGGER.severe(classCode);
        LOGGER.severe(e);
        String mjs=e.getMessage();
        if(e instanceof  NullPointerException){
           mjs=ProcessError.NULL_POINTER_MSJ; 
        }
        this.show(ProcessError.MSJ_CODIGO+ classCode +ProcessError.MSJ_SEPARADOR+ProcessError.MSJ_DESCRIPCION+mjs);
    }
    public void process(final Exception e, final Object clase) {
        final String classCode = this.getCode(clase);
        LOGGER.severe(classCode);
        LOGGER.severe(e);
        String mjs=e.getMessage();
        if(e instanceof  NullPointerException){
           mjs=ProcessError.NULL_POINTER_MSJ; 
        }
        this.show(ProcessError.MSJ_CODIGO+ classCode +ProcessError.MSJ_SEPARADOR+ProcessError.MSJ_DESCRIPCION+mjs);
    }
    public void process(final Exception e,final String msj,final Class clase) {
        final String classCode = this.getCode(clase);
        LOGGER.severe(classCode);
        LOGGER.severe(e);
        
        this.show(ProcessError.MSJ_CODIGO+ classCode +ProcessError.MSJ_SEPARADOR+ProcessError.MSJ_DESCRIPCION+ msj);
    }
    public void process(final Exception e,final String msj,final Object clase) {
        final String classCode = this.getCode(clase);
        LOGGER.severe(classCode);
        LOGGER.severe(e);
        this.show(ProcessError.MSJ_CODIGO+ classCode +ProcessError.MSJ_SEPARADOR+ProcessError.MSJ_DESCRIPCION+ msj);
    }
    public void process(final ResponseService res,final Object clase) {
        if(!res.getIsException() && res.existenRegistros()){
            final String classCode = this.getCode(clase);
            LOGGER.warning(classCode);
            LOGGER.warning(ProcessError.MSJ_CODIGO+ classCode +ProcessError.MSJ_SEPARADOR+MSJ_DESCRIPCION+ res.getError().getCodigo() + " - " + res.getError().getDescripcion());
            this.show(ProcessError.MSJ_CODIGO+ classCode +ProcessError.MSJ_SEPARADOR+MSJ_DESCRIPCION+ res.getError().getCodigo() + " - " + res.getError().getDescripcion());
        }
        if(!res.getIsException() && res.existenRegistrosInfo()){
            final String classCode = this.getCode(clase);
            LOGGER.warning(classCode);
            LOGGER.warning(ProcessError.MSJ_CODIGO+ classCode +ProcessError.MSJ_SEPARADOR+MSJ_DESCRIPCION+ res.getError().getCodigo() + " - " + res.getError().getDescripcion());
            this.showInfo(res.getError().getDescripcion());
        }
    }
    public void process(final List<ResponseService> res,final Object clase) {
        final Iterator<ResponseService> it=res.iterator();
        while(it.hasNext()){
            this.process(it.next(), clase);
        }
    }
    public void process(final MessageUtils message) {
        if(message.error()||message.msj()){
            this.show(message);
        }
    }
    private void show(final MessageUtils message){
        if(message.error()){
            final StringBuilder res= new StringBuilder ("<html><body>");
            res.append(message.getListMessage());
            res.append("</body></html>");
            JsfUtils.addFacesWarningMessage(res.toString());
        }
        if(message.msj() && !message.error()){
            final String[] msjs=message.getMessage();
            if(BooleanUtils.existe(msjs[0])){
                final StringBuilder res= new StringBuilder ("<html><body>");
                res.append(msjs[0]);
                res.append("</body></html>");
                JsfUtils.addFacesWarningMessage(res.toString());
            }
            if(BooleanUtils.existe(msjs[1])){
                final StringBuilder res= new StringBuilder ("<html><body>");
                res.append(msjs[1]);
                res.append("</body></html>");
                JsfUtils.addFacesInfoMessage(res.toString());
            }
        }
    }
    private void show(final String msj){
        final String[] msjs=msj.split(ProcessError.MSJ_SEPARADOR);
        final StringBuilder res= new StringBuilder ("<html><body>");
        res.append("<p>"+ProcessError.MSJ_GENERICO+"</p>");
        for(int i=0;i<msjs.length;i++){
            res.append("<p>"+msjs[i]+"</p>");
        }
        res.append("</body></html>");
        JsfUtils.addFacesErrorMessage(res.toString());
    }
    private void showInfo(final String msj){
        final String[] msjs=msj.split(ProcessError.MSJ_SEPARADOR);
        final StringBuilder res= new StringBuilder ("<html><body>");
        for(int i=0;i<msjs.length;i++){
            res.append("<p>"+msjs[i]+"</p>");
        }
        res.append("</body></html>");
        JsfUtils.addFacesInfoMessage(res.toString());
    }
    public void setMethodCode(final String methodCode) {
        this.methodCode = methodCode;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
