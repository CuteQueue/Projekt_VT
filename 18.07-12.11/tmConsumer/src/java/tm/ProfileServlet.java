
package tm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservice.TmWebService_Service;

/**
* <h1>ProfileServlet</h1>
* Das Servlet prüft, ob ein Profil angelegt ist.
* Wenn ja leitet es auf profile.jsp weiter,
* andernfalls wird createProfile.jsp angezeigt.
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class ProfileServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true); //Erzeugt eine neue Session, wenn noch keine vorhanden und speichert diese in session
        response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility

        String email;
        
        try (PrintWriter out = response.getWriter()) {
            try {

                //----------Falls keine Session vorhanden-----------------------------------------
                if (session.getAttribute("email") == null) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('No valid session.');");
                    out.println("location= window.location.href='Index';");
                    out.println("</script>");
                    out.close();
                    return;
                }

                //--------Passende Userdaten holen ----------------------------------
                email = (String) session.getAttribute("email");
                User u = new User(email);
                session.setAttribute("user", u); //in Session gespeichert 
                session.setAttribute("userId", u.getId());
                User user = (User) session.getAttribute("user");
                out.println("<h2>Willkommen " + user.getName() + " " + user.getLast_name() + "!</h2>");
                out.println("</br>");

                u.getProfileData(); //Profildaten holen
                if (u.getLocation() != null) { //Wenn Profil schon vorhanden
                    RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                    rd.forward(request, response);

                } else { //Wenn noch kein Profil vorhanden:
                    RequestDispatcher rd = request.getRequestDispatcher("createProfile.jsp");
                    rd.forward(request, response);
                }

            } catch (Exception err2) {
                System.out.println("catch, ProfileServlet 111");
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

}
