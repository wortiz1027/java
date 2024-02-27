
package co.edu.javeriana.proxies.checkin.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckInUniversalResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CheckInUniversalResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idRevision" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="labelrevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0}StatusInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckInUniversalResult", propOrder = { "did", "revision", "idRevision", "labelrevision", "status" })
public class CheckInUniversalResult {

    @XmlElementRef(name = "dID", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> did;
    @XmlElementRef(name = "revision",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> revision;
    @XmlElementRef(name = "idRevision",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> idRevision;
    @XmlElementRef(name = "labelrevision",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> labelrevision;
    @XmlElementRef(name = "status", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<StatusInfo> status;

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
     * Gets the value of the revision property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setRevision(JAXBElement<Integer> value) {
        this.revision = value;
    }

    /**
     * Gets the value of the idRevision property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public JAXBElement<Integer> getIdRevision() {
        return idRevision;
    }

    /**
     * Sets the value of the idRevision property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     */
    public void setIdRevision(JAXBElement<Integer> value) {
        this.idRevision = value;
    }

    /**
     * Gets the value of the labelrevision property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getLabelrevision() {
        return labelrevision;
    }

    /**
     * Sets the value of the labelrevision property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setLabelrevision(JAXBElement<String> value) {
        this.labelrevision = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StatusInfo }{@code >}
     *
     */
    public JAXBElement<StatusInfo> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StatusInfo }{@code >}
     *
     */
    public void setStatus(JAXBElement<StatusInfo> value) {
        this.status = value;
    }

}
