
package co.edu.javeriana.proxies.getfile.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFileByIDResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetFileByIDResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetFileByIDResult" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0}GetFileByIDResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFileByIDResponse", propOrder = { "getFileByIDResult" })
public class GetFileByIDResponse {

    @XmlElementRef(name = "GetFileByIDResult",
                   namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<GetFileByIDResult> getFileByIDResult;

    /**
     * Gets the value of the getFileByIDResult property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetFileByIDResult }{@code >}
     *
     */
    public JAXBElement<GetFileByIDResult> getGetFileByIDResult() {
        return getFileByIDResult;
    }

    /**
     * Sets the value of the getFileByIDResult property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetFileByIDResult }{@code >}
     *
     */
    public void setGetFileByIDResult(JAXBElement<GetFileByIDResult> value) {
        this.getFileByIDResult = value;
    }

}
