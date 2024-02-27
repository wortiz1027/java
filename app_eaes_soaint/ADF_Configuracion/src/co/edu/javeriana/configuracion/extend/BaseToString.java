package co.edu.javeriana.configuracion.extend;

import java.lang.reflect.Field;

import oracle.adf.share.logging.ADFLogger;

public class BaseToString {
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(BaseToString.class);
    @Override
    public String toString() {
        final StringBuilder sb=new StringBuilder("Clase: "+this.getClass().getName());
        sb.append(System.getProperty("line.separator"));
        sb.append(super.toString());
        final Field[] attr=this.getClass().getDeclaredFields();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            final String name=temp.getName();
            try{
                sb.append("Atributo: "+name+" => "+temp.get(this)+System.getProperty("line.separator"));
            } catch (IllegalAccessException e) {
                LOGGER.warning("Error en el metodo toString \" " +name + "\", originado por :  " +e.getMessage());
            }catch (Exception e) {
                LOGGER.warning("Error en el metodo toString \" " +name + "\", originado por :  " +e.getMessage());
            }
        }
        
        return sb.toString();
    }
}
