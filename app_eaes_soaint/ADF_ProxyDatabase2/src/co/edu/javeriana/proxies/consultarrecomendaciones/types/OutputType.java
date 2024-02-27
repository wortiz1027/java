
package co.edu.javeriana.proxies.consultarrecomendaciones.types;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="prototipo" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarPrototipoRecomendaciones/v1.0}PrototipoType" minOccurs="0"/&gt;
 *         &lt;element name="recomendaciones" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarPrototipoRecomendaciones/v1.0}RecomendacionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputType", propOrder = { "prototipo", "recomendaciones" })
public class OutputType {

    protected PrototipoType prototipo;
    protected List<RecomendacionType> recomendaciones;

    /**
     * Gets the value of the prototipo property.
     *
     * @return
     *     possible object is
     *     {@link PrototipoType }
     *
     */
    public PrototipoType getPrototipo() {
        return prototipo;
    }

    /**
     * Sets the value of the prototipo property.
     *
     * @param value
     *     allowed object is
     *     {@link PrototipoType }
     *
     */
    public void setPrototipo(PrototipoType value) {
        this.prototipo = value;
    }

    /**
     * Gets the value of the recomendaciones property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recomendaciones property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecomendaciones().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecomendacionType }
     *
     *
     */
    public List<RecomendacionType> getRecomendaciones() {
        if (recomendaciones == null) {
            recomendaciones = new ArrayList<RecomendacionType>();
        }
        return this.recomendaciones;
    }

}
