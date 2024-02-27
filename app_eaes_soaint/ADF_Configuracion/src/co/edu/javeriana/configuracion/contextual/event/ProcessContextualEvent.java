package co.edu.javeriana.configuracion.contextual.event;

import co.edu.javeriana.configuracion.contextual.event.ProcessContextualEventInterface;

import co.edu.javeriana.configuracion.utils.JsfUtils;
import java.util.logging.Level;
import oracle.adf.share.logging.ADFLogger;


public class ProcessContextualEvent {
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(ProcessContextualEvent.class);
    public ProcessContextualEvent() {
        super();
    }
    public void onError(final Object payload,final String mbPath,final Object extra){
        LOGGER.beginRequest(Level.FINEST);
        final ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processOnError(payload,extra);
        }
        LOGGER.endRequest(Level.FINEST);
    }
    public void onCleanError(final Object payload,final String mbPath,final Object extra){
        LOGGER.beginRequest(Level.FINEST);
        final ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processOnCleanError(payload,extra);
        }
        LOGGER.endRequest(Level.FINEST);
    }
    public void onChange(Object payload,String mbPath,Object extra){
        LOGGER.beginRequest(Level.FINEST);
        ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processOnChange(payload,extra);
        }
        LOGGER.endRequest(Level.FINEST);
    }
    public void onSearch(Object payload,String mbPath,Object extra){
        LOGGER.beginRequest(Level.FINEST);
        ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processOnSearch(payload,extra);
        }
        LOGGER.endRequest(Level.FINEST);
    }
    public void onRefresh(Object payload,String mbPath,Object extra){
        LOGGER.beginRequest(Level.FINEST);
        ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processOnRefresh(payload,extra);
        }
    }
    public void onSelect(Object payload,String mbPath,Object extra){
        LOGGER.beginRequest(Level.FINEST);
        ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processOnSelect(payload,extra);
        }
        LOGGER.endRequest(Level.FINEST);
    }
    public void onClick(Object payload,String mbPath,Object extra){
        LOGGER.beginRequest(Level.FINEST);
        ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processOnClick(payload,extra);
        }
        LOGGER.endRequest(Level.FINEST);
    }
    public void onValidateParticipante(Object payload,String mbPath,Object extra){
        LOGGER.beginRequest(Level.FINEST);
        ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processValidateParticipante(payload,extra);
        }
        LOGGER.endRequest(Level.FINEST);
    }
    
    public void onLoad(Object payload,String mbPath,Object extra){
        LOGGER.beginRequest(Level.FINEST);
        ProcessContextualEventInterface mb=(ProcessContextualEventInterface)JsfUtils.resolveExpression("#{"+mbPath.trim()+"}");
        if(mb != null){
            mb.processOnLoad(payload,extra);
        }
        LOGGER.endRequest(Level.FINEST);
    }
}
