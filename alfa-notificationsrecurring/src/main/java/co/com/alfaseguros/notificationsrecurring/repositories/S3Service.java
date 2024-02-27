package co.com.alfaseguros.notificationsrecurring.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.amazonaws.util.IOUtils;

import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.AttachmentsRepository;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
@RequiredArgsConstructor
public class S3Service implements AttachmentsRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(S3Service.class);
	
	public byte[] getPresignedUrl(String url) throws ExcepcionAlfa {

        try {
        	byte[] bytes;
        	LOG.info("getPresignedUrl ---------------------");
        	
            // Create a JDK HttpURLConnection for communicating with S3
        	URL objUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) objUrl.openConnection();
                        
            try (InputStream content = connection.getInputStream()) {
            	bytes= IOUtils.toByteArray(content);                
            }
            
            return bytes;
        } catch (S3Exception | IOException e) {  
        	LOG.error("Error ",e);
        	throw new ExcepcionAlfa(MessageResponseEnum.BUCKET_CALL_ERROR);
        } 
	}
}
