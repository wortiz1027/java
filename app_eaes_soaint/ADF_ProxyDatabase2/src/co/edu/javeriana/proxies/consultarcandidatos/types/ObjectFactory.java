
package co.edu.javeriana.proxies.consultarcandidatos.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the co.edu.javeriana.proxies.consultarcandidatos.types package.
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

    private final static QName _Generico_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarCandidatos/v1.0", "Generico");
    private final static QName _Candidatos_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarCandidatos/v1.0", "Candidatos");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.proxies.consultarcandidatos.types
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenericoType }
     *
     */
    public GenericoType createGenericoType() {
        return new GenericoType();
    }

    /**
     * Create an instance of {@link CandidatosType }
     *
     */
    public CandidatosType createCandidatosType() {
        return new CandidatosType();
    }

    /**
     * Create an instance of {@link CandidatoType }
     *
     */
    public CandidatoType createCandidatoType() {
        return new CandidatoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericoType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenericoType }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarCandidatos/v1.0",
                    name = "Generico")
    public JAXBElement<GenericoType> createGenerico(GenericoType value) {
        return new JAXBElement<GenericoType>(_Generico_QNAME, GenericoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CandidatosType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CandidatosType }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarCandidatos/v1.0",
                    name = "Candidatos")
    public JAXBElement<CandidatosType> createCandidatos(CandidatosType value) {
        return new JAXBElement<CandidatosType>(_Candidatos_QNAME, CandidatosType.class, null, value);
    }

}
