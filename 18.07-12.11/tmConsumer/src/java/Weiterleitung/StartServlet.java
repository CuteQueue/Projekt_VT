/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Weiterleitung;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
* <h1>StartServlet</h1>
* Das StartServlet holt sich aus den Formulardaten der index.jsp
* die angegebene Host-IP, legt eine Session und das Session-Attribut 
* "serverIp" an und leitet auf den Loginbereich des gewählten Servers weiter.
* <p>
* <b>Note:</b>Bei einer festen Serververgabe wäre dieser Schritt überflüssig,
* er dient vorrangig zur angenehmeren Handhabung in der Testumgebung bei Serverwechseln.
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/

public class StartServlet extends HttpServlet {

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
        String serverIp = "";
        try (PrintWriter out = response.getWriter()){
            serverIp = request.getParameterValues("serverIp")[0];
            session.setAttribute("serverIp", serverIp);
            
            //Einsetzen der gewählten ServerIP und weiterleiten an geänderte Adresse
            out.println("<meta http-equiv=\"refresh\" content=\"0;URL=http://"+session.getAttribute("serverIp")+":8080/tmConsumer/toLogin\">");  
        }catch(Exception errStartServlet1){
            System.out.println("Error Startservlet");
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
