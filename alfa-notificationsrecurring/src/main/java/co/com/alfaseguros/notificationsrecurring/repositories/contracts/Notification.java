package co.com.alfaseguros.notificationsrecurring.repositories.contracts;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;

public interface Notification<T, R>  {
	
	ResponseEntity<R> call(T data, Map<String, byte[]> attachs) throws ExcepcionAlfa;

	
}
