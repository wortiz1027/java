
package co.edu.javeriana.proxies.checkin.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckInUniversal complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CheckInUniversal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="grupoSeguridad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="archivoPrimario" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0}PrimaryFile" minOccurs="0"/&gt;
 *         &lt;element name="customDocMetaData" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0}Property" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckInUniversal",
         propOrder =
         { "dDocName", "titulo", "tipo", "autor", "grupoSeguridad", "cuenta", "archivoPrimario", "customDocMetaData"
    })
public class CheckInUniversal {

    @XmlElementRef(name = "dDocName",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> dDocName;
    @XmlElementRef(name = "titulo", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> titulo;
    @XmlElementRef(name = "tipo", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipo;
    @XmlElementRef(name = "autor", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> autor;
    @XmlElementRef(name = "grupoSeguridad",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> grupoSeguridad;
    @XmlElementRef(name = "cuenta", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> cuenta;
    @XmlElementRef(name = "archivoPrimario",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<PrimaryFile> archivoPrimario;
    @XmlElement(nillable = true)
    protected List<Property> customDocMetaData;

    /**
     * Gets the value of the dDocName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getDDocName() {
        return dDocName;
    }

    /**
     * Sets the value of the dDocName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setDDocName(JAXBElement<String> value) {
        this.dDocName = value;
    }

    /**
     * Gets the value of the titulo property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getTitulo() {
        return titulo;
    }

    /**
     * Sets the value of the titulo property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setTitulo(JAXBElement<String> value) {
        this.titulo = value;
    }

    /**
     * Gets the value of the tipo property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setTipo(JAXBElement<String> value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the autor property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAutor() {
        return autor;
    }

    /**
     * Sets the value of the autor property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAutor(JAXBElement<String> value) {
        this.autor = value;
    }

    /**
     * Gets the value of the grupoSeguridad property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getGrupoSeguridad() {
        return grupoSeguridad;
    }

    /**
     * Sets the value of the grupoSeguridad property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setGrupoSeguridad(JAXBElement<String> value) {
        this.grupoSeguridad = value;
    }

    /**
     * Gets the value of the cuenta property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getCuenta() {
        return cuenta;
    }

    /**
     * Sets the value of the cuenta property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setCuenta(JAXBElement<String> value) {
        this.cuenta = value;
    }

    /**
     * Gets the value of the archivoPrimario property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PrimaryFile }{@code >}
     *
     */
    public JAXBElement<PrimaryFile> getArchivoPrimario() {
        return archivoPrimario;
    }

    /**
     * Sets the value of the archivoPrimario property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PrimaryFile }{@code >}
     *
     */
    public void setArchivoPrimario(JAXBElement<PrimaryFile> value) {
        this.archivoPrimario = value;
    }

    /**
     * Gets the value of the customDocMetaData property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customDocMetaData property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomDocMetaData().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     *
     *
     */
    public List<Property> getCustomDocMetaData() {
        if (customDocMetaData == null) {
            customDocMetaData = new ArrayList<Property>();
        }
        return this.customDocMetaData;
    }

}
