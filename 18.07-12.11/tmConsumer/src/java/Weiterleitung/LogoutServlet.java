
package Weiterleitung;

import Chat.ChatInterface;
import Chat.ClientInterface;
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
import tm.LoginServlet;


/**
* <h1>LogoutServlet</h1>
* Das Servlet leitet den User auf das logout.jsp weiter.
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class LogoutServlet extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false); //Liefert null zurück, wenn es keine aktuelle Session gibt
             if (session != null) {  
                //aktuelle Session vorhanden
                try{
                    ClientInterface userI = (ClientInterface) session.getAttribute("chatUser"); //user aus Session holen
                    ChatInterface chat = (ChatInterface) session.getAttribute("chat"); //chat aus Session erholen
                    String ipSession = (String) session.getAttribute("ip");
                    chat.sendMessage(userI.getUsername(), "hat sich ausgeloggt");
                    userI.getStub().unsubscribeUser(userI.getUsername());
                }catch(Exception err){
                    System.out.println("User nicht im Chat aktiv. Muss nicht ausgeloggt werden.");
                }
                RequestDispatcher rd = request.getRequestDispatcher("logout.jsp");
                rd.forward(request, response);
             } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('No valid session.');");
                out.println("location= window.location.href='Index';");
                out.println("</script>");
                out.close();
                return;
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