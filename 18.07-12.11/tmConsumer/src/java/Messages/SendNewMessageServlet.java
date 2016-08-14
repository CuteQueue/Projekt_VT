/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
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
public class SendNewMessageServlet extends HttpServlet {

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
            
            //akuteller User:
            User user = (User) session.getAttribute("user");

            //aktueller Chatpartner:
            int chatPartnerId =  (int)session.getAttribute("chatPartnerId");
         
            //Inhalt der Nachricht:
            String content = request.getParameter("content");
            byte[] bytes = content.getBytes(StandardCharsets.ISO_8859_1);
            content = new String(bytes, StandardCharsets.UTF_8);
            
            //Nachricht in der Datenbank mit Inhalt, aktueller User und Chatpartner speichern:
            String answer = storeMessage(user.getId(), chatPartnerId, content);
            
            //Weiterleitung zu "MessagesServlet, um den Chatverlauf zu  laden
            out.println("<meta http-equiv=\"refresh\" content=\"0;URL=http://"+session.getAttribute("serverIp")+":8080/tmConsumer/Messages\">");
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

    private String storeMessage(int senderId, int recipientId, String message) {
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.storeMessage(senderId, recipientId, message);
    }

}
