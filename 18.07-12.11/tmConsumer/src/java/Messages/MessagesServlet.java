/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author nina
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
            
            //aktueller User:
            HttpSession session = request.getSession(true);
            User user = (User) session.getAttribute("user");
            
            //aktueller Chatpartner:
            String chatPartnerIdString = request.getParameter("chatPartnerId");
            int chatPartnerId = Integer.parseInt(chatPartnerIdString);
            String chatPartnerName = request.getParameter("chatPartnerName");
            
            //Chatverlauf laden
            java.util.List<webservice.Message> messages = showMessages(user.getId(), chatPartnerId);
            
            session.setAttribute("messages", messages);
            //Ausgabe der Nachrichten:
            out.println("<h2>Messages with " + chatPartnerName + "</h2></br>");
            for (int i = 0; i < messages.size(); i++) {
               
                
                //Wenn die zur Nachrichten gespeicherte UserId gleich der Id des aktuellen Users ist,
                //dann wurde die Nachricht vom aktuellen User gesendet:
                if (messages.get(i).getUserId() == user.getId()) {
                    out.println("</br>");
                    out.println("<li style=\"text-align:right;background-color:blue;\">" + messages.get(i).getContent() + "</br>");
                    out.println("</li>");
                    out.println("</br>");
                } else {
                //Ansonsten wurde die Nachricht vom Chatpartner gesendet:
                    out.println("</br>");
                    out.println("<li style=\"background-color:cyan\">" + messages.get(i).getContent() + "</br>");
                    out.println("</li>");
                    out.println("</br>");
                }
            }
            
            //Chatfenster zum Senden einer neuen Nachricht:
            out.println("    <form action=\"SendNewMessage\" method=\"post\">\n"
                    + "        <table border=\"0\" align=\"center\">\n"
                    + "            <input type=\"hidden\" name=\"chatPartnerId\" value=\"" + chatPartnerId + "\" size=\"50\"/>\n"
                    + "            <input type=\"hidden\" name=\"chatPartnerName\" value=\"" + chatPartnerName + "\" size=\"50\"/>\n"
                    + "            <tr>\n"
                    + "                <td><textarea rows=\"10\" cols=\"39\" name=\"content\"></textarea> </td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"Send\"/></td>\n"
                    + "            </tr>\n"
                    + "        </table>\n"
                    + "         \n");

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
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.showMessages(userId, chatPartnerId);
    }

}
