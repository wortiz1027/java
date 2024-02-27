//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.08 a las 04:42:56 PM COT 
//


package co.com.service.dancarlton.services.domain.xsd;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dancarlton.co.reservas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dancarlton.co.reservas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetReservasRequest }
     * 
     */
    public GetReservasRequest createGetReservasRequest() {
        return new GetReservasRequest();
    }

    /**
     * Create an instance of {@link GetReservasResponse }
     * 
     */
    public GetReservasResponse createGetReservasResponse() {
        return new GetReservasResponse();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link ReservasList }
     * 
     */
    public ReservasList createReservasList() {
        return new ReservasList();
    }

    /**
     * Create an instance of {@link GetReservasByCodigoRequest }
     * 
     */
    public GetReservasByCodigoRequest createGetReservasByCodigoRequest() {
        return new GetReservasByCodigoRequest();
    }

    /**
     * Create an instance of {@link GetReservasByCodigoResponse }
     * 
     */
    public GetReservasByCodigoResponse createGetReservasByCodigoResponse() {
        return new GetReservasByCodigoResponse();
    }

    /**
     * Create an instance of {@link Reserva }
     * 
     */
    public Reserva createReserva() {
        return new Reserva();
    }

    /**
     * Create an instance of {@link TipoHabitacion }
     * 
     */
    public TipoHabitacion createTipoHabitacion() {
        return new TipoHabitacion();
    }

}
