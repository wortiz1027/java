
package co.edu.javeriana.proxies.insertarprototipo.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the co.edu.javeriana.proxies.insertarprototipo.types package.
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
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarPrototipo/v1.0", "request");
    private final static QName _Response_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarPrototipo/v1.0", "response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.proxies.insertarprototipo.types
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertarPrototipoType }
     *
     */
    public InsertarPrototipoType createInsertarPrototipoType() {
        return new InsertarPrototipoType();
    }

    /**
     * Create an instance of {@link ResponseType }
     *
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link ListaRecomendacionesType }
     *
     */
    public ListaRecomendacionesType createListaRecomendacionesType() {
        return new ListaRecomendacionesType();
    }

    /**
     * Create an instance of {@link RecomendacionesType }
     *
     */
    public RecomendacionesType createRecomendacionesType() {
        return new RecomendacionesType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarPrototipoType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertarPrototipoType }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarPrototipo/v1.0",
                    name = "request")
    public JAXBElement<InsertarPrototipoType> createRequest(InsertarPrototipoType value) {
        return new JAXBElement<InsertarPrototipoType>(_Request_QNAME, InsertarPrototipoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarPrototipo/v1.0",
                    name = "response")
    public JAXBElement<ResponseType> createResponse(ResponseType value) {
        return new JAXBElement<ResponseType>(_Response_QNAME, ResponseType.class, null, value);
    }

}
