
package co.edu.javeriana.proxies.insertarcolaborador.types;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InsertarColaboradorType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InsertarColaboradorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoRol" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="primerNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="segundoNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primerApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="segundoApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="correoElectronica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="disponible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarColaboradorType",
         propOrder =
         { "codigoRol", "primerNombre", "segundoNombre", "primerApellido", "segundoApellido", "correoElectronica",
           "telefono", "disponible"
    })
public class InsertarColaboradorType {

    protected BigDecimal codigoRol;
    protected String primerNombre;
    protected String segundoNombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String correoElectronica;
    protected String telefono;
    protected String disponible;

    /**
     * Gets the value of the codigoRol property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCodigoRol() {
        return codigoRol;
    }

    /**
     * Sets the value of the codigoRol property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCodigoRol(BigDecimal value) {
        this.codigoRol = value;
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
     * Gets the value of the correoElectronica property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCorreoElectronica() {
        return correoElectronica;
    }

    /**
     * Sets the value of the correoElectronica property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCorreoElectronica(String value) {
        this.correoElectronica = value;
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
     * Gets the value of the disponible property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDisponible() {
        return disponible;
    }

    /**
     * Sets the value of the disponible property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDisponible(String value) {
        this.disponible = value;
    }

}
