
package co.edu.javeriana.proxies.consultarrecomendaciones.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the co.edu.javeriana.proxies.consultarrecomendaciones.types package.
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

    private final static QName _Request_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarPrototipoRecomendaciones/v1.0",
                  "request");
    private final static QName _Response_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarPrototipoRecomendaciones/v1.0",
                  "response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.proxies.consultarrecomendaciones.types
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InputType }
     *
     */
    public InputType createInputType() {
        return new InputType();
    }

    /**
     * Create an instance of {@link OutputType }
     *
     */
    public OutputType createOutputType() {
        return new OutputType();
    }

    /**
     * Create an instance of {@link PrototipoType }
     *
     */
    public PrototipoType createPrototipoType() {
        return new PrototipoType();
    }

    /**
     * Create an instance of {@link RecomendacionType }
     *
     */
    public RecomendacionType createRecomendacionType() {
        return new RecomendacionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InputType }{@code >}
     */
    @XmlElementDecl(namespace =
                    "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarPrototipoRecomendaciones/v1.0",
                    name = "request")
    public JAXBElement<InputType> createRequest(InputType value) {
        return new JAXBElement<InputType>(_Request_QNAME, InputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OutputType }{@code >}
     */
    @XmlElementDecl(namespace =
                    "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarPrototipoRecomendaciones/v1.0",
                    name = "response")
    public JAXBElement<OutputType> createResponse(OutputType value) {
        return new JAXBElement<OutputType>(_Response_QNAME, OutputType.class, null, value);
    }

}
