//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.07 a las 10:16:13 PM COT 
//


package co.edu.javeriana.external.services.bl.infraestructure.wsdl.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.edu.javeriana.external.services.bl.infraestructure.wsdl.model package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.external.services.bl.infraestructure.wsdl.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetJourneyRequest }
     * 
     */
    public GetJourneyRequest createGetJourneyRequest() {
        return new GetJourneyRequest();
    }

    /**
     * Create an instance of {@link GetJourneyResponse }
     * 
     */
    public GetJourneyResponse createGetJourneyResponse() {
        return new GetJourneyResponse();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link JourneyList }
     * 
     */
    public JourneyList createJourneyList() {
        return new JourneyList();
    }

    /**
     * Create an instance of {@link Passenger }
     * 
     */
    public Passenger createPassenger() {
        return new Passenger();
    }

}
