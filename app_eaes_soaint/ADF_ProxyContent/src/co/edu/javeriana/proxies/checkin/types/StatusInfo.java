
package co.edu.javeriana.proxies.checkin.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusInfo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StatusInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusInfo", propOrder = { "codigo", "mensaje" })
public class StatusInfo {

    @XmlElementRef(name = "codigo", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> codigo;
    @XmlElementRef(name = "mensaje",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> mensaje;

    /**
     * Gets the value of the codigo property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setCodigo(JAXBElement<Integer> value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the mensaje property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getMensaje() {
        return mensaje;
    }

    /**
     * Sets the value of the mensaje property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setMensaje(JAXBElement<String> value) {
        this.mensaje = value;
    }

}
