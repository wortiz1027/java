package co.edu.javeriana.external.services.avianca.infraestructure.client;

import co.edu.javeriana.external.services.avianca.dtos.Request;
import co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model.FlightOption;
import co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model.GetFlights;
import co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model.GetFlightsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import java.util.GregorianCalendar;

public class AviancaWsClient extends WebServiceGatewaySupport {

    private static final Logger LOG = LoggerFactory.getLogger(AviancaWsClient.class);

    public GetFlightsResponse getFlights(Request request) {

        FlightOption requestSOAP = new FlightOption();
        GetFlights req = new GetFlights();
        QName qualifiedName;
        GetFlightsResponse response = new GetFlightsResponse();
        try {
            GregorianCalendar calendar = new GregorianCalendar();

            calendar.setTime(request.getDepartureDate());

            requestSOAP.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));

            qualifiedName = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "DestinationCityDescription");
            requestSOAP.setDestinationCityDescription(new JAXBElement<>(qualifiedName, String.class, null, request.getDestinationCityDescription()));

            requestSOAP.setOneWay(request.getOneWay());

            qualifiedName = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "OriginCityDescription");
            requestSOAP.setOriginCityDescription(new JAXBElement<>(qualifiedName, String.class, null, request.getOriginCityDescription()));

            requestSOAP.setPassengersNumber(request.getPassengersNumber());

            calendar.setTime(request.getReturnDate());
            requestSOAP.setReturnDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
            qualifiedName = new QName("http://tempuri.org/", "flightOption");
            req.setFlightOption(new JAXBElement<>(qualifiedName, FlightOption.class, null, requestSOAP));

            response = (GetFlightsResponse) getWebServiceTemplate().marshalSendAndReceive(req,new SoapActionCallback("http://tempuri.org/IAviancaService/GetFlights"));

        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return response;
    }
}
