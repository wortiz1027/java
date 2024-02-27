//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.08 a las 07:35:46 PM COT 
//


package co.edu.javeriana.external.services.dc.infraestructure.ws.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Reserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Reserva"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoReserva" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaInicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaFin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombreHuesped" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tienePasaporte" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeroPasaporte" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoHabitacion" type="{http://co.dancarlton.com/reservas}tipoHabitacion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reserva", propOrder = {
    "idReserva",
    "codigoReserva",
    "fechaInicio",
    "fechaFin",
    "nombreHuesped",
    "tienePasaporte",
    "numeroPasaporte",
    "numeroDocumento",
    "observaciones",
    "tipoHabitacion"
})
public class Reserva {

    @XmlElement(required = true)
    protected String idReserva;
    @XmlElement(required = true)
    protected String codigoReserva;
    @XmlElement(required = true)
    protected String fechaInicio;
    @XmlElement(required = true)
    protected String fechaFin;
    @XmlElement(required = true)
    protected String nombreHuesped;
    @XmlElement(required = true)
    protected String tienePasaporte;
    @XmlElement(required = true)
    protected String numeroPasaporte;
    @XmlElement(required = true)
    protected String numeroDocumento;
    @XmlElement(required = true)
    protected String observaciones;
    @XmlElement(required = true)
    protected TipoHabitacion tipoHabitacion;

    /**
     * Obtiene el valor de la propiedad idReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Define el valor de la propiedad idReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdReserva(String value) {
        this.idReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoReserva() {
        return codigoReserva;
    }

    /**
     * Define el valor de la propiedad codigoReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoReserva(String value) {
        this.codigoReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Define el valor de la propiedad fechaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicio(String value) {
        this.fechaInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * Define el valor de la propiedad fechaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFin(String value) {
        this.fechaFin = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreHuesped.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreHuesped() {
        return nombreHuesped;
    }

    /**
     * Define el valor de la propiedad nombreHuesped.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreHuesped(String value) {
        this.nombreHuesped = value;
    }

    /**
     * Obtiene el valor de la propiedad tienePasaporte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTienePasaporte() {
        return tienePasaporte;
    }

    /**
     * Define el valor de la propiedad tienePasaporte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTienePasaporte(String value) {
        this.tienePasaporte = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroPasaporte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    /**
     * Define el valor de la propiedad numeroPasaporte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroPasaporte(String value) {
        this.numeroPasaporte = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Define el valor de la propiedad numeroDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoHabitacion.
     * 
     * @return
     *     possible object is
     *     {@link TipoHabitacion }
     *     
     */
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Define el valor de la propiedad tipoHabitacion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoHabitacion }
     *     
     */
    public void setTipoHabitacion(TipoHabitacion value) {
        this.tipoHabitacion = value;
    }

}
