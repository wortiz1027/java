package co.com.microservice.application.ws.client;

import com.integracion.web.services.proxy.BookProducerJMSProcess;
import com.integracion.web.services.types.RequestType;
import com.integracion.web.services.types.ResponseType;

public class InvokeJMSProducerWS {
	
	public ResponseType invokeJMSProducerOperation(RequestType request){
		
		try {
			BookProducerJMSProcess connection = ConnectionWS.getConnectionWS();
			ResponseType response = connection.process(request);
			System.out.println("Ejecucion Servicio: " + response.getBody().getDescripcion());
			return response;
		} catch (Exception e) {
			     System.out.println("Error! Llamando el servicio . . . " + e.toString());
		}
		return null;
		
	} 
	
}
