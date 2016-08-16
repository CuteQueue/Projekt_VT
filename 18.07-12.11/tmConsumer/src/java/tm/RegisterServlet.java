
package tm;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservice.TmWebService_Service;

/**
* <h1>RegisterServlet</h1>
* Das RegisterServlet legt einen neuen Nutzer anhand der 
* Formularangaben aus dem register.jsp in der Datenbank an.
* 
* <p>
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class RegisterServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
        HttpSession session = request.getSession(true);   
        
        session.setAttribute("registered", null);
        try (PrintWriter out = response.getWriter()) {
            byte[] newSalt = generateSalt();
            
            String pw = request.getParameterValues("pw")[0];
            byte[] bytesPw = pw.getBytes(StandardCharsets.ISO_8859_1);
            pw = new String(bytesPw, StandardCharsets.UTF_8);
            byte[] encryptedPw = getEncryptedPassword(pw, newSalt);
            
            String name = request.getParameterValues("name")[0];
            byte[] bytesName = name.getBytes(StandardCharsets.ISO_8859_1);
            name = new String(bytesName, StandardCharsets.UTF_8);
            
            String last_name = request.getParameterValues("last_name")[0];
            byte[] bytesLast_name = last_name.getBytes(StandardCharsets.ISO_8859_1);
            last_name = new String(bytesLast_name, StandardCharsets.UTF_8);
            
            String nickname = request.getParameterValues("nickname")[0];
            byte[] bytesNickname = nickname.getBytes(StandardCharsets.ISO_8859_1);
            nickname = new String(bytesNickname, StandardCharsets.UTF_8);
            
            String email = request.getParameterValues("email")[0];
            byte[] bytesEmail = email.getBytes(StandardCharsets.ISO_8859_1);
            email = new String(bytesEmail, StandardCharsets.UTF_8);
            
            
            //Neuer User wird in der Datenbank angelegt
            String addUser = newUser(name, last_name, nickname, email, newSalt, encryptedPw);
            if(addUser==null){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Mail or Nickname already in use.');");
                out.println("location= window.location.href='toRegister';");
                out.println("</script>");
                
            }else{
            session.setAttribute("registered", "true");
            //Weiterleitung auf die Login-Seite, damit sich der neue User einloggen kann
            response.sendRedirect("toLogin");
            }
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
    /**
   * legt über den Web Service einen neuen User an
   * @param name Name aus Usereingabe
   * @param last_name  Nachname aus Usereingabe
   * @param nickname  Spitzname/Nickname aus Usereingabe
   * @param email  Email-Adresse aus Usereingabe
   * @param salt  generierte Zeichenfolge
   * @param password  verschlüsseltes Passwort
   * @return String mit Information, ob User erfolgreich angelegt wurde
   */
    public String newUser(String name, String last_name, String nickname, String email, byte[] salt, byte[] password){
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.newUser(name, last_name, nickname, email, salt, password);
    }
    
    /**
   * generiert eine zufällige Zeichenfolge
   * @return zufällig gewählte Zeichenfolge (salt)
   */
    public byte[] generateSalt() throws NoSuchAlgorithmException {
        // VERY important to use SecureRandom instead of just Random
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

        // Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
        byte[] salt = new byte[8];
        random.nextBytes(salt);

        return salt;
   }

    
}
