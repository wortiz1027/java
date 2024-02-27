
package co.edu.javeriana.proxies.insertarcolaborador.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the co.edu.javeriana.proxies.insertarcolaborador.types package.
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
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarColaborador/v1.0", "request");
    private final static QName _Response_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarColaborador/v1.0", "response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.proxies.insertarcolaborador.types
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertarColaboradorType }
     *
     */
    public InsertarColaboradorType createInsertarColaboradorType() {
        return new InsertarColaboradorType();
    }

    /**
     * Create an instance of {@link ResponseType }
     *
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarColaboradorType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertarColaboradorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarColaborador/v1.0",
                    name = "request")
    public JAXBElement<InsertarColaboradorType> createRequest(InsertarColaboradorType value) {
        return new JAXBElement<InsertarColaboradorType>(_Request_QNAME, InsertarColaboradorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarColaborador/v1.0",
                    name = "response")
    public JAXBElement<ResponseType> createResponse(ResponseType value) {
        return new JAXBElement<ResponseType>(_Response_QNAME, ResponseType.class, null, value);
    }

}
