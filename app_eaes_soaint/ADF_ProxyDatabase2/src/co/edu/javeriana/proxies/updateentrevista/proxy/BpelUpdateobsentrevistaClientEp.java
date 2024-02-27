
package co.edu.javeriana.proxies.updateentrevista.proxy;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0-b170214.1743
 * Generated source version: 2.2
 *
 */
@WebServiceClient(name = "bpel_updateobsentrevista_client_ep",
                  targetNamespace = "http://xmlns.oracle.com/app_eaes_soaint/SOA_Database_2/bpel_updateobsentrevista",
                  wsdlLocation =
                  "http://bpm-dv1:7003/soa-infra/services/default/SOA_Database_2/bpel_updateobsentrevista_client_ep?WSDL#%7Bhttp%3A%2F%2Fxmlns.oracle.com%2Fapp_eaes_soaint%2FSOA_Database_2%2Fbpel_updateobsentrevista%7Dbpel_updateobsentrevista_client_ep")
public class BpelUpdateobsentrevistaClientEp extends Service {

    private final static URL BPELUPDATEOBSENTREVISTACLIENTEP_WSDL_LOCATION;
    private final static WebServiceException BPELUPDATEOBSENTREVISTACLIENTEP_EXCEPTION;
    private final static QName BPELUPDATEOBSENTREVISTACLIENTEP_QNAME =
        new QName("http://xmlns.oracle.com/app_eaes_soaint/SOA_Database_2/bpel_updateobsentrevista",
                  "bpel_updateobsentrevista_client_ep");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url =
                new URL("http://bpm-dv1:7003/soa-infra/services/default/SOA_Database_2/bpel_updateobsentrevista_client_ep?WSDL#%7Bhttp%3A%2F%2Fxmlns.oracle.com%2Fapp_eaes_soaint%2FSOA_Database_2%2Fbpel_updateobsentrevista%7Dbpel_updateobsentrevista_client_ep");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BPELUPDATEOBSENTREVISTACLIENTEP_WSDL_LOCATION = url;
        BPELUPDATEOBSENTREVISTACLIENTEP_EXCEPTION = e;
    }

    public BpelUpdateobsentrevistaClientEp() {
        super(__getWsdlLocation(), BPELUPDATEOBSENTREVISTACLIENTEP_QNAME);
    }

    public BpelUpdateobsentrevistaClientEp(WebServiceFeature... features) {
        super(__getWsdlLocation(), BPELUPDATEOBSENTREVISTACLIENTEP_QNAME, features);
    }

    public BpelUpdateobsentrevistaClientEp(URL wsdlLocation) {
        super(wsdlLocation, BPELUPDATEOBSENTREVISTACLIENTEP_QNAME);
    }

    public BpelUpdateobsentrevistaClientEp(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BPELUPDATEOBSENTREVISTACLIENTEP_QNAME, features);
    }

    public BpelUpdateobsentrevistaClientEp(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BpelUpdateobsentrevistaClientEp(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns BpelUpdateobsentrevista
     */
    @WebEndpoint(name = "bpel_updateobsentrevista_pt")
    public BpelUpdateobsentrevista getBpelUpdateobsentrevistaPt() {
        return super.getPort(new QName("http://xmlns.oracle.com/app_eaes_soaint/SOA_Database_2/bpel_updateobsentrevista",
                                       "bpel_updateobsentrevista_pt"), BpelUpdateobsentrevista.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BpelUpdateobsentrevista
     */
    @WebEndpoint(name = "bpel_updateobsentrevista_pt")
    public BpelUpdateobsentrevista getBpelUpdateobsentrevistaPt(WebServiceFeature... features) {
        return super.getPort(new QName("http://xmlns.oracle.com/app_eaes_soaint/SOA_Database_2/bpel_updateobsentrevista",
                                       "bpel_updateobsentrevista_pt"), BpelUpdateobsentrevista.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BPELUPDATEOBSENTREVISTACLIENTEP_EXCEPTION != null) {
            throw BPELUPDATEOBSENTREVISTACLIENTEP_EXCEPTION;
        }
        return BPELUPDATEOBSENTREVISTACLIENTEP_WSDL_LOCATION;
    }

}
