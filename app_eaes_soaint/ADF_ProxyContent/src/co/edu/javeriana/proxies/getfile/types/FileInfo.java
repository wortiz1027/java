
package co.edu.javeriana.proxies.getfile.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileInfo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FileInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="dDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="grupoSeguridad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileInfo", propOrder = { "did", "dDocName", "titulo", "tipo", "autor", "grupoSeguridad" })
public class FileInfo {

    @XmlElementRef(name = "dID", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> did;
    @XmlElementRef(name = "dDocName",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> dDocName;
    @XmlElementRef(name = "titulo", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> titulo;
    @XmlElementRef(name = "tipo", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipo;
    @XmlElementRef(name = "autor", namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> autor;
    @XmlElementRef(name = "grupoSeguridad",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> grupoSeguridad;

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

}
