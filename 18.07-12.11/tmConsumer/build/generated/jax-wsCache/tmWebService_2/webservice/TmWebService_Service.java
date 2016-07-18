
package webservice;

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
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "tmWebService", targetNamespace = "http://WebService/", wsdlLocation = "http://localhost:8080/travelmate_vs/tmWebService?wsdl")
public class TmWebService_Service
    extends Service
{

    private final static URL TMWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException TMWEBSERVICE_EXCEPTION;
    private final static QName TMWEBSERVICE_QNAME = new QName("http://WebService/", "tmWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/travelmate_vs/tmWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TMWEBSERVICE_WSDL_LOCATION = url;
        TMWEBSERVICE_EXCEPTION = e;
    }

    public TmWebService_Service() {
        super(__getWsdlLocation(), TMWEBSERVICE_QNAME);
    }

    public TmWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), TMWEBSERVICE_QNAME, features);
    }

    public TmWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, TMWEBSERVICE_QNAME);
    }

    public TmWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TMWEBSERVICE_QNAME, features);
    }

    public TmWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TmWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TmWebService
     */
    @WebEndpoint(name = "tmWebServicePort")
    public TmWebService getTmWebServicePort() {
        return super.getPort(new QName("http://WebService/", "tmWebServicePort"), TmWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TmWebService
     */
    @WebEndpoint(name = "tmWebServicePort")
    public TmWebService getTmWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebService/", "tmWebServicePort"), TmWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TMWEBSERVICE_EXCEPTION!= null) {
            throw TMWEBSERVICE_EXCEPTION;
        }
        return TMWEBSERVICE_WSDL_LOCATION;
    }

}
