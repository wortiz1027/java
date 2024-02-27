//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.08 a las 04:42:56 PM COT 
//


package co.com.service.dancarlton.services.domain.xsd;

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
 *         &lt;element name="header" type="{http://co.dancarlton.com/reservas}Header"/&gt;
 *         &lt;element name="detail" type="{http://co.dancarlton.com/reservas}Reserva"/&gt;
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
    "detail"
})
@XmlRootElement(name = "GetReservasByCodigoResponse")
public class GetReservasByCodigoResponse {

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected Reserva detail;

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
     * Obtiene el valor de la propiedad detail.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getDetail() {
        return detail;
    }

    /**
     * Define el valor de la propiedad detail.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setDetail(Reserva value) {
        this.detail = value;
    }

}
