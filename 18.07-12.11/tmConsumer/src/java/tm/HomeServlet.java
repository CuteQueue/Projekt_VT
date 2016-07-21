/**
 *
 * @author Manuela
 */
package tm;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Manuela
 */
public class HomeServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility

        String email;

        try (PrintWriter out = response.getWriter()) {

            // Neue Session anlegen
            HttpSession session = request.getSession(true); //Erzeugt eine neue Session, wenn noch keine vorhanden und speichert diese in session
            System.out.println("Session created");
            try {
                if (session.getAttribute("email") == null) {
                    out.println("<html><head><title>SessionError</title></head>");
                    out.println("<body><h2>Keine Session vorhanden</h2>");
                    //out.print("<form action=\"http://"+session.getAttribute("ip")+":8080/webChat\"");
                    out.print("<form action=\"http://localhost:8080/tmConsumer\"");
                    out.println("\" method=\"POST\" >");
                    out.println("<br><br><input type=\"submit\" value=\"Startseite\">");
                    out.println("</form>");
                    out.println("</body>");
                    out.close();
                    return;
                }
                email = (String) session.getAttribute("email");
                User u = new User(email);
                session.setAttribute("user", u); //in Session gespeichert 
                User user = (User) session.getAttribute("user");
                out.println("<h2>Willkommen " + user.getName() + " " + user.getLast_name() + "!</h2>");
                out.println("</br>");

                //-------TODO: Ausbessern (ist noch keine optimale Lösung)------------------
                u.getProfileData(); //Profildaten holen
                if (u.getLocation() != null) { //Wenn Profil schon vorhanden: Daten ausgeben
                    out.println("Location: " + u.getLocation() + "</br>");
                    out.println("Age: " + u.getAge() + "</br>");
                    out.println("Destination: " + u.getDestination() + "</br>");
                    out.println("Startdate: " + u.getStartdate() + "</br>");
                    out.println("<form action=\"http://localhost:8080/tmConsumer/editProfile.jsp\">");
                    out.println("<input type=submit value=\"Edit\">");
                    out.println("</form>");

                } else { //Wenn noch kein Profil vorhanden:
                    out.println("Noch kein Profil vorhanden");
                    out.println("Jetzt anlegen: ");
                    out.println("<form action=\"http://localhost:8080/tmConsumer/Create\">");
                    out.println("<input type=submit value=\"Create Profile\">");
                    out.println("</form>");

                }

                out.print("<form action=\"Logout");
                out.println("\" method=\"POST\" >");
                out.println("<br><br><input type=\"submit\" name=\"logout\" value=\"Logout\">");
                out.println("</form>");

            } catch (Exception err2) {
                System.out.println("catch, HomeServlet 86");
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
        } catch (Exception ex) {
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
        } catch (Exception ex) {
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

    /* private String login(java.lang.String email, java.lang.String pw) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.login(email, pw);
    }*/
    public byte[] retrieveSalt(String email) {
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.getSalt(email);
    }

    public byte[] retrieveEncryptedPw(String email) {
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.getEncryptedPw(email);
    }

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
