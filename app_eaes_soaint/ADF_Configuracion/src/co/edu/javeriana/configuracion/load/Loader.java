package co.edu.javeriana.configuracion.load;

import co.edu.javeriana.configuracion.conf.Configuracion;

import co.edu.javeriana.configuracion.utils.JsfUtils;

import java.util.logging.Logger;
import java.io.File;

public class Loader {
    public static final Logger LOGGER = Logger.getLogger(Loader.class.getName());
    public static final String KEY_PATH = "config.server.path";
    public static final String WINDOWS_UNID = "C:\\";
    private String basePath;
    protected static Configuracion conf;
    public Loader() {
        super();
    }

    public Loader(final String path) {
        super();
        this.basePath = path;
    }
    public Configuracion cargarConfiguracion() {
        String path="";
        if ("/".equals(File.separator)) {
            path=JsfUtils.getInitParam(KEY_PATH)+ "configuracion.xml";
        }else{
            path=this.basePath + "u01" + File.separator + "bpm" + File.separator + "configuracion.xml"; 
        }
        LOGGER.finest("Entrando a cargar configuracion.");
        LOGGER.finest("Ruta del archivo ."+path);
        final File inputFile = new File(path);
        final LeerXMLDom leer = new LeerXMLDom();
        Loader.conf = leer.cargarConfiguracion(inputFile);
        LOGGER.finest("Se termino de leer la configuracion ."+Loader.conf.getOsb().getHost());
        return Loader.conf;
    }

    public String getOSBUrl() {
        final Configuracion conf = this.getConf();
        return conf.getOsb().getProtocol() + conf.getOsb().getHost() + ":" + conf.getOsb().getPort();
    }
    public String getBPMUrl() {
        final Configuracion conf = this.getConf();
        return conf.getBpm().getProtocol() + conf.getBpm().getHost() + ":" + conf.getBpm().getPort();
    }
    public String getWCCUrl() {
        final Configuracion conf = this.getConf();
        return conf.getWcc().getProtocol() + conf.getWcc().getHost() + ":" + conf.getWcc().getPort();
    }
    public String getVisorWCCUrl() {
        final Configuracion conf = this.getConf();
        return conf.getVisorWcc().getProtocol() + conf.getVisorWcc().getHost() + ":" + conf.getVisorWcc().getPort();
    }
    public void setBasePath(final String basePath) {
        this.basePath = basePath;
    }

    public String getBasePath() {
        return basePath;
    }
    public static Loader getInstance(){
        return new Loader(Loader.WINDOWS_UNID);
    }
    public Configuracion getConf() {
        if (Loader.conf == null) {
            return this.cargarConfiguracion();
        }
        return Loader.conf;
    }
}
