
package co.edu.javeriana.proxies.consultarcandidatos.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CandidatosType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CandidatosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CandidatosType" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/ConsultarCandidatos/v1.0}CandidatoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CandidatosType", propOrder = { "candidatosType" })
public class CandidatosType {

    @XmlElement(name = "CandidatosType", nillable = true)
    protected List<CandidatoType> candidatosType;

    /**
     * Gets the value of the candidatosType property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the candidatosType property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCandidatosType().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CandidatoType }
     *
     *
     */
    public List<CandidatoType> getCandidatosType() {
        if (candidatosType == null) {
            candidatosType = new ArrayList<CandidatoType>();
        }
        return this.candidatosType;
    }

}
