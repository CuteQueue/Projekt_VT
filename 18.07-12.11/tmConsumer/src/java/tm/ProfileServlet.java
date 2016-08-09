/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nina
 */
public class ProfileServlet extends HttpServlet {

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

            System.out.println("ProfileServlet");

            //--------Passende Userdaten holen ----------------------------------
            String email = request.getParameterValues("email")[0];
            User u = new User(email);
            u.getProfileData(); //Profildaten holen

            out.println("<h2>Profil von " + u.getName() + " " + u.getLast_name() + "</h2>");
            out.println("</br>");

            //-------------Ausgabe der Profildaten---------------------------
            out.println("Location: " + u.getLocation() + "</br>");
            out.println("Age: " + u.getAge() + "</br>");
            out.println("Destination: " + u.getDestination() + "</br>");
            out.println("Startdate: " + u.getStartdate() + "</br>");
            out.println("Interests: " + u.getInterests() + "</br>");
            out.println("Looking for: " + u.getLooking_for() + "</br>");
            out.println("About: " + u.getAbout() + "</b>");
            out.println("</br></br>");
            out.println("Contact details: " + "</br>");
            out.println("Email: " + u.getEmail());

            out.println(" <form action=\"newMessage.jsp\" method=\"POST\">");
           // out.println(" <input type=\"hidden\" name=\"chatPartnerId\" value=\"" + u.getId() + "\">");
            //out.println(" <input type=\"hidden\" name=\"chatPartnerName\" value=\"" + u.getName() + "\">");
            session.setAttribute("chatPartnerId", u.getId());
            session.setAttribute("chatPartnerName", u.getName());
            out.println(" <input type=submit value=\"Send Message\"></form>");

            /* session.setAttribute("chatPartnerId", u.getId()); 
            session.setAttribute("chatPartnerName", u.getName()); 
          
            out.println(" <form action=\"newMessage.jsp\" method=\"POST\">");            
            out.println(" <input type=submit value=\"Send Message\"></form>");*/
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
