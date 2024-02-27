
package co.edu.javeriana.proxies.checkin.proxy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import javax.xml.bind.annotation.XmlSeeAlso;

import co.edu.javeriana.proxies.checkin.types.CheckInUniversal;
import co.edu.javeriana.proxies.checkin.types.CheckInUniversalResult;
import co.edu.javeriana.proxies.checkin.types.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0-b170214.1743
 * Generated source version: 2.2
 *
 */
@WebService(name = "bpel_checkin_wcc",
            targetNamespace = "http://xmlns.oracle.com/app_eaes_soaint/SOA_Content/bpel_checkin_wcc")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ ObjectFactory.class })
public interface BpelCheckinWcc {


    /**
     *
     * @param payload
     * @return
     *     returns co.edu.javeriana.proxies.checkin.types.CheckInUniversalResult
     */
    @WebMethod(action = "process")
    @WebResult(name = "output",
               targetNamespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
               partName = "payload")
    public CheckInUniversalResult process(@WebParam(name = "input",
                                                    targetNamespace =
                                                    "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                                                    partName = "payload") CheckInUniversal payload);

}
