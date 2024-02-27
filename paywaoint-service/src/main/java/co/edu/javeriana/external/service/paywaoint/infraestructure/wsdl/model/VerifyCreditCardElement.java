//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.24 a las 12:17:15 AM COT 
//


package co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model;

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
 *         &lt;element name="cc" type="{http://services.creditverifier.com/types/}CreditCard"/&gt;
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
    "cc"
})
@XmlRootElement(name = "verifyCreditCardElement")
public class VerifyCreditCardElement {

    @XmlElement(required = true, nillable = true)
    protected CreditCard cc;

    /**
     * Obtiene el valor de la propiedad cc.
     * 
     * @return
     *     possible object is
     *     {@link CreditCard }
     *     
     */
    public CreditCard getCc() {
        return cc;
    }

    /**
     * Define el valor de la propiedad cc.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCard }
     *     
     */
    public void setCc(CreditCard value) {
        this.cc = value;
    }

}
