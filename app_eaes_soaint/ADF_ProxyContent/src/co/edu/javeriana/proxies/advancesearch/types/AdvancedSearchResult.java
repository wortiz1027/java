
package co.edu.javeriana.proxies.advancesearch.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdvancedSearchResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AdvancedSearchResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="informacion" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0}Search" minOccurs="0"/&gt;
 *         &lt;element name="customDocMetaData" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0}ListaPropiedades" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdvancedSearchResult", propOrder = { "informacion", "customDocMetaData" })
public class AdvancedSearchResult {

    protected Search informacion;
    protected ListaPropiedades customDocMetaData;

    /**
     * Gets the value of the informacion property.
     *
     * @return
     *     possible object is
     *     {@link Search }
     *
     */
    public Search getInformacion() {
        return informacion;
    }

    /**
     * Sets the value of the informacion property.
     *
     * @param value
     *     allowed object is
     *     {@link Search }
     *
     */
    public void setInformacion(Search value) {
        this.informacion = value;
    }

    /**
     * Gets the value of the customDocMetaData property.
     *
     * @return
     *     possible object is
     *     {@link ListaPropiedades }
     *
     */
    public ListaPropiedades getCustomDocMetaData() {
        return customDocMetaData;
    }

    /**
     * Sets the value of the customDocMetaData property.
     *
     * @param value
     *     allowed object is
     *     {@link ListaPropiedades }
     *
     */
    public void setCustomDocMetaData(ListaPropiedades value) {
        this.customDocMetaData = value;
    }

}
