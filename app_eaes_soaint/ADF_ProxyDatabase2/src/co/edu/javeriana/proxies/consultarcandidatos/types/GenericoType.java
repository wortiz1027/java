
package co.edu.javeriana.proxies.consultarcandidatos.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenericoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GenericoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericoType", propOrder = { "numero" })
public class GenericoType {

    protected String numero;

    /**
     * Gets the value of the numero property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumero(String value) {
        this.numero = value;
    }

}
