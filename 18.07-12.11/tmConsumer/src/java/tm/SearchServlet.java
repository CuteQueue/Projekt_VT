/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

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
            response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
            response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
            response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {

                HttpSession session = request.getSession(true);
                if (session.getAttribute("email") == null) {
                    out.println("<html><head><title>SessionError</title></head>");
                    out.println("<body><h2>Keine Session vorhanden</h2>");
                    //out.print("<form action=\"http://"+session.getAttribute("ip")+":8080/webChat\"");
                    out.print("<form action=\"http://"+session.getAttribute("serverIp")+":8080/tmConsumer\"");
                    out.println("\" method=\"POST\" >");
                    out.println("<br><br><input type=\"submit\" value=\"Startseite\">");
                    out.println("</form>");
                    out.println("</body>");
                    out.close();
                    return;
                }
                String email = (String) session.getAttribute("email");
                User u = new User(email);
                session.setAttribute("user", u); //in Session gespeichert 
                User user = (User) session.getAttribute("user");

                System.out.println("SearchServlet");

                String destination = request.getParameterValues("Destination")[0];
                String gender = request.getParameterValues("Gender")[0];
                
                //Change destinaton:
                out.print("<form action=\"search.jsp");
                out.println("\" method=\"POST\" >");
                out.println("<input type=\"submit\" name=\"search\" value=\"Change Destination\">");
                out.println("</form>");
                
                //Angebene Destination:
                out.println("</br><h2> Destination: " +destination + "</h2>");
                

              //  out.println("Gender: " + gender);
              
              
              
              //TODO:
                if (gender.equals("both")){
                    
                }
                
                /*---------------Find TravelMates--------------------------------------------------------------
                - Die Methode findTravelmates() gibt eine Liste mit Objekten von User zurück, die zu den
                gesuchten Vorgaben passen
                - Diese werden dann mit in einer Liste ausgeben, um dann die Möglichkeit zu haben auf das Profil
                weitergeleitet zu werden
                */
                
               java.util.List<webservice.User> travelmates = findTravelmates(destination, gender); //Aufruf der webService Methode 
                
                //Ausgabe der potenziellen Travelmates
                out.println("<ul>");
                for (int i = 0; i < travelmates.size(); i++){
                    out.println("</br>");
                    out.println("<li>"+travelmates.get(i).getName() + " " + travelmates.get(i).getLastName()+"</br>");
                    out.println("Looking for: " + travelmates.get(i).getLookingFor() + "</br>");
                    out.println(" <a href=\"Home\" target=\"_blank\">profile</a>");
                    out.println("</li>");
                    out.println("</br>");
                }
                out.println("</ul>");
              
              // out.println(answer);
              /*  if (answer.equals("ok")) {
                    request.getRequestDispatcher("/Home").forward(request, response);
                    //response.sendRedirect("Home");
                } else {
                    out.println("Ooooops, something went wrong!");
                }*/
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
