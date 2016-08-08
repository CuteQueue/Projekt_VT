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
import javax.xml.ws.WebServiceRef;
import tm.User;
import webservice.TmWebService_Service;

/**
 *
 * @author nina
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

            //akuteller User:
            HttpSession session = request.getSession(true);
            User user = (User) session.getAttribute("user");

            //aktueller Chatpartner:
            String chatPartnerIdString = request.getParameter("chatPartnerId");
            int chatPartnerId = Integer.parseInt(chatPartnerIdString);
            String chatPartnerName = request.getParameter("chatPartnerName");

            //Inhalt der Nachricht:
            String content = request.getParameter("content");

            //Nachricht in der Datenbank mit Inhalt, aktueller User und Chatpartner speichern:
            String answer = storeMessage(user.getId(), chatPartnerId, content);
            System.out.println(answer);
            
            //Ausgabe:
            out.println("Nachricht wurde gesendet!");
            out.println(" <form action=\"Messages\" method=\"POST\">");
            //In session speichern!
            out.println(" <input type=\"hidden\" name=\"chatPartnerId\" value=\"" + chatPartnerId + "\">");
            out.println("   <input type=\"hidden\" name=\"chatPartnerName\" value=\"" + chatPartnerName + "\">");
            out.println("   <input type=submit value=\"Show Messages\">"
                      + " </form>");
            out.println("</li>");

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

    private String storeMessage(int senderId, int recipientId, java.lang.String message) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.storeMessage(senderId, recipientId, message);
    }

}
