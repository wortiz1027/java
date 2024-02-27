package co.com.microservice.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.microservice.application.ws.client.InvokeJMSProducerWS;

import com.integracion.web.services.types.LibroType;
import com.integracion.web.services.types.RequestType;
import com.integracion.web.services.types.ResponseType;

@RestController
@RequestMapping(value = "/api/v1.0")
public class RestJMSProducerService {
	
	@RequestMapping(value    = "/libros",
			        method   = RequestMethod.POST,
			        headers  = "Accept=application/json",
			        consumes = MediaType.APPLICATION_JSON_VALUE, 
			        produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<ResponseType> crearInformacionLibro(@RequestBody LibroType libro) {
		InvokeJMSProducerWS invoke = new InvokeJMSProducerWS();
		
		if (libro == null){
			new ResponseEntity<ResponseType>(HttpStatus.NO_CONTENT);
		}		
		
		RequestType request = new RequestType();
		request.setLibro(libro);
		
		ResponseType response = invoke.invokeJMSProducerOperation(request); 
		return new ResponseEntity<ResponseType>(response, HttpStatus.OK);		
	}
	
}
