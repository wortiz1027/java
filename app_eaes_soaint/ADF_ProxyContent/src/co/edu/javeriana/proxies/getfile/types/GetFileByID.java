
package co.edu.javeriana.proxies.getfile.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFileByID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetFileByID"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="tipoArchivo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="extraProperty" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0}Property" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFileByID", propOrder = { "did", "tipoArchivo", "extraProperty" })
public class GetFileByID {

    @XmlElementRef(name = "dID", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> did;
    @XmlElement(required = true)
    protected String tipoArchivo;
    @XmlElement(nillable = true)
    protected List<Property> extraProperty;

    /**
     * Gets the value of the did property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getDID() {
        return did;
    }

    /**
     * Sets the value of the did property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setDID(JAXBElement<Integer> value) {
        this.did = value;
    }

    /**
     * Gets the value of the tipoArchivo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipoArchivo() {
        return tipoArchivo;
    }

    /**
     * Sets the value of the tipoArchivo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipoArchivo(String value) {
        this.tipoArchivo = value;
    }

    /**
     * Gets the value of the extraProperty property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extraProperty property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtraProperty().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     *
     *
     */
    public List<Property> getExtraProperty() {
        if (extraProperty == null) {
            extraProperty = new ArrayList<Property>();
        }
        return this.extraProperty;
    }

}
