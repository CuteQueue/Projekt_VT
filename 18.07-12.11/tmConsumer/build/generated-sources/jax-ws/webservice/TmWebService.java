
package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "tmWebService", targetNamespace = "http://WebService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TmWebService {


    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getName", targetNamespace = "http://WebService/", className = "webservice.GetName")
    @ResponseWrapper(localName = "getNameResponse", targetNamespace = "http://WebService/", className = "webservice.GetNameResponse")
    @Action(input = "http://WebService/tmWebService/getNameRequest", output = "http://WebService/tmWebService/getNameResponse")
    public String getName(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://WebService/", className = "webservice.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://WebService/", className = "webservice.HelloResponse")
    @Action(input = "http://WebService/tmWebService/helloRequest", output = "http://WebService/tmWebService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param pw
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://WebService/", className = "webservice.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://WebService/", className = "webservice.LoginResponse")
    @Action(input = "http://WebService/tmWebService/loginRequest", output = "http://WebService/tmWebService/loginResponse")
    public String login(
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "pw", targetNamespace = "")
        String pw);

    /**
     * 
     * @param email
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEncryptedPw", targetNamespace = "http://WebService/", className = "webservice.GetEncryptedPw")
    @ResponseWrapper(localName = "getEncryptedPwResponse", targetNamespace = "http://WebService/", className = "webservice.GetEncryptedPwResponse")
    @Action(input = "http://WebService/tmWebService/getEncryptedPwRequest", output = "http://WebService/tmWebService/getEncryptedPwResponse")
    public byte[] getEncryptedPw(
        @WebParam(name = "email", targetNamespace = "")
        String email);

    /**
     * 
     * @param email
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSalt", targetNamespace = "http://WebService/", className = "webservice.GetSalt")
    @ResponseWrapper(localName = "getSaltResponse", targetNamespace = "http://WebService/", className = "webservice.GetSaltResponse")
    @Action(input = "http://WebService/tmWebService/getSaltRequest", output = "http://WebService/tmWebService/getSaltResponse")
    public byte[] getSalt(
        @WebParam(name = "email", targetNamespace = "")
        String email);

    /**
     * 
     * @param lastName
     * @param password
     * @param salt
     * @param name
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "newUser", targetNamespace = "http://WebService/", className = "webservice.NewUser")
    @ResponseWrapper(localName = "newUserResponse", targetNamespace = "http://WebService/", className = "webservice.NewUserResponse")
    @Action(input = "http://WebService/tmWebService/newUserRequest", output = "http://WebService/tmWebService/newUserResponse")
    public String newUser(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "last_name", targetNamespace = "")
        String lastName,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "salt", targetNamespace = "")
        byte[] salt,
        @WebParam(name = "password", targetNamespace = "")
        byte[] password);

}
