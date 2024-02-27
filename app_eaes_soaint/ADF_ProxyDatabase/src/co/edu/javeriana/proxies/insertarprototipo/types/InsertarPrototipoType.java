
package co.edu.javeriana.proxies.insertarprototipo.types;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InsertarPrototipoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InsertarPrototipoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="fechaFin" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="detalle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="presupuesto" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="conocimientos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="recomendaciones" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarPrototipo/v1.0}ListaRecomendacionesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarPrototipoType",
         propOrder =
         { "titulo", "fechaInicio", "fechaFin", "detalle", "estado", "presupuesto", "tipo", "conocimientos",
           "recomendaciones"
    })
public class InsertarPrototipoType {

    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicio;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFin;
    @XmlElement(required = true)
    protected String detalle;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected BigDecimal presupuesto;
    @XmlElement(required = true)
    protected String tipo;
    protected String conocimientos;
    protected ListaRecomendacionesType recomendaciones;

    /**
     * Gets the value of the titulo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets the value of the titulo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Gets the value of the fechaInicio property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Sets the value of the fechaInicio property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaInicio(XMLGregorianCalendar value) {
        this.fechaInicio = value;
    }

    /**
     * Gets the value of the fechaFin property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaFin() {
        return fechaFin;
    }

    /**
     * Sets the value of the fechaFin property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaFin(XMLGregorianCalendar value) {
        this.fechaFin = value;
    }

    /**
     * Gets the value of the detalle property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Sets the value of the detalle property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDetalle(String value) {
        this.detalle = value;
    }

    /**
     * Gets the value of the estado property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the presupuesto property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    /**
     * Sets the value of the presupuesto property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setPresupuesto(BigDecimal value) {
        this.presupuesto = value;
    }

    /**
     * Gets the value of the tipo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the conocimientos property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConocimientos() {
        return conocimientos;
    }

    /**
     * Sets the value of the conocimientos property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConocimientos(String value) {
        this.conocimientos = value;
    }

    /**
     * Gets the value of the recomendaciones property.
     *
     * @return
     *     possible object is
     *     {@link ListaRecomendacionesType }
     *
     */
    public ListaRecomendacionesType getRecomendaciones() {
        return recomendaciones;
    }

    /**
     * Sets the value of the recomendaciones property.
     *
     * @param value
     *     allowed object is
     *     {@link ListaRecomendacionesType }
     *
     */
    public void setRecomendaciones(ListaRecomendacionesType value) {
        this.recomendaciones = value;
    }

}
