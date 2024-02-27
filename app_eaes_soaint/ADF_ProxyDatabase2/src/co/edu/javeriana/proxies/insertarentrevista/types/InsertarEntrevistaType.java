
package co.edu.javeriana.proxies.insertarentrevista.types;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InsertarEntrevistaType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InsertarEntrevistaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoCurriculum" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codigoColaborador" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codigoVacante" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="fechaRealizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaEmisionResultado" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="evaluarSeleccion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarEntrevistaType",
         propOrder =
         { "codigoCurriculum", "codigoColaborador", "codigoVacante", "fechaRealizacion", "resultado",
           "fechaEmisionResultado", "observaciones", "evaluarSeleccion"
    })
public class InsertarEntrevistaType {

    protected BigDecimal codigoCurriculum;
    protected BigDecimal codigoColaborador;
    protected BigDecimal codigoVacante;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRealizacion;
    protected String resultado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmisionResultado;
    @XmlElement(required = true)
    protected String observaciones;
    @XmlElement(required = true)
    protected String evaluarSeleccion;

    /**
     * Gets the value of the codigoCurriculum property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCodigoCurriculum() {
        return codigoCurriculum;
    }

    /**
     * Sets the value of the codigoCurriculum property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCodigoCurriculum(BigDecimal value) {
        this.codigoCurriculum = value;
    }

    /**
     * Gets the value of the codigoColaborador property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCodigoColaborador() {
        return codigoColaborador;
    }

    /**
     * Sets the value of the codigoColaborador property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCodigoColaborador(BigDecimal value) {
        this.codigoColaborador = value;
    }

    /**
     * Gets the value of the codigoVacante property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCodigoVacante() {
        return codigoVacante;
    }

    /**
     * Sets the value of the codigoVacante property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCodigoVacante(BigDecimal value) {
        this.codigoVacante = value;
    }

    /**
     * Gets the value of the fechaRealizacion property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaRealizacion() {
        return fechaRealizacion;
    }

    /**
     * Sets the value of the fechaRealizacion property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaRealizacion(XMLGregorianCalendar value) {
        this.fechaRealizacion = value;
    }

    /**
     * Gets the value of the resultado property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Sets the value of the resultado property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Gets the value of the fechaEmisionResultado property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaEmisionResultado() {
        return fechaEmisionResultado;
    }

    /**
     * Sets the value of the fechaEmisionResultado property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaEmisionResultado(XMLGregorianCalendar value) {
        this.fechaEmisionResultado = value;
    }

    /**
     * Gets the value of the observaciones property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Sets the value of the observaciones property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

    /**
     * Gets the value of the evaluarSeleccion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEvaluarSeleccion() {
        return evaluarSeleccion;
    }

    /**
     * Sets the value of the evaluarSeleccion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEvaluarSeleccion(String value) {
        this.evaluarSeleccion = value;
    }

}
