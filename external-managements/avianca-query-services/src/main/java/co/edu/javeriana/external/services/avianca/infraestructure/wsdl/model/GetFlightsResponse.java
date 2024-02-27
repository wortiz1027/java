//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.18 a las 05:08:08 PM COT 
//


package co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="GetFlightsResult" type="{http://schemas.datacontract.org/2004/07/AviancaDemoWcfService}AvalaibleItinerary" minOccurs="0"/&gt;
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
    "getFlightsResult"
})
@XmlRootElement(name = "GetFlightsResponse", namespace = "http://tempuri.org/")
public class GetFlightsResponse {

    @XmlElementRef(name = "GetFlightsResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<AvalaibleItinerary> getFlightsResult;

    /**
     * Obtiene el valor de la propiedad getFlightsResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AvalaibleItinerary }{@code >}
     *     
     */
    public JAXBElement<AvalaibleItinerary> getGetFlightsResult() {
        return getFlightsResult;
    }

    /**
     * Define el valor de la propiedad getFlightsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AvalaibleItinerary }{@code >}
     *     
     */
    public void setGetFlightsResult(JAXBElement<AvalaibleItinerary> value) {
        this.getFlightsResult = value;
    }

}
