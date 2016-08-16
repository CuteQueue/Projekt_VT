
package Weiterleitung;

import Chat.ChatInterface;
import Chat.ClientInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tm.User;

/**
* <h1>WeiterleitungProfilServlet</h1>
* Das Servlet leitet den User zum profile.jsp weiter
* und prüft vorher, ob das eigene oder ein fremdes 
* Profil angezeigt werden soll.
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class WeiterleitungProfilServlet extends HttpServlet {

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
        response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
        HttpSession session = request.getSession(true);
        
        try (PrintWriter out = response.getWriter()) {
            User user = (User)session.getAttribute("user");
            //Prüfung, ob Nutzer noch in Chat eingeloggt, dann ausloggen, weil Chatfenster nicht aktiv
            try{
                ClientInterface userI = (ClientInterface) session.getAttribute("chatUser"); //user aus Session holen
                ChatInterface chat = (ChatInterface) session.getAttribute("chat"); //chat aus Session erholen
                chat.sendMessage(userI.getUsername(), "hat sich ausgeloggt");
                userI.getStub().unsubscribeUser(userI.getUsername());
            }catch(Exception err){
                System.out.println("User nicht im Chat aktiv. Muss nicht ausgeloggt werden.");
            }
            try{
                String email = request.getParameterValues("email")[0];
                //wenn Parameter für Email-Wert übergeben wird und dieser sich von der user email unterscheidet
                //wird die übergebene Email in der Session gespeichert und zur profil.jsp weitergeleitet (zur Anzeige eines fremden Profils)
                if(!email.equals(user.getEmail())){
                    session.setAttribute("email", email);
                }
                RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                rd.forward(request, response);
            }catch(Exception weiterleitungProfil){
                //wird keine abweichende Email übergeben, dann wird einfach zur profil.jsp weitergeleitet (zur Anzeige des eigenen Profils)
                RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
