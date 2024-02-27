package co.edu.javeriana.configuracion.utils;


import co.edu.javeriana.configuracion.service.ResponseService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import oracle.adf.share.logging.ADFLogger;

public class ThreadUtils {
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(ThreadUtils.class);
    public ThreadUtils() {
        super();
    }
    
    public static void waitFuture(final Future future){
        while(!future.isDone()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                LOGGER.severe(e);
            }
        };
    }
    
    
    
    public static ResponseService loadServiceFuture(final Future future){
        ResponseService errorResponses = new ResponseService();   
        try {
            errorResponses = ((ResponseService)future.get());
        } catch (InterruptedException e) {
            LOGGER.severe(e);
        } catch (ExecutionException e) {
            LOGGER.severe(e);
        } 

        return errorResponses;
        
    }
}
