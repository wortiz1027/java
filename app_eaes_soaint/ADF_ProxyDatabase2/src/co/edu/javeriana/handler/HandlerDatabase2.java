package co.edu.javeriana.handler;

import co.edu.javeriana.configuracion.service.HandlerMessageProxyService;

import java.util.logging.Level;

import javax.xml.ws.handler.soap.SOAPMessageContext;

import oracle.adf.share.logging.ADFLogger;

public class HandlerDatabase2 extends HandlerMessageProxyService {
    
    public static final ADFLogger LOGGER = ADFLogger.createADFLogger(HandlerDatabase2.class);
    
    public HandlerDatabase2() {
        super();
    }
    
    @Override
    public boolean handleMessage(SOAPMessageContext context){
        LOGGER.begin(Level.FINEST, this.getClass().getName()+".handleMessage");
        this.writeLog(context, LOGGER);
        LOGGER.end(Level.FINEST, this.getClass().getName()+".handleMessage");
        return Boolean.TRUE;
    }
    
}
