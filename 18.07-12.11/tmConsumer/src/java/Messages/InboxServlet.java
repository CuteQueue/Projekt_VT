/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

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
import javax.xml.ws.WebServiceRef;
import tm.User;
import webservice.TmWebService_Service;

/**
 *
 * @author nina & manuela
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
            int user_id = user.getId();
            
            //Prüfung, ob Nutzer noch in Chat eingeloggt, dann ausloggen, weil Chatfenster nicht aktiv
            try{
                ClientInterface userI = (ClientInterface) session.getAttribute("chatUser"); //user aus Session holen
                ChatInterface chat = (ChatInterface) session.getAttribute("chat"); //chat aus Session erholen
                chat.sendMessage(userI.getUsername(), "hat sich ausgeloggt");
                userI.getStub().unsubscribeUser(userI.getUsername());
            }catch(Exception err){
                System.out.println("User nicht im Chat aktiv. Muss nicht ausgeloggt werden.");
            }
            
            //Die verschiedenen Unterhaltungen laden
            java.util.List<webservice.User> conversations = showConversations(user_id);
            session.setAttribute("conversations", conversations);
            
            //Schauen ob es neue Nachrichten gibt:
            java.util.List<webservice.User> anyNewMessages = anyNewMessages(user_id);
            session.setAttribute("anyNewMessages", anyNewMessages);
            
            //Weiterleitung zu "inbox.jsp", um die verschiedenen Gesprächspartner anzuzeigen
            RequestDispatcher rd = request.getRequestDispatcher("inbox.jsp");
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

    private java.util.List<webservice.User> showConversations(int userId) {
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.showConversations(userId);
    }

    private java.util.List<webservice.User> anyNewMessages(int userId) {
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.anyNewMessages(userId);
    }

}
