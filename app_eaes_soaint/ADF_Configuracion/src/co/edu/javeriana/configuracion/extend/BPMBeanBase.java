package co.edu.javeriana.configuracion.extend;

import co.edu.javeriana.configuracion.annotations.payload.PayloadAttribute;

import co.edu.javeriana.configuracion.annotations.payload.PayloadAttributeSaveIgnore;
import co.edu.javeriana.configuracion.utils.JsfUtils;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import oracle.adf.share.logging.ADFLogger;

import oracle.binding.BindingContainer;
import oracle.binding.ControlBinding;

/**
* Clase para ser heredada por clases utilizadas como beans que se llenan
* con lo valores de los atributos definidos en el Page Definition
* Creada el 01-02-2014
* @author John D. Silva T.
* @version 1.0
**/

public abstract class BPMBeanBase extends BaseToString{
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(BPMBeanBase.class);
    private static final List<Class> TIPOS= new ArrayList<Class>();
    private Boolean ignoreAttributes=Boolean.FALSE;
    static{
        TIPOS.add(String.class);
        TIPOS.add(Double.class);
        TIPOS.add(Integer.class);
        TIPOS.add(Boolean.class);
        TIPOS.add(Float.class);
        TIPOS.add(Byte.class);
        TIPOS.add(Character.class);
        TIPOS.add(Long.class);
        TIPOS.add(Short.class);
        TIPOS.add(Date.class); 
    }
    public Field[] getClassAtributes(){
        return this.getClass().getDeclaredFields();
    }
    public void bindValue(){
        final Field[] attr=this.getClassAtributes();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            final String name=temp.getName();
            if(temp.isAnnotationPresent(PayloadAttribute.class) && this.isBasicType(temp)){
                try{
                    temp.set(this, this.getAtributeValue(name));
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el metodo bindValue \" " +name + "\", originado por :  " +e.getMessage());
                }catch (Exception e) {
                    LOGGER.warning("Error en el metodo bindValue \" " +name + "\", originado por :  " +e.getMessage());
                }
            }
        }
    }
    private Boolean isBasicType(final Field  field){
        final Iterator<Class> it=TIPOS.iterator();
        while(it.hasNext()){
            if(field.getType().equals(it.next())){
                return true;
            }
        }
        return false;
    }
    public void saveBindingValues(){
        final Field[] attr=this.getClassAtributes();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            final String name=temp.getName();
            if(temp.isAnnotationPresent(PayloadAttribute.class) && !(this.ignoreAttributes && temp.isAnnotationPresent(PayloadAttributeSaveIgnore.class))){
                try{
                    this.setAtributeValue(name,temp.get(this));
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el metodo saveBindingValues \" " +name + "\", originado por :  " +e.getMessage());
                }catch (Exception e) {
                    LOGGER.warning("Error en el metodo saveBindingValues \" " +name + "\", originado por :  " +e.getMessage());
                }
            }
        }
    }
    public void validarValores(){
        final Field[] attr=this.getClassAtributes();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            final String name=temp.getName();
            try{
                if(temp.get(this)==null && temp.getType().equals(Boolean.class)){
                    temp.set(this,Boolean.FALSE);
                }
                if(temp.get(this)==null && temp.getType().equals(String.class)){
                    temp.set(this,"");
                }
            } catch (IllegalAccessException e) {
                LOGGER.warning("Error en el metodo validarValores \" " +name + "\", originado por :  " +e.getMessage());
            }catch (Exception e) {
                LOGGER.warning("Error en el metodo validarValores \" " +name + "\", originado por :  " +e.getMessage());
            }
            
        }  
    }
    private Object getAtributeValue(final String name){
        Object valor=null;
        try {
            final BindingContainer bindingContainer =(BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            final ControlBinding ctrlBinding =bindingContainer.getControlBinding(name);
            final oracle.binding.AttributeBinding atributo =(oracle.binding.AttributeBinding)ctrlBinding;
            if (atributo.getInputValue() != null) {
                valor = atributo.getInputValue();
            }
        } catch (Exception e) {
            LOGGER.warning("Error en el metodo getAtributeValue \" " +name + "\", originado por :  " +e.getMessage());
        }catch(NoClassDefFoundError e){
            LOGGER.warning("Clase no encontrada - "+e.getMessage());
        }
        return valor;
    }
    private void setAtributeValue(final String name,final Object value){
        try {
            final BindingContainer bindingContainer =(BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            final ControlBinding ctrlBinding =bindingContainer.getControlBinding(name);
            final oracle.binding.AttributeBinding atributo =(oracle.binding.AttributeBinding)ctrlBinding;
            if (atributo != null) {
                atributo.setInputValue(value);
            }
        } catch (Exception e) {
            LOGGER.warning("Error en el metodo setAtributeValue, originado por :  " +e.getMessage());
        }catch(NoClassDefFoundError e){
            LOGGER.warning("Clase no encontrada - "+e.getMessage());
        }
    }

    public void setIgnoreAttributes(Boolean ignoreAttributes) {
        this.ignoreAttributes = ignoreAttributes;
    }

    public Boolean getIgnoreAttributes() {
        return ignoreAttributes;
    }
}
