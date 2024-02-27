package co.edu.javeriana.configuracion.utils;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

public class BundleUtil {
    public static final String BUNDLE_PATH="bundle";
    public static final String BUNDLE_CONTANTES_PATH="constantes";
    public static final String BUNDLE_VERIFICACION="verificacion";  
    public static final String BUNDLE_ANALISIS="analisis";
    public static final String BUNDLE_ANALISIS_CREDITO="bundleAnalisisCredito";
    public static final String BUNDLE_UTILITARIO="bundleUtilitario";
    public static final String BUNDLE_SOLICITUD="bundleFragmentoSolicitud";
    public static final String BUNDLE_PLANGOBIERNO="plangobierno";
    public static final String BUNDLE_HIPOTECARIO="bundleHipotecario";
    public static final String BUNDLE_INMUEBLE="bundleInmueble";
    public static final String BUNDLE_ESTUDIO_TITULO="estudiotitulos";
    public static final String BUNDLE_DOCUMENTOS="bundleFragmentoDocumento";
    public static final String BUNDLE_AVALUO="avaluoBundle";
    
    private BundleUtil() {
        super();
    }
    
    public static String getString(final String varName,final String key){
        final FacesContext context = FacesContext.getCurrentInstance();
        final Application app = context.getApplication();
        final ResourceBundle bundle = app.getResourceBundle(context, varName);
        return bundle.getString(key);
    }
}
