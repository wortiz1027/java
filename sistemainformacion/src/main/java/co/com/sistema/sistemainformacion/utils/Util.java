package co.com.sistema.sistemainformacion.utils;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Util {
    
    public static LocalDate formatDate(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.s", Locale.ENGLISH);
        
        try {

            LocalDate date = LocalDate.parse(fecha, formatter);
            
            return date;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static String Encriptar(String texto) {
 
        String secretKey = Constantes.SECRET_KEY;
        String base64EncryptedString = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance(Constantes.INSTANCE);
            byte[] digestOfPassword = md.digest(secretKey.getBytes(Constantes.ENCODING));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, Constantes.SECRET_KEY_SPEC);
            Cipher cipher = Cipher.getInstance(Constantes.SECRET_KEY_SPEC);
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = texto.getBytes(Constantes.ENCODING);
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
    
    public static String Desencriptar(String textoEncriptado) {
 
        String secretKey = Constantes.SECRET_KEY;
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes(Constantes.ENCODING));
            MessageDigest md = MessageDigest.getInstance(Constantes.INSTANCE);
            byte[] digestOfPassword = md.digest(secretKey.getBytes(Constantes.ENCODING));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, Constantes.SECRET_KEY_SPEC);
 
            Cipher decipher = Cipher.getInstance(Constantes.SECRET_KEY_SPEC);
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, Constantes.ENCODING);
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
    
    /*public static void main(String x[]){
        System.out.println("Fecha: " + Util.formatDate("1993-07-05 00:00:00.0"));
        System.out.println("Encriptar: " + Util.Encriptar("cAdminstrador1993*"));
        System.out.println("Desencriptar: " + Util.Desencriptar("Lx6Hg1cJVKI2jxHlramnlXl62U78o6Vh"));
    }*/
    
}