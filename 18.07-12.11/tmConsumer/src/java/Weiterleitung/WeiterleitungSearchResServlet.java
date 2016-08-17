
package Weiterleitung;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservice.TmWebService_Service;

/**
* <h1>WeiterleitungSearchResServlet</h1>
* Das Servlet leitet den User zum searchRes.jsp mit 
* dem Ergebnis der Suche weiter.
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class WeiterleitungSearchResServlet extends HttpServlet {
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
       
        HttpSession session = request.getSession(true);
        
        try (PrintWriter out = response.getWriter()) {
            tm.User user = (tm.User) session.getAttribute("user");
            
            String destination = request.getParameterValues("Destination")[0];
            String gender = request.getParameterValues("Gender")[0];
            //Liste der TravelMates anlegen, für die Angaben "destination" und "gender" übereinstimmen
            java.util.List<webservice.User> travelmates = findTravelmates(destination, gender); //Aufruf der webService Methode 
            session.setAttribute("travelmates", travelmates);
            
            //Weiterleitung zur Ergebnisliste der TravelMate-Suche
            RequestDispatcher rd = request.getRequestDispatcher("searchRes.jsp");
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
    
    /**
   * Bestimmt diejenigen User, die mit den übergebenen Suchkriterien übereinstimmen.
   * 
   *
   * @param destination Reiseziel nach dem die TravelMates gefiltert werden sollen
   * @param gender - Geschlecht, nach dem die TravelMates gefiltert werden sollen
   * 
   * @return eine Liste von Usern, die den Suchkriterien entsprechen
   */
    public java.util.List<webservice.User> findTravelmates(java.lang.String destination, java.lang.String gender) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.findTravelmates(destination, gender);
    }
}
