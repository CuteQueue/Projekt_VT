/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import Chat.ChatInterface;
import Chat.ClientInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservice.TmWebService_Service;

/**
 *
 * @author nina
 */
public class SearchServlet extends HttpServlet {

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
            User user = (User) session.getAttribute("user");

            //----------Falls keine Session vorhanden-----------------------------------------
            if (session.getAttribute("email") == null) {
                out.println("<html><head><title>SessionError</title></head>");
                out.println("<body><h2>Keine Session vorhanden</h2>");
                out.print("<form action=\"http://" + session.getAttribute("serverIp") + ":8080/tmConsumer\"");
                out.println("\" method=\"POST\" >");
                out.println("<br><br><input type=\"submit\" value=\"Startseite\">");
                out.println("</form>");
                out.println("</body>");
                out.close();
                return;
            }

            try{
                ClientInterface userI = (ClientInterface) session.getAttribute("chatUser"); //user aus Session holen
                ChatInterface chat = (ChatInterface) session.getAttribute("chat"); //chat aus Session erholen
                String ipSession = (String) session.getAttribute("ip");
                chat.sendMessage(userI.getUsername(), "hat sich ausgeloggt");
                userI.getStub().unsubscribeUser(userI.getUsername());
            }catch(Exception err){
                System.out.println("User nicht im Chat aktiv. Muss nicht ausgeloggt werden.");
            }
            
            //In search.jsp ausgewählte Parameter
            String destination = request.getParameterValues("Destination")[0];
            String gender = request.getParameterValues("Gender")[0];

            //Button "New Search":
            out.print("<form action=\"search.jsp");
            out.println("\" method=\"POST\" >");
            out.println("<input type=\"submit\" name=\"search\" value=\"New Search\">");
            out.println("</form>");

            //Ausgewählte Destination:
            out.println("</br><h2> Destination: " + destination + "</h2>");

            /*---------------Find TravelMates--------------------------------------------------------------
                - Die Methode findTravelmates() gibt eine Liste mit Objekten von User zurück, die zu den
                gesuchten Vorgaben passen
                - Diese werden dann mit in einer Liste ausgeben, um dann die Möglichkeit zu haben auf das Profil
                weitergeleitet zu werden
             */
            
            java.util.List<webservice.User> travelmates = findTravelmates(destination, gender); //Aufruf der webService Methode 

            //Ausgabe der potenziellen Travelmates
            out.println("<ul>");
            for (int i = 0; i < travelmates.size(); i++) {
                
                //Damit der aktuelle User nicht selbst bei der Suche ausgeben wird:
                if (travelmates.get(i).getUserId() != user.getId()) { 
                

                    out.println("</br>");
                    out.println("<li>" + travelmates.get(i).getName() + " " + travelmates.get(i).getLastName() + "</br>");
                    out.println("Looking for: " + travelmates.get(i).getLookingFor() + "</br>");
                    out.println("Startdate: " + travelmates.get(i).getStartdate() + "</br>");
                    out.println(" <form action=\"Profile\" method=\"POST\">");
                    out.println(" <input type=\"hidden\" name=\"email\" value=\"" + travelmates.get(i).getEmail() + "\">");
                    out.println(" <input type=submit value=\"Show Profile\">\n"
                            + "        </form>");
                    out.println("</li>");
                    out.println("</br>");
                }
            }
            out.println("</ul>");
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

    private java.util.List<webservice.User> findTravelmates(java.lang.String destination, java.lang.String gender) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.findTravelmates(destination, gender);
    }

}
