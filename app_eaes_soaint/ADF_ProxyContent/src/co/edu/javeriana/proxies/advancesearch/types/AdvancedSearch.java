
package co.edu.javeriana.proxies.advancesearch.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdvancedSearch complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AdvancedSearch"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="queryText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="property" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0}Property" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdvancedSearch", propOrder = { "queryText", "property" })
public class AdvancedSearch {

    @XmlElement(required = true)
    protected String queryText;
    protected List<Property> property;

    /**
     * Gets the value of the queryText property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQueryText() {
        return queryText;
    }

    /**
     * Sets the value of the queryText property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQueryText(String value) {
        this.queryText = value;
    }

    /**
     * Gets the value of the property property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     *
     *
     */
    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
    }

}
