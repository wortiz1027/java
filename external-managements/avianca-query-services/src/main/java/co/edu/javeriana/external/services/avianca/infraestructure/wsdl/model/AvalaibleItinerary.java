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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AvalaibleItinerary complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AvalaibleItinerary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DepartureFlights" type="{http://schemas.datacontract.org/2004/07/AviancaDemoWcfService}ArrayOfAvalaibleFlight" minOccurs="0"/&gt;
 *         &lt;element name="ReturnFlights" type="{http://schemas.datacontract.org/2004/07/AviancaDemoWcfService}ArrayOfAvalaibleFlight" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvalaibleItinerary", propOrder = {
    "departureFlights",
    "returnFlights"
})
public class AvalaibleItinerary {

    @XmlElementRef(name = "DepartureFlights", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAvalaibleFlight> departureFlights;
    @XmlElementRef(name = "ReturnFlights", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAvalaibleFlight> returnFlights;

    /**
     * Obtiene el valor de la propiedad departureFlights.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAvalaibleFlight> getDepartureFlights() {
        return departureFlights;
    }

    /**
     * Define el valor de la propiedad departureFlights.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     *     
     */
    public void setDepartureFlights(JAXBElement<ArrayOfAvalaibleFlight> value) {
        this.departureFlights = value;
    }

    /**
     * Obtiene el valor de la propiedad returnFlights.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAvalaibleFlight> getReturnFlights() {
        return returnFlights;
    }

    /**
     * Define el valor de la propiedad returnFlights.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     *     
     */
    public void setReturnFlights(JAXBElement<ArrayOfAvalaibleFlight> value) {
        this.returnFlights = value;
    }

}
