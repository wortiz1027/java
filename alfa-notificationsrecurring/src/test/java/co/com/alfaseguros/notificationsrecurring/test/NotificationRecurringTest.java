package co.com.alfaseguros.notificationsrecurring.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Response;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.RequestFile;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.ResponseFile;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.RequesToken;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.ResponseToken;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.ResponseSchedule;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.edit.RequestEdit;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.RequestFilter;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.ResponseFilter;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.RequestNotificationType;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.ResponseNotificationType;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.helper.KitControllerTestsHelper;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.AttachmentsRepository;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.InfraServices;
import co.com.alfaseguros.notificationsrecurring.service.NotificationRecurring;
import co.com.alfaseguros.notificationsrecurring.service.Operation;


@SpringBootTest
@ActiveProfiles("test")
class NotificationRecurringTest {
	
		
	@Mock
	@Qualifier("findNotificationType")
	private InfraServices<RequestNotificationType, ResponseNotificationType> notificationType;
	
	@Mock
	private AttachmentsRepository attachments;	
	
	@Mock
	@Qualifier("attachments")
	private InfraServices<RequestFile,ResponseFile> getLinks;
	
	@Mock
	@Qualifier("getToken")
	private InfraServices<RequesToken,ResponseToken> getToken;
	
	@Mock
	@Qualifier("getSchedule")
	private InfraServices<RequestFilter,ResponseFilter> notificarionFilter;
	
	@Mock
	@Qualifier("editSchedule")
	private InfraServices<RequestEdit,ResponseSchedule> editNotification;
	
	@Mock
	private co.com.alfaseguros.notificationsrecurring.repositories.contracts.Notification<co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Request, Response> notifications;
		
	@Value("${alfa.props.zone-time}")
	private String zoneTime;
	
	@Value("${adl.attachs.keyPoliza}")
    private String keyPolizaId;
	
	@Value("${alfa.recurring.notificationrecurring.max-recurring}")
	private int maxrecurring;
			
	private Operation notificationRecurring;
	
		
	@BeforeEach
	public void setUp() {
		try {
			MockitoAnnotations.initMocks(this);
		
		
			Mockito.when(this.notificationType.call(Mockito.any()))
			   .thenReturn(KitControllerTestsHelper.buildGetNotificationType());		
	
			Mockito.when(this.getToken.call(Mockito.any()))
				   .thenReturn(KitControllerTestsHelper.buildRespToken());			
					
			Mockito.when(this.getLinks.call(Mockito.any()))
			       .thenReturn(KitControllerTestsHelper.buildRespAttchment());
			
			Mockito.when(this.notifications.call(Mockito.any(), Mockito.anyMap()))
			       .thenReturn(KitControllerTestsHelper.buildRespSendNotification());
			
			Mockito.when(this.notificarionFilter.call(Mockito.any()))
		       .thenReturn(KitControllerTestsHelper.buildRespRecurringFilter());
			
			Mockito.when(this.editNotification.call(Mockito.any()))
		    .thenReturn(KitControllerTestsHelper.buildRespRecurringEdit());
			
			
			this.notificationRecurring = new NotificationRecurring(this.notificationType, this.notificarionFilter, this.editNotification, this.getLinks, this.getToken, this.notifications, attachments);
			org.springframework.test.util.ReflectionTestUtils.setField(this.notificationRecurring, "zoneTime", this.zoneTime);
			org.springframework.test.util.ReflectionTestUtils.setField(this.notificationRecurring, "keyPolizaId", this.keyPolizaId);
			org.springframework.test.util.ReflectionTestUtils.setField(this.notificationRecurring, "maxrecurring", this.maxrecurring);
			
		} catch (ExcepcionAlfa e) {
			e.printStackTrace();
		}
	}

	@Test
	void whenValidNotificarionFilter() throws ExcepcionAlfa {
		this.notificationRecurring.init();		
		verify(this.notificarionFilter,times(1)).call(Mockito.any()); //same as normal verify method			
	}
	
	@Test
	void whenValidcallfindByNotification() throws ExcepcionAlfa {
		this.notificationRecurring.init();		
		verify(this.notificationType,times(1)).call(Mockito.any()); //same as normal verify method
	}
	
	@Test
	void whenValidcallgetToken() throws ExcepcionAlfa {
		this.notificationRecurring.init();		
		verify(this.getToken,times(1)).call(Mockito.any()); //same as normal verify method
	}
	
	@Test
	void whenValidcallgetLinks() throws ExcepcionAlfa {
		this.notificationRecurring.init();		
		verify(this.getLinks,times(1)).call(Mockito.any()); //same as normal verify method
	}
	
	@Test
	void whenValidcallEditNotification() throws ExcepcionAlfa {
		this.notificationRecurring.init();		
		verify(this.editNotification,times(1)).call(Mockito.any()); //same as normal verify method
	}
	
	@Test
	void whenValidcallNotification() throws ExcepcionAlfa {
		this.notificationRecurring.init();		
		verify(this.notifications,times(1)).call(Mockito.any(),Mockito.any()); //same as normal verify method
	}
}
