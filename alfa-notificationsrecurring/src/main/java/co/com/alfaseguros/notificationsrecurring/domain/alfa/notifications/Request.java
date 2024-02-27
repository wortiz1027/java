package co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;

@Data
public final class Request implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String from;
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private String template;
	private transient Map<String, Object> params;   
    
    public boolean isValidEmail(String email) {
    	String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    	
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(email);
    	
    	return matcher.matches();
    }
    
}
