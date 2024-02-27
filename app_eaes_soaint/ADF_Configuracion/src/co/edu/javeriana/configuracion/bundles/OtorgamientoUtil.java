package co.edu.javeriana.configuracion.bundles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.util.Properties;

public class OtorgamientoUtil implements Serializable {
    @SuppressWarnings("compatibility:7343243710764068047")
    private static final long serialVersionUID = 1L;

    public OtorgamientoUtil() {
        super();
    }
    
    public static void recargarBundles() {
        OtorgamientoBundle.reloadBundle();
        ConstantesBundle.reloadConstantes();
    }
    
    public static boolean stringValido(String strt) {
        return !(strt == null || strt.trim().length() == 0);
    }
    
    public static Integer convertirStringAInteger(String strt){
        Integer valorNuevo = null;
        
        try {
            strt = strt != null && strt.length() > 0 ? strt : "0";
            valorNuevo = Integer.parseInt(strt);
            
        } catch(NumberFormatException nfe){
            nfe.printStackTrace();
        }//End try catch
        
        return valorNuevo;
    }
    
    /**
     * <p>Se encargá de obtener el archivo con extensión .properties basado en la
     * ruta determinada como parámetro de entrada</p>
     * 
     * @param directorio Ruta del file system donde se encuentra ubicado el .properties
     */
    public static Properties abrirArchivoDePropiedadesDesdeSistemaDeArchivos(String directorio) {
        System.out.println("[FLAG][OtorgamientoUtil][abrirArchivoDePropiedadesDesdeSistemaDeArchivos][Inicio]");
        System.out.println("[FLAG][OtorgamientoUtil][abrirArchivoDePropiedadesDesdeSistemaDeArchivos][Directorio: " + directorio + "]");
        
        //InputStream input = null;
        Properties prop = new Properties();
        
        try (InputStream input = new FileInputStream(directorio)) {
            //Cargar archivo de propiedades
            prop.load(input);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }//End try catch
        
        /*finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }//End try catch
            }//End if
        }//End try catch finally*/
        
        System.out.println("[FLAG][OtorgamientoUtil][abrirArchivoDePropiedadesDesdeSistemaDeArchivos][Fin]");
        return prop;
    }
    
    
}
