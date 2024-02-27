package co.com.alfaseguros.notificationsrecurring.repositories.contracts;

import org.springframework.stereotype.Repository;

import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;

@Repository
public interface AttachmentsRepository {
	
	byte[] getPresignedUrl(String url) throws ExcepcionAlfa;
}
