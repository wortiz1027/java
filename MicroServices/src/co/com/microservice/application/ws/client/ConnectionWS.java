package co.com.microservice.application.ws.client;

import javax.xml.ws.soap.SOAPFaultException;

import com.integracion.web.services.proxy.BookProducerJMSProcess;
import com.integracion.web.services.proxy.Bookproducerjmsprocess_client_ep;

public class ConnectionWS {
	
	public static BookProducerJMSProcess getConnectionWS() throws SOAPFaultException, Exception {
		Bookproducerjmsprocess_client_ep client = new Bookproducerjmsprocess_client_ep();
		BookProducerJMSProcess connection = client.getBookProducerJMSProcess_pt();
		return connection;
	}
	
}
