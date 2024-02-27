package co.edu.javeriana.configuracion.bundles;


import co.edu.javeriana.configuracion.load.Loader;
import co.edu.javeriana.configuracion.utils.JsfUtils;

import java.io.File;
import java.io.Serializable;

import java.util.Properties;

/**
 * <p>Esta clase se encargará de manejar todos los parámetros de aplicación
 * que se crean pertinentes para el funcionamiento de la aplicación.</p>
 *
 * @author <a href="mailto:efranco@soaint.com">Eduardo José Franco Rivera</a>
 * @version v.0.0.1
 */
public class ConstantesBundle implements Serializable {
    @SuppressWarnings("compatibility:-331362240860302136")
    private static final long serialVersionUID = 1L;

    private static final String KEY_APPLICATION = "co.bcs.otorgamiento.bundle.pathConstantBundle";
    private static Properties prop = crearProperties();
    
    /**
     * Constructor ConstantesBundle
     */
    public ConstantesBundle() {
        super();
    }
    
    /**
     * <p>Se encargará de recargar los valores de las constates que se están manejando,
     * esto con la finalidad de obtener valores o cambios nuevos sobre el properties</p>
     */
    public static void reloadConstantes() {
        prop = loadProperties();
    }
    
    /**
     * <p>Se encargará de entregar el valor de una llave que se encuentre 
     * en el bundle de constantes</p>
     * 
     * @param key Llave a buscar
     * @return Valor asociado a la llave pasada como parámetro
     */
    public static String getValueFromKey(Object key) {
        return prop.getProperty(key.toString());
    }

    protected static Properties crearProperties() {
        if (prop == null) {
            return loadProperties();
        } //End if

        return prop;
    }

    /**
     * <p>Se encargará de cargar el properties basandose en una ruta determinado 
     * en el sistema de archivos</p>
     * 
     * @return Archivo de propiedades
     */
    protected static Properties loadProperties() {
        if("/".equals(File.separator)){
            return OtorgamientoUtil.abrirArchivoDePropiedadesDesdeSistemaDeArchivos(JsfUtils.getInitParam(KEY_APPLICATION));
        }
        return OtorgamientoUtil.abrirArchivoDePropiedadesDesdeSistemaDeArchivos(Loader.WINDOWS_UNID + "u01" + File.separator + "bpm" + File.separator + "BCS_CT_Otorgamiento.properties");
    }
}
