
package co.edu.javeriana.proxies.consultardocumento.types;

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
 *         &lt;element name="codigoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputType", propOrder = { "codigoDocumento" })
public class OutputType {

    protected String codigoDocumento;

    /**
     * Gets the value of the codigoDocumento property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    /**
     * Sets the value of the codigoDocumento property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigoDocumento(String value) {
        this.codigoDocumento = value;
    }

}
