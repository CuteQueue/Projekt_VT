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
public class InboxServlet extends HttpServlet {

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
            int user_id = user.getId();
            
            //Die verschiedenen Unterhaltungen laden
            java.util.List<webservice.User> sender = showConversations(user_id);
            
            //Die verschiedenen Unterhalten mit den jeweiligen Nutzernamen anzeigen
            //Wird der Name angeklickt, wird der zugehörige Chatverlauf angezeigt
            for (int i = 0; i < sender.size(); i++) {
                out.println("</br>");
                out.println(" <form action=\"Messages\" method=\"POST\">");
                out.println("   <input type=\"hidden\" name=\"chatPartnerId\" value=\"" + sender.get(i).getUserId() + "\">");
                out.println("   <input type=\"hidden\" name=\"chatPartnerName\" value=\"" + sender.get(i).getName() + "\">");
                out.println("   <input type=submit value=" + sender.get(i).getName() + ">\n"
                          + " </form>");
                out.println("</li>");
                out.println("</br>");

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

    private java.util.List<webservice.User> showConversations(int userId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.showConversations(userId);
    }

}
