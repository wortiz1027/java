package co.com.alfaseguros.notificationsrecurring.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.Base64;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;


public class Utils {
	
	private static final Logger LOG = LoggerFactory.getLogger(Utils.class);
	
	private Utils() throws ExcepcionAlfa {
		throw new ExcepcionAlfa(MessageResponseEnum.SYSTEM_ERROR, "Error instanciando Utils" );
	}
	
	public static ExcepcionAlfa evaluateException(Throwable ex) {
        return evaluateException(ex, null);
    }
	
	public static ExcepcionAlfa evaluateException(Throwable ex, String message) {
        String msgError = null;
        if (message != null) {
            msgError = message + ": " + ex.getMessage();
        } else {
            ex.getMessage();
        }

        if (ex instanceof ExcepcionAlfa) {
            if (message != null) {
                return new ExcepcionAlfa(((ExcepcionAlfa) ex).getCodError(), msgError);
            } else {
                return new ExcepcionAlfa(((ExcepcionAlfa) ex).getCodError(), ex.getMessage());
            }

        } else if (ex instanceof SQLException) {
            return new ExcepcionAlfa(MessageResponseEnum.SYSTEM_ERROR.getCodigo(), msgError, ex);
        } else {
            return new ExcepcionAlfa(ex.getMessage(), ex);
        }
    }
	
	public static String builtHash(String valor) throws ExcepcionAlfa {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");		
	        byte[] hash = digest.digest(valor.getBytes(StandardCharsets.UTF_8));
	        String sha256hex = Hex.encodeHexString(hash);
	
	        return Base64.getEncoder().encodeToString(sha256hex.getBytes());
	        
		} catch (Exception e) {
			LOG.error("Error builtHash ",e);
			throw new ExcepcionAlfa(MessageResponseEnum.SYSTEM_ERROR);
		}
	}
}
