
package co.edu.javeriana.proxies.checkin.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrimaryFile complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PrimaryFile"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreArchivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contenidoArchivo" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrimaryFile", propOrder = { "nombreArchivo", "contenidoArchivo" })
public class PrimaryFile {

    @XmlElementRef(name = "nombreArchivo",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> nombreArchivo;
    @XmlElementRef(name = "contenidoArchivo",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> contenidoArchivo;

    /**
     * Gets the value of the nombreArchivo property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Sets the value of the nombreArchivo property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setNombreArchivo(JAXBElement<String> value) {
        this.nombreArchivo = value;
    }

    /**
     * Gets the value of the contenidoArchivo property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *
     */
    public JAXBElement<byte[]> getContenidoArchivo() {
        return contenidoArchivo;
    }

    /**
     * Sets the value of the contenidoArchivo property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *
     */
    public void setContenidoArchivo(JAXBElement<byte[]> value) {
        this.contenidoArchivo = value;
    }

}
