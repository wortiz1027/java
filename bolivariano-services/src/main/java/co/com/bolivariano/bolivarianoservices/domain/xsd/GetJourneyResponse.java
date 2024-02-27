//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.07 a las 09:20:55 PM COT 
//


package co.com.bolivariano.bolivarianoservices.domain.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://co.bolivariano.com/journeys}Header"/&gt;
 *         &lt;element name="information" type="{http://co.bolivariano.com/journeys}JourneyList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "information"
})
@XmlRootElement(name = "GetJourneyResponse")
public class GetJourneyResponse {

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected JourneyList information;

    /**
     * Obtiene el valor de la propiedad header.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Define el valor de la propiedad header.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Obtiene el valor de la propiedad information.
     * 
     * @return
     *     possible object is
     *     {@link JourneyList }
     *     
     */
    public JourneyList getInformation() {
        return information;
    }

    /**
     * Define el valor de la propiedad information.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyList }
     *     
     */
    public void setInformation(JourneyList value) {
        this.information = value;
    }

}
