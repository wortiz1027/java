
package co.edu.javeriana.proxies.updateestadoentrevista.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutputType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OutputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ejecucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputType", propOrder = { "ejecucion" })
public class OutputType {

    protected String ejecucion;

    /**
     * Gets the value of the ejecucion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEjecucion() {
        return ejecucion;
    }

    /**
     * Sets the value of the ejecucion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEjecucion(String value) {
        this.ejecucion = value;
    }

}
