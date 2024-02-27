//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.18 a las 03:29:16 PM COT 
//


package co.edu.javeriana.bpm.infraestructure.wsdl.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.edu.javeriana.bpm.infraestructure.wsdl.model package. 
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

    private final static QName _IniciarPaqueteTuristicoResponse_QNAME = new QName("http://TOB/wsIniciarPaqueteTuristico.tws", "iniciarPaqueteTuristicoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.bpm.infraestructure.wsdl.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IniciarPaqueteTuristico }
     * 
     */
    public IniciarPaqueteTuristico createIniciarPaqueteTuristico() {
        return new IniciarPaqueteTuristico();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://TOB/wsIniciarPaqueteTuristico.tws", name = "iniciarPaqueteTuristicoResponse")
    public JAXBElement<Object> createIniciarPaqueteTuristicoResponse(Object value) {
        return new JAXBElement<Object>(_IniciarPaqueteTuristicoResponse_QNAME, Object.class, null, value);
    }

}
