
package co.edu.javeriana.proxies.insertarprototipo.proxy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import javax.xml.bind.annotation.XmlSeeAlso;

import co.edu.javeriana.proxies.insertarprototipo.types.InsertarPrototipoType;
import co.edu.javeriana.proxies.insertarprototipo.types.ObjectFactory;
import co.edu.javeriana.proxies.insertarprototipo.types.ResponseType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0-b170214.1743
 * Generated source version: 2.2
 *
 */
@WebService(name = "bpel_insertarprototipo",
            targetNamespace = "http://xmlns.oracle.com/app_eaes_soaint/SOA_Database/bpel_insertarprototipo")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ ObjectFactory.class })
public interface BpelInsertarprototipo {


    /**
     *
     * @param payload
     * @return
     *     returns co.edu.javeriana.proxies.insertarprototipo.types.ResponseType
     */
    @WebMethod(action = "process")
    @WebResult(name = "response",
               targetNamespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarPrototipo/v1.0",
               partName = "payload")
    public ResponseType process(@WebParam(name = "request",
                                          targetNamespace =
                                          "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/InsertarPrototipo/v1.0",
                                          partName = "payload") InsertarPrototipoType payload);

}