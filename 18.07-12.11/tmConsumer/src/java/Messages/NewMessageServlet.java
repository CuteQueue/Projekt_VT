/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nina
 */
public class NewMessageServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            
            
            //----------Falls keine Session vorhanden-----------------------------------------
            if (session.getAttribute("email") == null) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('No valid session.');");
                out.println("location= window.location.href='Index';");
                out.println("</script>");
                out.close();
                return;
            }

            
            
            //Attribute es Chatpartners:
            String chatPartnerId = request.getParameter("chatPartnerId");
            String chatPartnerName = request.getParameter("chatPartnerName");
            System.out.println("chatNameNew: " + chatPartnerName);
            //Chat-Fenster zum senden einer Nachricht,
            //mit dem Abschicken wird "SendNewMessageServlet" aufgerufen
            out.println("<html>\n"
                    + "<head>\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
                    + "<title>Send a message:</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "    <form action=\"SendNewMessage\" method=\"post\">\n"
                    + "        <table border=\"0\" width=\"35%\" align=\"center\">\n"
                    + "            <caption><h2>Send New Message</h2></caption>\n"
                    + "            <tr>\n"
                    + "                <td><input type=\"hidden\" name=\"chatPartnerId\" value=\"" + chatPartnerId + "\" size=\"50\"/></td>\n"
                    + "              <td><input type=\"hidden\" name=\"chatPartnerName\" value=\"" + chatPartnerName + "\" size=\"50\"/></td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td><textarea rows=\"10\" cols=\"39\" name=\"content\"></textarea> </td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"Send\"/></td>\n"
                    + "            </tr>\n"
                    + "        </table>\n"
                    + "         \n"
                    + "    </form>\n"
                    + "</body>\n"
                    + "</html>");

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
