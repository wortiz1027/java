//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.12.05 a las 10:33:25 PM COT 
//


package co.edu.javeriana.external.services.aa.infraestructure.wsdl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Header" type="{http://us.aa.com/flights}Header"/&gt;
 *         &lt;element name="Information" type="{http://us.aa.com/flights}InformationFlights"/&gt;
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
@XmlRootElement(name = "GetAllFlightsResponse")
public class GetAllFlightsResponse {

    @XmlElement(name = "header", required = true)
    protected Header header;
    @XmlElement(name = "information", required = true)
    protected InformationFlights information;

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
     *     {@link InformationFlights }
     *     
     */
    public InformationFlights getInformation() {
        return information;
    }

    /**
     * Define el valor de la propiedad information.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationFlights }
     *     
     */
    public void setInformation(InformationFlights value) {
        this.information = value;
    }

}
