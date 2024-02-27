package co.com.alfaseguros.notificationsrecurring.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import co.com.alfaseguros.notificationsrecurring.domain.Credential;
import co.com.alfaseguros.notificationsrecurring.domain.NotificationType;
import co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Response;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.ResponseFile;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.ResponseToken;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.ItemGenerico;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.Notification;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.NotificationPayload;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.ResponseSchedule;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.ResponseFilter;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.ResponseNotificationType;


public class KitControllerTestsHelper {
	
	public static NotificationType buildNotificationType() {
		final NotificationType notificationType = new NotificationType();
		notificationType.setBody("Bienvenidos a seguros Alfa");
		notificationType.setFrom("certificados@segurosalfa.com.co");
		notificationType.setNotificationId("KIT_BIENVENIDA");
		notificationType.setSubject("Bienvenido a Seguros Alfa");
		notificationType.setTemplate("emails/newsletter/tpl_newsletter_seguros_alfa_editable_con_sponsor.ftl");
		
		return notificationType;		
	}
	
	/*
	
	
	
	
	
	
	
	
	
	public static ResponseEntity<ResponseRecurring> buildRespRecurringSave() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseRecurring response = new ResponseRecurring();
		response.setStatusCode("200");
			
		return (ResponseEntity<ResponseRecurring>) generateTokeEntity(response, HttpStatus.OK);
	}
			
	
	
	
	
	public static ResponseEntity<ResponseRecurring> buildRecurringAddBad() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseRecurring response = new ResponseRecurring();
		response.setStatusCode("400");
			
		return (ResponseEntity<ResponseRecurring>) generateTokeEntity(response, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	public static Request buildNotification() {
		Request data = new Request();
		
		
		
		AttachmentsReferences attachPoli = new AttachmentsReferences();
		attachPoli.setKey("REFERENCIA_POLIZA");
		attachPoli.setValue("cc11345944signed");
		
		
		List<AttachmentsReferences> attachmentsReferences = new ArrayList<>();
		attachmentsReferences.add(attachPoli);
		
		
		List<NotificationParameters> notificationParameters = new ArrayList<NotificationParameters>();
		
		NotificationParameters notiParam = new NotificationParameters();
		notiParam.setKey("KEY_NAME_CLIENT");
		notiParam.setKey("Ian");
		notificationParameters.add(notiParam);
		
		notiParam = new NotificationParameters();
		notiParam.setKey("KEY_NAME_SPONSOR");
		notiParam.setKey("Porvenir");
		notificationParameters.add(notiParam);
		
		notiParam = new NotificationParameters();
		notiParam.setKey("KEY_VALUE_ASSURANCE");
		notiParam.setKey("Mensual");
		notificationParameters.add(notiParam);
		
		notiParam = new NotificationParameters();
		notiParam.setKey("KEY_VALIDITY_PERIOD");
		notiParam.setKey("Mensual");
		notificationParameters.add(notiParam);
		
		data.setNotificationParameters(notificationParameters);		
		data.setAttachmentsReferences(attachmentsReferences);
		data.setNotificationType("KIT_BIENVENIDA");
		data.setEmail("ian.beltran1990@gmail.com");
		return data;
	}	
	*/
	
	public static ResponseEntity<ResponseSchedule> buildRespRecurringEditBad() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseSchedule response = new ResponseSchedule();
		response.setStatusCode("400");
			
		return (ResponseEntity<ResponseSchedule>) generateTokeEntity(response, HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity<ResponseToken> buildRespTokenBad() {
		
		final ResponseToken responseToken = new ResponseToken();
		responseToken.setStatusCode("500");		
						
		return (ResponseEntity<ResponseToken>) generateTokeEntity(responseToken, HttpStatus.INTERNAL_SERVER_ERROR);				
	}
	
	public static Credential buildCredential() {
		Credential credential = new Credential();
		credential.setAdlClientId("123");
		credential.setAdlSecretId("456");
		return credential;
	}
	
	public static ResponseEntity<ResponseSchedule> buildRespRecurringEdit() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseSchedule response = new ResponseSchedule();
		response.setStatusCode("200");
			
		return (ResponseEntity<ResponseSchedule>) generateTokeEntity(response, HttpStatus.OK);
	}
	
	public static ResponseEntity<ResponseFilter> buildRespRecurringFilter() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseFilter response = new ResponseFilter();
		response.setStatusCode("200");
		
		List<Notification> listaNotifications = new ArrayList<>();
		Notification notification = new Notification();
		
		NotificationPayload notificationPayload = new NotificationPayload();
		notificationPayload.setNotificationType("KIT_BIENVENIDA");
		List<ItemGenerico> attachmentsReferences = new ArrayList<>();	
		List<ItemGenerico> notificationParameters = new ArrayList<>();
		
		attachmentsReferences.add(new ItemGenerico("poliza", "http://wwww.google.com"));
		attachmentsReferences.add(new ItemGenerico("clausula", "http://wwww.google.com"));
		
