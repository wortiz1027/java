
package co.edu.javeriana.proxies.insertarprototipo.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaRecomendacionesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ListaRecomendacionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="listaRecomendaciones" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarPrototipo/v1.0}RecomendacionesType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaRecomendacionesType", propOrder = { "listaRecomendaciones" })
public class ListaRecomendacionesType {

    protected List<RecomendacionesType> listaRecomendaciones;

    /**
     * Gets the value of the listaRecomendaciones property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaRecomendaciones property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaRecomendaciones().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecomendacionesType }
     *
     *
     */
    public List<RecomendacionesType> getListaRecomendaciones() {
        if (listaRecomendaciones == null) {
            listaRecomendaciones = new ArrayList<RecomendacionesType>();
        }
        return this.listaRecomendaciones;
    }

}
