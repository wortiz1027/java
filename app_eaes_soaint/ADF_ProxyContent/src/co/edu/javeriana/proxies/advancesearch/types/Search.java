
package co.edu.javeriana.proxies.advancesearch.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Search complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Search"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="grupoSeguridad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extensionWeb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="formato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombreOriginal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Search", propOrder = { "content" })
public class Search {

    @XmlElementRefs({ @XmlElementRef(name = "dID",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "revision",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "dDocName",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "titulo",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "tipo",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "autor",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "grupoSeguridad",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "cuenta",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "extension",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "extensionWeb",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "fechaCreacion",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "formato",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "nombreOriginal",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false),
                      @XmlElementRef(name = "url",
                                     namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                                     type = JAXBElement.class, required = false)
        })
    protected List<JAXBElement<String>> content;

    /**
     * Gets the rest of the content model.
     *
     * <p>
     * You are getting this "catch-all" property because of the following reason:
     * The field name "Revision" is used by two different parts of a schema. See:
     * line 32 of wsdlfile:/C:/Proyectos/app_eaes_soaint/ADF_ProxyContent/src/co/edu/javeriana/proxies/advancesearch/proxy/WCC_Search.xsd
     * line 23 of wsdlfile:/C:/Proyectos/app_eaes_soaint/ADF_ProxyContent/src/co/edu/javeriana/proxies/advancesearch/proxy/WCC_Search.xsd
     * <p>
     * To get rid of this property, apply a property customization to one
     * of both of the following declarations to change their names:
     * Gets the value of the content property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     *
     */
    public List<JAXBElement<String>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<String>>();
        }
        return this.content;
    }

}
