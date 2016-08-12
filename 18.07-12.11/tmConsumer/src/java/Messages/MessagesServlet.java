/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import tm.User;
import webservice.TmWebService_Service;

/**
 *
 * @author nina & manuela
 */
public class MessagesServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);
            
            //----------Falls keine Session vorhanden-----------------------------------------
            if (session.getAttribute("email") == null) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('No valid session.');");
                out.println("location= window.location.href='Index';");
                out.println("</script>");
                out.close();
                return;
            }

            //aktueller User:            
            User user = (User) session.getAttribute("user");
            
            //aktueller Chatpartner:
            int chatPartnerId = (int) session.getAttribute("chatPartnerId");
            
            //Chatverlauf laden:
            java.util.List<webservice.Message> messages = showMessages(user.getId(), chatPartnerId);
            //Und in Session speichern:
            session.setAttribute("messages", messages);
           
            //Weiterleitung zu "message.jsp", um die Nachrichten anzuzeigen
            RequestDispatcher rd = request.getRequestDispatcher("messages.jsp");
           rd.forward(request, response);

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

    private java.util.List<webservice.Message> showMessages(int userId, int chatPartnerId) {
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.showMessages(userId, chatPartnerId);
    }

}