		notificationParameters.add(new ItemGenerico("KEY_NAME_CLIENT", "ian"));
		notificationParameters.add(new ItemGenerico("KEY_NAME_SPONSOR", "Porvenir"));
		notificationParameters.add(new ItemGenerico("KEY_VALUE_ASSURANCE", "$20.000"));
		
				
		notificationPayload.setNotificationParameters(notificationParameters);
		
		notification.setNotificationType("KIT_BIENVENIDA");
		notification.setPolicyId("123456");
		notification.setNotificationPayload(notificationPayload);
		notification.setRetries(0);
		
		listaNotifications.add(notification);
		response.setListaNotification(listaNotifications);
			
		return (ResponseEntity<ResponseFilter>) generateTokeEntity(response, HttpStatus.OK);
	}
	
	public static ResponseEntity<ResponseToken> buildRespToken() {
		
		final ResponseToken responseToken = new ResponseToken();
		responseToken.setStatusCode("200");
		responseToken.setTokenType("eyJraWQiOiJDMUFueGdENHZNcDNlRHc0bnlWcDFrSW42cXdEcUFhb2xEMkJUbk5wZ0RrPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI0azRxM2Y5OHE0c3NxczU2amdtcDZyOWl2ZSIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYWxmYS1kaWdpdGFsLWRldi11c2VyLWlkZW50aXR5LWFwaVwvRG93bmxvYWRMaWFiaWxpdHkiLCJhdXRoX3RpbWUiOjE2MDMwNTA5MDAsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTIuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0yX3d2c0c0MGpWUSIsImV4cCI6MTYwMzA1NDUwMCwiaWF0IjoxNjAzMDUwOTAwLCJ2ZXJzaW9uIjoyLCJqdGkiOiIzMDBkMjljZC02MjNkLTQ4NGMtYjJkNC0yYmFiOTIxYTM3YzEiLCJjbGllbnRfaWQiOiI0azRxM2Y5OHE0c3NxczU2amdtcDZyOWl2ZSJ9.JPcO4cKV_mEry3FQR-4n-Jgd7aVFFDJ9bUim0YLUYDpcr5tDvMtP59FU5Gerli5lhU8RaEHmEJ83RGs2iALdhIiEczK-JWsqqHXmfDvzyaMys13hT8R90xJ_KXKcN8aZqJEGKn14xveoiWYopb50PHxVgU5jDySPjFf3Wy7x15naITOmKwP6ByGNiupScCE2oSjHW2htlirEApg7yPFdFf8UJ64CN5wk8YLyC-XOw-n85TEJC_r1VB0ONDkkaAQwWb73DvEFeB6lev1DDkNiT5ISFQe5HUe_qDsCO50dPz9HDw1v1OKAnYuiWluXH86_5QEx3dBDxI6tCS4vE32A1A");
						
		return (ResponseEntity<ResponseToken>) generateTokeEntity(responseToken, HttpStatus.OK);				
	}
	
	public static ResponseEntity<ResponseFile> buildRespAttchment() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseFile responseAttach = new ResponseFile();
		responseAttach.setClauses("http://wwww.google.com");
		responseAttach.setSignedPolicy("http://wwww.google.com");	
		responseAttach.setMessage("ok");		
				
		return (ResponseEntity<ResponseFile>) generateTokeEntity(responseAttach, HttpStatus.OK);
	}
	
	public static ResponseEntity<Response> buildRespSendNotification() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final Response response = new Response();
		response.setStatusCode("200");
			
		return (ResponseEntity<Response>) generateTokeEntity(response, HttpStatus.OK);
	}
	
	public static ResponseEntity<ResponseNotificationType> buildGetNotificationType() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseNotificationType response = new ResponseNotificationType();
		response.setNotificationType(buildNotificationType());
		response.setStatusCode("200");
			
		return (ResponseEntity<ResponseNotificationType>) generateTokeEntity(response, HttpStatus.OK);
	}
	
	public static ResponseEntity<ResponseNotificationType> buildGetNotificationTypeBadResponse() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseNotificationType response = new ResponseNotificationType();
		response.setNotificationType(buildNotificationType());
		response.setStatusCode("400");
			
		return (ResponseEntity<ResponseNotificationType>) generateTokeEntity(response, HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity<ResponseFile> buildRespBadAttchment() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseFile responseAttach = new ResponseFile();		
		responseAttach.setMessage("error");		
				
		return (ResponseEntity<ResponseFile>) generateTokeEntity(responseAttach, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<Response> buildRespSendBadRespNotification() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final Response response = new Response();
		response.setStatusCode("400");
			
		return (ResponseEntity<Response>) generateTokeEntity(response, HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity<ResponseFilter> buildRespRecurringFilterBad() {
		
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		final ResponseFilter response = new ResponseFilter();
		response.setStatusCode("400");
			
		return (ResponseEntity<ResponseFilter>) generateTokeEntity(response, HttpStatus.BAD_REQUEST);
	}
	
	private static ResponseEntity<?> generateTokeEntity(Object t, HttpStatus httpStatus) {
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<>(
				t,
			    header, 
			    httpStatus
			);		
	}
}

