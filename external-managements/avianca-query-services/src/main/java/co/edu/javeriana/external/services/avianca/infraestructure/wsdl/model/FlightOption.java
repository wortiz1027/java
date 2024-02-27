//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.18 a las 05:08:08 PM COT 
//


package co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para FlightOption complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FlightOption"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DepartureDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="DestinationCityDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OneWay" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="OriginCityDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PassengersNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ReturnDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightOption", propOrder = {
    "departureDate",
    "destinationCityDescription",
    "oneWay",
    "originCityDescription",
    "passengersNumber",
    "returnDate"
})
@XmlRootElement(name = "FlightOption", namespace = "http://tempuri.org/")
public class FlightOption {

    @XmlElement(name = "DepartureDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar departureDate;
    @XmlElementRef(name = "DestinationCityDescription", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> destinationCityDescription;
    @XmlElement(name = "OneWay")
    protected Boolean oneWay;
    @XmlElementRef(name = "OriginCityDescription", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originCityDescription;
    @XmlElement(name = "PassengersNumber")
    protected Integer passengersNumber;
    @XmlElement(name = "ReturnDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar returnDate;

    /**
     * Obtiene el valor de la propiedad departureDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepartureDate() {
        return departureDate;
    }

    /**
     * Define el valor de la propiedad departureDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepartureDate(XMLGregorianCalendar value) {
        this.departureDate = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationCityDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDestinationCityDescription() {
        return destinationCityDescription;
    }

    /**
     * Define el valor de la propiedad destinationCityDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDestinationCityDescription(JAXBElement<String> value) {
        this.destinationCityDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad oneWay.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOneWay() {
        return oneWay;
    }

    /**
     * Define el valor de la propiedad oneWay.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOneWay(Boolean value) {
        this.oneWay = value;
    }

    /**
     * Obtiene el valor de la propiedad originCityDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginCityDescription() {
        return originCityDescription;
    }

    /**
     * Define el valor de la propiedad originCityDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginCityDescription(JAXBElement<String> value) {
        this.originCityDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad passengersNumber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPassengersNumber() {
        return passengersNumber;
    }

    /**
     * Define el valor de la propiedad passengersNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPassengersNumber(Integer value) {
        this.passengersNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad returnDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReturnDate() {
        return returnDate;
    }

    /**
     * Define el valor de la propiedad returnDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReturnDate(XMLGregorianCalendar value) {
        this.returnDate = value;
    }

}
