
package co.edu.javeriana.proxies.advancesearch.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaPropiedades complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ListaPropiedades"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="propiedades" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0}Property" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaPropiedades", propOrder = { "propiedades" })
public class ListaPropiedades {

    protected List<Property> propiedades;

    /**
     * Gets the value of the propiedades property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propiedades property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropiedades().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     *
     *
     */
    public List<Property> getPropiedades() {
        if (propiedades == null) {
            propiedades = new ArrayList<Property>();
        }
        return this.propiedades;
    }

}
