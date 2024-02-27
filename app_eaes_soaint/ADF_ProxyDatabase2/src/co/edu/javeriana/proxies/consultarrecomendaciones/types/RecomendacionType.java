
package co.edu.javeriana.proxies.consultarrecomendaciones.types;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecomendacionType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RecomendacionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoPrototipo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="observacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecomendacionType", propOrder = { "codigoPrototipo", "observacion" })
public class RecomendacionType {

    protected BigDecimal codigoPrototipo;
    protected String observacion;

    /**
     * Gets the value of the codigoPrototipo property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCodigoPrototipo() {
        return codigoPrototipo;
    }

    /**
     * Sets the value of the codigoPrototipo property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCodigoPrototipo(BigDecimal value) {
        this.codigoPrototipo = value;
    }

    /**
     * Gets the value of the observacion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Sets the value of the observacion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setObservacion(String value) {
        this.observacion = value;
    }

}
