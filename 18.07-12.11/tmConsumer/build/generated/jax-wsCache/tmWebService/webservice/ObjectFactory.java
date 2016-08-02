
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
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

    private final static QName _CreateProfile_QNAME = new QName("http://WebService/", "createProfile");
    private final static QName _CreateProfileResponse_QNAME = new QName("http://WebService/", "createProfileResponse");
    private final static QName _GetEncryptedPw_QNAME = new QName("http://WebService/", "getEncryptedPw");
    private final static QName _GetEncryptedPwResponse_QNAME = new QName("http://WebService/", "getEncryptedPwResponse");
    private final static QName _GetName_QNAME = new QName("http://WebService/", "getName");
    private final static QName _GetNameResponse_QNAME = new QName("http://WebService/", "getNameResponse");
    private final static QName _GetSalt_QNAME = new QName("http://WebService/", "getSalt");
    private final static QName _GetSaltResponse_QNAME = new QName("http://WebService/", "getSaltResponse");
    private final static QName _Hello_QNAME = new QName("http://WebService/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://WebService/", "helloResponse");
    private final static QName _Login_QNAME = new QName("http://WebService/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://WebService/", "loginResponse");
    private final static QName _NewUser_QNAME = new QName("http://WebService/", "newUser");
    private final static QName _NewUserResponse_QNAME = new QName("http://WebService/", "newUserResponse");
    private final static QName _NewUserSalt_QNAME = new QName("", "salt");
    private final static QName _NewUserPassword_QNAME = new QName("", "password");
    private final static QName _GetSaltResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateProfile }
     * 
     */
    public CreateProfile createCreateProfile() {
        return new CreateProfile();
    }

    /**
     * Create an instance of {@link CreateProfileResponse }
     * 
     */
    public CreateProfileResponse createCreateProfileResponse() {
        return new CreateProfileResponse();
    }

    /**
     * Create an instance of {@link GetEncryptedPw }
     * 
     */
    public GetEncryptedPw createGetEncryptedPw() {
        return new GetEncryptedPw();
    }

    /**
     * Create an instance of {@link GetEncryptedPwResponse }
     * 
     */
    public GetEncryptedPwResponse createGetEncryptedPwResponse() {
        return new GetEncryptedPwResponse();
    }

    /**
     * Create an instance of {@link GetName }
     * 
     */
    public GetName createGetName() {
        return new GetName();
    }

    /**
     * Create an instance of {@link GetNameResponse }
     * 
     */
    public GetNameResponse createGetNameResponse() {
        return new GetNameResponse();
    }

    /**
     * Create an instance of {@link GetSalt }
     * 
     */
    public GetSalt createGetSalt() {
        return new GetSalt();
    }

    /**
     * Create an instance of {@link GetSaltResponse }
     * 
     */
    public GetSaltResponse createGetSaltResponse() {
        return new GetSaltResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link NewUser }
     * 
     */
    public NewUser createNewUser() {
        return new NewUser();
    }

    /**
     * Create an instance of {@link NewUserResponse }
     * 
     */
    public NewUserResponse createNewUserResponse() {
        return new NewUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "createProfile")
    public JAXBElement<CreateProfile> createCreateProfile(CreateProfile value) {
        return new JAXBElement<CreateProfile>(_CreateProfile_QNAME, CreateProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProfileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "createProfileResponse")
    public JAXBElement<CreateProfileResponse> createCreateProfileResponse(CreateProfileResponse value) {
        return new JAXBElement<CreateProfileResponse>(_CreateProfileResponse_QNAME, CreateProfileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEncryptedPw }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getEncryptedPw")
    public JAXBElement<GetEncryptedPw> createGetEncryptedPw(GetEncryptedPw value) {
        return new JAXBElement<GetEncryptedPw>(_GetEncryptedPw_QNAME, GetEncryptedPw.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEncryptedPwResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getEncryptedPwResponse")
    public JAXBElement<GetEncryptedPwResponse> createGetEncryptedPwResponse(GetEncryptedPwResponse value) {
        return new JAXBElement<GetEncryptedPwResponse>(_GetEncryptedPwResponse_QNAME, GetEncryptedPwResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getName")
    public JAXBElement<GetName> createGetName(GetName value) {
        return new JAXBElement<GetName>(_GetName_QNAME, GetName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getNameResponse")
    public JAXBElement<GetNameResponse> createGetNameResponse(GetNameResponse value) {
        return new JAXBElement<GetNameResponse>(_GetNameResponse_QNAME, GetNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSalt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getSalt")
    public JAXBElement<GetSalt> createGetSalt(GetSalt value) {
        return new JAXBElement<GetSalt>(_GetSalt_QNAME, GetSalt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSaltResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getSaltResponse")
    public JAXBElement<GetSaltResponse> createGetSaltResponse(GetSaltResponse value) {
        return new JAXBElement<GetSaltResponse>(_GetSaltResponse_QNAME, GetSaltResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "newUser")
    public JAXBElement<NewUser> createNewUser(NewUser value) {
        return new JAXBElement<NewUser>(_NewUser_QNAME, NewUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "newUserResponse")
    public JAXBElement<NewUserResponse> createNewUserResponse(NewUserResponse value) {
        return new JAXBElement<NewUserResponse>(_NewUserResponse_QNAME, NewUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "salt", scope = NewUser.class)
    public JAXBElement<byte[]> createNewUserSalt(byte[] value) {
        return new JAXBElement<byte[]>(_NewUserSalt_QNAME, byte[].class, NewUser.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "password", scope = NewUser.class)
    public JAXBElement<byte[]> createNewUserPassword(byte[] value) {
        return new JAXBElement<byte[]>(_NewUserPassword_QNAME, byte[].class, NewUser.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = GetSaltResponse.class)
    public JAXBElement<byte[]> createGetSaltResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_GetSaltResponseReturn_QNAME, byte[].class, GetSaltResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = GetEncryptedPwResponse.class)
    public JAXBElement<byte[]> createGetEncryptedPwResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_GetSaltResponseReturn_QNAME, byte[].class, GetEncryptedPwResponse.class, ((byte[]) value));
    }

}
