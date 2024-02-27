
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
 * <p>Java class for GetFileByIDResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetFileByIDResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InformacionArhivo" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0}FileInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ArchivoDescargado" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0}PrimaryFile" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0}StatusInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFileByIDResult", propOrder = { "informacionArhivo", "archivoDescargado", "status" })
public class GetFileByIDResult {

    @XmlElement(name = "InformacionArhivo", nillable = true)
    protected List<FileInfo> informacionArhivo;
    @XmlElementRef(name = "ArchivoDescargado",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<PrimaryFile> archivoDescargado;
    @XmlElementRef(name = "status", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<StatusInfo> status;

    /**
     * Gets the value of the informacionArhivo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informacionArhivo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformacionArhivo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileInfo }
     *
     *
     */
    public List<FileInfo> getInformacionArhivo() {
        if (informacionArhivo == null) {
            informacionArhivo = new ArrayList<FileInfo>();
        }
        return this.informacionArhivo;
    }

    /**
     * Gets the value of the archivoDescargado property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PrimaryFile }{@code >}
     *
     */
    public JAXBElement<PrimaryFile> getArchivoDescargado() {
        return archivoDescargado;
    }

    /**
     * Sets the value of the archivoDescargado property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PrimaryFile }{@code >}
     *
     */
    public void setArchivoDescargado(JAXBElement<PrimaryFile> value) {
        this.archivoDescargado = value;
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
