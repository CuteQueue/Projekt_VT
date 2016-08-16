
package tm;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservice.TmWebService_Service;

/**
 *
 * @author Manuela & Nina
 */

/**
* <h1>LoginServlet</h1>
* Das LoginServlet holt sich aus den Formulardaten der login.jsp
* die Userdaten und führt Login-Prozess durch.
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class LoginServlet extends HttpServlet {
    
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/travelmate_vs/tmWebService.wsdl")
    private TmWebService_Service service;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     int exit = 0;
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
        HttpSession session = request.getSession(true);
       
        String email;
        try (PrintWriter out = response.getWriter()){
            
            try {
                String serverIp = request.getParameterValues("serverIp")[0];
                session.setAttribute("serverIp", serverIp);
                email = request.getParameterValues("email")[0]; 
                byte[] bytesEmail = email.getBytes(StandardCharsets.ISO_8859_1);
                email = new String(bytesEmail, StandardCharsets.UTF_8);
                
                String attemptedPassword = request.getParameterValues("pw")[0];
                byte[] bytesPw = attemptedPassword.getBytes(StandardCharsets.ISO_8859_1);
                attemptedPassword = new String(bytesPw, StandardCharsets.UTF_8);
               
                byte[] salt = retrieveSalt(email);
                byte[] encryptedPassword = retrieveEncryptedPw(email);
                if(authenticate(attemptedPassword, encryptedPassword, salt)){
                    session.setAttribute("email", email);
                    User user = new User(email);
                    String nickname = user.getNickname();
                    session.setAttribute("nickname", nickname);
                    out.println("<meta http-equiv=\"refresh\" content=\"0;URL=http://"+session.getAttribute("serverIp")+":8080/tmConsumer/Profile\">");
                }else{
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('User or password incorrect.');");
                    out.println("location='http://"+session.getAttribute("serverIp")+":8080/tmConsumer/toLogin\';");
                    out.println("</script>");   
                }
            }catch(Exception Err0){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Please use username and password to login.');");
                out.println("location='http://"+session.getAttribute("serverIp")+":8080/tmConsumer/toLogin\';");
                out.println("</script>");
            }
        }catch(Exception Err1){
            System.out.println("error LoginServlet");
        }  
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
   * liefert Salt aus Datenbank passend zur User-Email
   * @param email  Email-Adresse des Users
   * @return Salt zur Emailadresse
   */
    public byte[] retrieveSalt(String email){
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.getSalt(email);
    }
    
    /**
   * liefert verschlüsseltes Passwort aus Datenbank passend zur User-Email
   * @param email  Email-Adresse des Users
   * @return verschlüsseltes Passwort zru Emailadresse
   */
    public byte[] retrieveEncryptedPw(String email){
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.getEncryptedPw(email);
    }

    /**
   * prüft, ob beim Login genutztes Passwort dem bei der
   * Registration angegebenem Passwort entspricht
   * @param attemptedPassword  beim Login angegebenes Passwort
   * @param encryptedPassword  verschlüsseltes Passwort aus Datenbank
   * @return boolschen Wert, ob Passwörter übereinstimmen
   */
    public boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt)
        throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Encrypt the clear-text password using the same salt that was used to
        // encrypt the original password
        System.out.println("authenticate 1");
        byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
        System.out.println("ENCRYPTED PW: " + encryptedAttemptedPassword);
        // Authentication succeeds if encrypted password that the user entered
        // is equal to the stored hash
        return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
     }
    
    /**
   * nutzt PBKDF2 (Password-Based Key Derivation Function 2) und salt, 
   * um von dem eingegebenen Passwort einen Schlüssel abzuleiten
   * @param password Klartext-Passwort aus Usereingabe
   * @param salt generierte Zeichenfolge
   * @return byte[] mit verschlüsseltem Passwort.
   */ 
    public byte[] getEncryptedPassword(String password, byte[] salt)
        throws NoSuchAlgorithmException, InvalidKeySpecException {
       // PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
       // specifically names SHA-1 as an acceptable hashing algorithm for PBKDF2
       String algorithm = "PBKDF2WithHmacSHA1";
       // SHA-1 generates 160 bit hashes, so that's what makes sense here
       int derivedKeyLength = 160;
       // Pick an iteration count that works for you. The NIST recommends at
       // least 1,000 iterations:
       // http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
       // iOS 4.x reportedly uses 10,000:
       // http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/
       int iterations = 20000;

       KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
       SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
       return f.generateSecret(spec).getEncoded();
     }  
}
