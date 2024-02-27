//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.24 a las 12:17:15 AM COT 
//


package co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model package. 
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

    private final static QName _CreditCardValidationFaultMessageElement_QNAME = new QName("http://services.creditverifier.com/", "CreditCardValidationFaultMessageElement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChargeCreditCardElement }
     * 
     */
    public ChargeCreditCardElement createChargeCreditCardElement() {
        return new ChargeCreditCardElement();
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link ChargeCreditCardResponseElement }
     * 
     */
    public ChargeCreditCardResponseElement createChargeCreditCardResponseElement() {
        return new ChargeCreditCardResponseElement();
    }

    /**
     * Create an instance of {@link CreditCardValidationFaultMessage }
     * 
     */
    public CreditCardValidationFaultMessage createCreditCardValidationFaultMessage() {
        return new CreditCardValidationFaultMessage();
    }

    /**
     * Create an instance of {@link VerifyCreditCardElement }
     * 
     */
    public VerifyCreditCardElement createVerifyCreditCardElement() {
        return new VerifyCreditCardElement();
    }

    /**
     * Create an instance of {@link VerifyCreditCardResponseElement }
     * 
     */
    public VerifyCreditCardResponseElement createVerifyCreditCardResponseElement() {
        return new VerifyCreditCardResponseElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditCardValidationFaultMessage }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreditCardValidationFaultMessage }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.creditverifier.com/", name = "CreditCardValidationFaultMessageElement")
    public JAXBElement<CreditCardValidationFaultMessage> createCreditCardValidationFaultMessageElement(CreditCardValidationFaultMessage value) {
        return new JAXBElement<CreditCardValidationFaultMessage>(_CreditCardValidationFaultMessageElement_QNAME, CreditCardValidationFaultMessage.class, null, value);
    }

}
