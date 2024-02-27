package co.com.adf.proxies.countries.handler;

import co.com.adf.configuraciones.service.HandlerMessageProxyService;

import java.util.HashMap;
import java.util.logging.Level;

import javax.xml.ws.handler.soap.SOAPMessageContext;

import oracle.adf.share.logging.ADFLogger;

public class HandlerCountries extends HandlerMessageProxyService {
    public static final ADFLogger LOGGER = ADFLogger.createADFLogger(HandlerCountries.class);
    
    public HandlerCountries() {
        super();
    }
    
    @Override
    public boolean handleMessage(SOAPMessageContext context){
        LOGGER.begin(Level.FINEST, String.format("%s.%s", this.getClass().getName(), ".handleMessage"), new HashMap<String, String>());
        this.writeLog(context, LOGGER);
        LOGGER.end(Level.FINEST, String.format("%s.%s", this.getClass().getName(), ".handleMessage"));
        return Boolean.TRUE;
    }
}