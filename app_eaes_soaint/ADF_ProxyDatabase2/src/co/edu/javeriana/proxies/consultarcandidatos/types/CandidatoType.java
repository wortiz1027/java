
package co.edu.javeriana.proxies.consultarcandidatos.types;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CandidatoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CandidatoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoCandidato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="primer_nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="segundo_nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primer_apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="segundo_apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo_identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numero_identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fecha_nacimiento" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CandidatoType",
         propOrder =
         { "codigoCandidato", "primerNombre", "segundoNombre", "primerApellido", "segundoApellido",
           "tipoIdentificacion", "numeroIdentificacion", "email", "telefono", "fechaNacimiento"
    })
public class CandidatoType {

    protected BigDecimal codigoCandidato;
    @XmlElement(name = "primer_nombre")
    protected String primerNombre;
    @XmlElement(name = "segundo_nombre")
    protected String segundoNombre;
    @XmlElement(name = "primer_apellido")
    protected String primerApellido;
    @XmlElement(name = "segundo_apellido")
    protected String segundoApellido;
    @XmlElement(name = "tipo_identificacion")
    protected String tipoIdentificacion;
    @XmlElement(name = "numero_identificacion")
    protected String numeroIdentificacion;
    protected String email;
    protected String telefono;
    @XmlElement(name = "fecha_nacimiento")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaNacimiento;

    /**
     * Gets the value of the codigoCandidato property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCodigoCandidato() {
        return codigoCandidato;
    }

    /**
     * Sets the value of the codigoCandidato property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCodigoCandidato(BigDecimal value) {
        this.codigoCandidato = value;
    }

    /**
     * Gets the value of the primerNombre property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * Sets the value of the primerNombre property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrimerNombre(String value) {
        this.primerNombre = value;
    }

    /**
     * Gets the value of the segundoNombre property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * Sets the value of the segundoNombre property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSegundoNombre(String value) {
        this.segundoNombre = value;
    }

    /**
     * Gets the value of the primerApellido property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Sets the value of the primerApellido property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrimerApellido(String value) {
        this.primerApellido = value;
    }

    /**
     * Gets the value of the segundoApellido property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Sets the value of the segundoApellido property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSegundoApellido(String value) {
        this.segundoApellido = value;
    }

    /**
     * Gets the value of the tipoIdentificacion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * Sets the value of the tipoIdentificacion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipoIdentificacion(String value) {
        this.tipoIdentificacion = value;
    }

    /**
     * Gets the value of the numeroIdentificacion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Sets the value of the numeroIdentificacion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumeroIdentificacion(String value) {
        this.numeroIdentificacion = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the telefono property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets the value of the telefono property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Gets the value of the fechaNacimiento property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Sets the value of the fechaNacimiento property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaNacimiento(XMLGregorianCalendar value) {
        this.fechaNacimiento = value;
    }

}
