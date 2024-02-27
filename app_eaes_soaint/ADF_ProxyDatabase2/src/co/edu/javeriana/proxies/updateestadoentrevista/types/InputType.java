
package co.edu.javeriana.proxies.updateestadoentrevista.types;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InputType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoEntrevista" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="evaluarSeleccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputType", propOrder = { "codigoEntrevista", "observaciones", "evaluarSeleccion" })
public class InputType {

    protected BigDecimal codigoEntrevista;
    protected String observaciones;
    protected String evaluarSeleccion;

    /**
     * Gets the value of the codigoEntrevista property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCodigoEntrevista() {
        return codigoEntrevista;
    }

    /**
     * Sets the value of the codigoEntrevista property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCodigoEntrevista(BigDecimal value) {
        this.codigoEntrevista = value;
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
