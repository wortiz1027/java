package co.com.alfaseguros.notificationsrecurring.repositories.contracts;

import org.springframework.http.ResponseEntity;

import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;


public interface InfraServices <T, R> {
	
	ResponseEntity<R> call(T data) throws ExcepcionAlfa;
	
}
