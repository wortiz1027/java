package co.edu.javeriana.configuracion.bundles;

import co.edu.javeriana.configuracion.load.Loader;
import co.edu.javeriana.configuracion.utils.JsfUtils;

import java.io.File;
import java.io.Serializable;

import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.Properties;

/**
 * <p>Esta clase se encargará de manejar en un matriz todos los valores
 * asociados a un archivo de propiedades; de este modo, se podran manejar todos los labels
 * que se expondran en las interfaces de usuario</p>
 *
 * @author <a href="mailto:efranco@soaint.com">Eduardo José Franco Rivera</a>
 * @version v.0.0.1
 */
public class OtorgamientoBundle extends ListResourceBundle implements Serializable {
    @SuppressWarnings("compatibility:2826456344063770885")
    private static final long serialVersionUID = 1L;

    private static final String KEY_BUNDLE = "co.bcs.otorgamiento.bundle.pathUIBundle";
    private static final String SERVER_PATH = "config.server.path";
    private static Object[][] contents = readPropertyFile();
    private static Properties prop;

    /**
     * Constructor de OtrogamientoBundle
     */
    public OtorgamientoBundle() {
        super();
    }

    /**
     * <p>Se encargará de recargar el bundle, esto con la finalidad de actualizar todas las llaves y sus
     * valores basandose en la incporación de nuevos variables en tiempo de ejecución</p>
     */
    public static void reloadBundle() {
        contents = readPropertyFile();
    }

    @Override
    protected Object[][] getContents() {
        return contents;
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
    /**
     * <p>Se encargará de obtener el property y hacer lectura de cada una de los
     * pares nombre valor de este para incorporarlos a una matriz de 2Xn</p>
     *
     * @return Matriz con las llaves y valores
     */
    protected static Object[][] readPropertyFile() {
        Object[][] data = null;
        if("/".equals(File.separator)){
            prop = OtorgamientoUtil.abrirArchivoDePropiedadesDesdeSistemaDeArchivos(JsfUtils.getInitParam(SERVER_PATH)+"HPTC_Otorgamiento.properties");
        }else{
            prop = OtorgamientoUtil.abrirArchivoDePropiedadesDesdeSistemaDeArchivos(Loader.WINDOWS_UNID + "u01" + File.separator + "bpm" + File.separator + "HPTC_Otorgamiento.properties");    
        }
        
        //Carga un archivo de propiedades
        Enumeration propKeys = prop.keys();
        data = new Object[prop.size()][2];
        int i = 0;

        while (propKeys.hasMoreElements()) {
            String key = (String) propKeys.nextElement();
            String value = prop.getProperty(key);
            data[i][0] = key;
            data[i][1] = value;
            i++;
        } //End while

        return data;
    }
}
