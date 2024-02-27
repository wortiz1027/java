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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para AvalaibleFlight complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AvalaibleFlight"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AirLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="CityFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CityTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DestinationAirportCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="DestinationAirportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DurationString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FlightEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="FlightNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FlightScale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FlightScaleNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="FlightStart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OriginAirportCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OriginAirportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PassengersNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="TotalDurationInMinutes" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvalaibleFlight", propOrder = {
    "airLine",
    "amount",
    "cityFrom",
    "cityTo",
    "destinationAirportCode",
    "destinationAirportName",
    "durationString",
    "flightEnd",
    "flightNumber",
    "flightScale",
    "flightScaleNumber",
    "flightStart",
    "id",
    "originAirportCode",
    "originAirportName",
    "passengersNumber",
    "totalDurationInMinutes"
})
public class AvalaibleFlight {

    @XmlElementRef(name = "AirLine", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> airLine;
    @XmlElement(name = "Amount")
    protected Double amount;
    @XmlElementRef(name = "CityFrom", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cityFrom;
    @XmlElementRef(name = "CityTo", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cityTo;
    @XmlElement(name = "DestinationAirportCode")
    protected Integer destinationAirportCode;
    @XmlElementRef(name = "DestinationAirportName", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> destinationAirportName;
    @XmlElementRef(name = "DurationString", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> durationString;
    @XmlElement(name = "FlightEnd")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar flightEnd;
    @XmlElementRef(name = "FlightNumber", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flightNumber;
    @XmlElementRef(name = "FlightScale", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flightScale;
    @XmlElement(name = "FlightScaleNumber")
    protected Integer flightScaleNumber;
    @XmlElement(name = "FlightStart")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar flightStart;
    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElement(name = "OriginAirportCode")
    protected Integer originAirportCode;
    @XmlElementRef(name = "OriginAirportName", namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originAirportName;
    @XmlElement(name = "PassengersNumber")
    protected Integer passengersNumber;
    @XmlElement(name = "TotalDurationInMinutes")
    protected Double totalDurationInMinutes;

    /**
     * Obtiene el valor de la propiedad airLine.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAirLine() {
        return airLine;
    }

    /**
     * Define el valor de la propiedad airLine.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAirLine(JAXBElement<String> value) {
        this.airLine = value;
    }

    /**
     * Obtiene el valor de la propiedad amount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmount(Double value) {
        this.amount = value;
    }

    /**
     * Obtiene el valor de la propiedad cityFrom.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCityFrom() {
        return cityFrom;
    }

    /**
     * Define el valor de la propiedad cityFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCityFrom(JAXBElement<String> value) {
        this.cityFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad cityTo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCityTo() {
        return cityTo;
    }

    /**
     * Define el valor de la propiedad cityTo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCityTo(JAXBElement<String> value) {
        this.cityTo = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationAirportCode.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestinationAirportCode() {
        return destinationAirportCode;
    }

    /**
     * Define el valor de la propiedad destinationAirportCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestinationAirportCode(Integer value) {
        this.destinationAirportCode = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationAirportName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDestinationAirportName() {
        return destinationAirportName;
    }

    /**
     * Define el valor de la propiedad destinationAirportName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDestinationAirportName(JAXBElement<String> value) {
        this.destinationAirportName = value;
    }

    /**
     * Obtiene el valor de la propiedad durationString.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDurationString() {
        return durationString;
    }

    /**
     * Define el valor de la propiedad durationString.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDurationString(JAXBElement<String> value) {
        this.durationString = value;
    }

    /**
     * Obtiene el valor de la propiedad flightEnd.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFlightEnd() {
        return flightEnd;
    }

    /**
     * Define el valor de la propiedad flightEnd.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFlightEnd(XMLGregorianCalendar value) {
        this.flightEnd = value;
    }

    /**
     * Obtiene el valor de la propiedad flightNumber.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlightNumber() {
        return flightNumber;
    }

    /**
     * Define el valor de la propiedad flightNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlightNumber(JAXBElement<String> value) {
        this.flightNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad flightScale.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlightScale() {
        return flightScale;
    }

    /**
     * Define el valor de la propiedad flightScale.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlightScale(JAXBElement<String> value) {
        this.flightScale = value;
    }

    /**
     * Obtiene el valor de la propiedad flightScaleNumber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFlightScaleNumber() {
        return flightScaleNumber;
    }

    /**
     * Define el valor de la propiedad flightScaleNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFlightScaleNumber(Integer value) {
        this.flightScaleNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad flightStart.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFlightStart() {
        return flightStart;
    }

    /**
     * Define el valor de la propiedad flightStart.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFlightStart(XMLGregorianCalendar value) {
        this.flightStart = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad originAirportCode.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOriginAirportCode() {
        return originAirportCode;
    }

    /**
     * Define el valor de la propiedad originAirportCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOriginAirportCode(Integer value) {
        this.originAirportCode = value;
    }

    /**
     * Obtiene el valor de la propiedad originAirportName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginAirportName() {
        return originAirportName;
    }

    /**
     * Define el valor de la propiedad originAirportName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginAirportName(JAXBElement<String> value) {
        this.originAirportName = value;
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
     * Obtiene el valor de la propiedad totalDurationInMinutes.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalDurationInMinutes() {
        return totalDurationInMinutes;
    }

    /**
     * Define el valor de la propiedad totalDurationInMinutes.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalDurationInMinutes(Double value) {
        this.totalDurationInMinutes = value;
    }

}
