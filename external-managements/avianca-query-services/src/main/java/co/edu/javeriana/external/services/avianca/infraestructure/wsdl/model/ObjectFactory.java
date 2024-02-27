//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.18 a las 05:08:08 PM COT 
//


package co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FlightOption_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "FlightOption");
    private final static QName _AvalaibleItinerary_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "AvalaibleItinerary");
    private final static QName _ArrayOfAvalaibleFlight_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "ArrayOfAvalaibleFlight");
    private final static QName _AvalaibleFlight_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "AvalaibleFlight");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _GetFlightsFlightOption_QNAME = new QName("http://tempuri.org/", "flightOption");
    private final static QName _GetFlightsResponseGetFlightsResult_QNAME = new QName("http://tempuri.org/", "GetFlightsResult");
    private final static QName _AvalaibleFlightAirLine_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "AirLine");
    private final static QName _AvalaibleFlightCityFrom_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "CityFrom");
    private final static QName _AvalaibleFlightCityTo_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "CityTo");
    private final static QName _AvalaibleFlightDestinationAirportName_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "DestinationAirportName");
    private final static QName _AvalaibleFlightDurationString_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "DurationString");
    private final static QName _AvalaibleFlightFlightNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "FlightNumber");
    private final static QName _AvalaibleFlightFlightScale_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "FlightScale");
    private final static QName _AvalaibleFlightOriginAirportName_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "OriginAirportName");
    private final static QName _AvalaibleItineraryDepartureFlights_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "DepartureFlights");
    private final static QName _AvalaibleItineraryReturnFlights_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "ReturnFlights");
    private final static QName _FlightOptionDestinationCityDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "DestinationCityDescription");
    private final static QName _FlightOptionOriginCityDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", "OriginCityDescription");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlights }
     * 
     */
    public GetFlights createGetFlights() {
        return new GetFlights();
    }

    /**
     * Create an instance of {@link FlightOption }
     * 
     */
    public FlightOption createFlightOption() {
        return new FlightOption();
    }

    /**
     * Create an instance of {@link GetFlightsResponse }
     * 
     */
    public GetFlightsResponse createGetFlightsResponse() {
        return new GetFlightsResponse();
    }

    /**
     * Create an instance of {@link AvalaibleItinerary }
     * 
     */
    public AvalaibleItinerary createAvalaibleItinerary() {
        return new AvalaibleItinerary();
    }

    /**
     * Create an instance of {@link ArrayOfAvalaibleFlight }
     * 
     */
    public ArrayOfAvalaibleFlight createArrayOfAvalaibleFlight() {
        return new ArrayOfAvalaibleFlight();
    }

    /**
     * Create an instance of {@link AvalaibleFlight }
     * 
     */
    public AvalaibleFlight createAvalaibleFlight() {
        return new AvalaibleFlight();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlightOption }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FlightOption }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "FlightOption")
    public JAXBElement<FlightOption> createFlightOption(FlightOption value) {
        return new JAXBElement<FlightOption>(_FlightOption_QNAME, FlightOption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvalaibleItinerary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AvalaibleItinerary }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "AvalaibleItinerary")
    public JAXBElement<AvalaibleItinerary> createAvalaibleItinerary(AvalaibleItinerary value) {
        return new JAXBElement<AvalaibleItinerary>(_AvalaibleItinerary_QNAME, AvalaibleItinerary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "ArrayOfAvalaibleFlight")
    public JAXBElement<ArrayOfAvalaibleFlight> createArrayOfAvalaibleFlight(ArrayOfAvalaibleFlight value) {
        return new JAXBElement<ArrayOfAvalaibleFlight>(_ArrayOfAvalaibleFlight_QNAME, ArrayOfAvalaibleFlight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvalaibleFlight }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AvalaibleFlight }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "AvalaibleFlight")
    public JAXBElement<AvalaibleFlight> createAvalaibleFlight(AvalaibleFlight value) {
        return new JAXBElement<AvalaibleFlight>(_AvalaibleFlight_QNAME, AvalaibleFlight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlightOption }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FlightOption }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "flightOption", scope = GetFlights.class)
    public JAXBElement<FlightOption> createGetFlightsFlightOption(FlightOption value) {
        return new JAXBElement<FlightOption>(_GetFlightsFlightOption_QNAME, FlightOption.class, GetFlights.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvalaibleItinerary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AvalaibleItinerary }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetFlightsResult", scope = GetFlightsResponse.class)
    public JAXBElement<AvalaibleItinerary> createGetFlightsResponseGetFlightsResult(AvalaibleItinerary value) {
        return new JAXBElement<AvalaibleItinerary>(_GetFlightsResponseGetFlightsResult_QNAME, AvalaibleItinerary.class, GetFlightsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "AirLine", scope = AvalaibleFlight.class)
    public JAXBElement<String> createAvalaibleFlightAirLine(String value) {
        return new JAXBElement<String>(_AvalaibleFlightAirLine_QNAME, String.class, AvalaibleFlight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "CityFrom", scope = AvalaibleFlight.class)
    public JAXBElement<String> createAvalaibleFlightCityFrom(String value) {
        return new JAXBElement<String>(_AvalaibleFlightCityFrom_QNAME, String.class, AvalaibleFlight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "CityTo", scope = AvalaibleFlight.class)
    public JAXBElement<String> createAvalaibleFlightCityTo(String value) {
        return new JAXBElement<String>(_AvalaibleFlightCityTo_QNAME, String.class, AvalaibleFlight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "DestinationAirportName", scope = AvalaibleFlight.class)
    public JAXBElement<String> createAvalaibleFlightDestinationAirportName(String value) {
        return new JAXBElement<String>(_AvalaibleFlightDestinationAirportName_QNAME, String.class, AvalaibleFlight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "DurationString", scope = AvalaibleFlight.class)
    public JAXBElement<String> createAvalaibleFlightDurationString(String value) {
        return new JAXBElement<String>(_AvalaibleFlightDurationString_QNAME, String.class, AvalaibleFlight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "FlightNumber", scope = AvalaibleFlight.class)
    public JAXBElement<String> createAvalaibleFlightFlightNumber(String value) {
        return new JAXBElement<String>(_AvalaibleFlightFlightNumber_QNAME, String.class, AvalaibleFlight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "FlightScale", scope = AvalaibleFlight.class)
    public JAXBElement<String> createAvalaibleFlightFlightScale(String value) {
        return new JAXBElement<String>(_AvalaibleFlightFlightScale_QNAME, String.class, AvalaibleFlight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "OriginAirportName", scope = AvalaibleFlight.class)
    public JAXBElement<String> createAvalaibleFlightOriginAirportName(String value) {
        return new JAXBElement<String>(_AvalaibleFlightOriginAirportName_QNAME, String.class, AvalaibleFlight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "DepartureFlights", scope = AvalaibleItinerary.class)
    public JAXBElement<ArrayOfAvalaibleFlight> createAvalaibleItineraryDepartureFlights(ArrayOfAvalaibleFlight value) {
        return new JAXBElement<ArrayOfAvalaibleFlight>(_AvalaibleItineraryDepartureFlights_QNAME, ArrayOfAvalaibleFlight.class, AvalaibleItinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfAvalaibleFlight }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "ReturnFlights", scope = AvalaibleItinerary.class)
    public JAXBElement<ArrayOfAvalaibleFlight> createAvalaibleItineraryReturnFlights(ArrayOfAvalaibleFlight value) {
        return new JAXBElement<ArrayOfAvalaibleFlight>(_AvalaibleItineraryReturnFlights_QNAME, ArrayOfAvalaibleFlight.class, AvalaibleItinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "DestinationCityDescription", scope = FlightOption.class)
    public JAXBElement<String> createFlightOptionDestinationCityDescription(String value) {
        return new JAXBElement<String>(_FlightOptionDestinationCityDescription_QNAME, String.class, FlightOption.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/AviancaDemoWcfService", name = "OriginCityDescription", scope = FlightOption.class)
    public JAXBElement<String> createFlightOptionOriginCityDescription(String value) {
        return new JAXBElement<String>(_FlightOptionOriginCityDescription_QNAME, String.class, FlightOption.class, value);
    }

}
