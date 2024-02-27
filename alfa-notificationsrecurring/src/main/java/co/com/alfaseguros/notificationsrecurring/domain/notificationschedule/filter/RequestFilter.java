package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFilter implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("StatusList")
	private List<StatusList> statusList;

}
