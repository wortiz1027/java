package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemGenerico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String key;
	private String value;

}
