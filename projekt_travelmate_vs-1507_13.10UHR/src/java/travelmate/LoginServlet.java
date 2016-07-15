/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package travelmate;
import users_profils.*;
import users_profils.service.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet  {
    //ServerInterface stub;
    
    String buffer [] = new String[10]; 
    String post = "hund";
    String ausgabe = "";
    //String name;
    String vorhanden ="";
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException, RemoteException, NotBoundException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String email;
        String pw;
        String validated = "false";
        
            String msg = "Moin moin";
           
            // Neue Session anlegen
            HttpSession session = req.getSession(true); //Erzeugt eine neue Session, wenn noch keine vorhanden und speichert diese in session
            
            
            //email des Nutzers
            try{
                //Wird beim ersten Aufruf aufgerufen
                email = req.getParameterValues("email")[0]; //wird aus Eingabe gelesen
                 session.setAttribute("email", email); //in Session gespeichert
            } catch (Exception ex){
                //Wird beim refresh aufgerufen
                email = (String) session.getAttribute("email"); //wird aus Session gelesen
            }
            
            //passwort des Nutzers
             try{
                //Wird beim ersten Aufruf aufgerufen
                pw = req.getParameterValues("pw")[0];
                session.setAttribute("pw", pw);
            } catch (Exception ex){
                //Wird beim refresh aufgerufen
                pw = (String) session.getAttribute("pw");
            }

            
            TravelMate tm = new TravelMate(); 

            try {
            out.println("1");
            String emailVergleich = tm.user.getEmail();
            out.println("2");
            out.println(emailVergleich);

            if(emailVergleich.equals(email)){
                session.setAttribute("tm", tm); //in Session speichern
                validated = "true";
            }
            } catch(Exception Err) {
                out.printf("Error85");
                out.close();
            }
            //Prüfung ob der Nickname schon vergeben ist:
            if(validated.equals("true")){
                out.println("<html><head><body>");
                out.print("<form action=\"");
                out.print(res.encodeURL ("home"));
                out.println("\" method=\"POST\" >");
                out.println("<h2>Willkommen auf der Homeseite</h2>");
                out.println("</form></body></html>");
                out.close();
            
                
           
            } else {
                


                /*----------------------------HTM-Teil----------------------------*/
                out.println("<html><head><title>Chat</title>");
                out.println("<meta http-equiv=\"refresh\" content=\"text/html; charset=utf-8;URL=\"http://localhost:8080/projekt_travelmate_vs/home\"></head>"); 
                //auf Servlet weiterleiten
                out.println("<body style=\"font-family:arial;\">\n");
               out.println("<h2>Willkommen im Chat, " + tm.user.getName()
                        + "!</h2>");
               
  
                //Eingabefeld für die Nachricht
                out.print("<form action=\"");
                out.print(res.encodeURL ("home")); //damit das Session-Tracking auch funktioniert, wenn Cookies deaktiviert sind
                out.println("\" method=\"POST\" >");
                out.println("<h3>Nachricht hier:</h3>");
                out.println("<input type=\"hidden\" name=\"name\" value="+tm.user.getName()+">");
                out.println("<input type=\"text\" name=\"message\">");
                out.println("<br><br><input type=\"submit\" value=\"Abschicken\">");
                out.println("</form>");

                //Chatfenster
                out.println("<textarea name=\"chatoutput\" cols=\"50\" rows=\"10\"readonly>");
                
                out.println("</textarea>");

                //Button zum Verlassen des Chats
                out.println("</br>");
                out.print("<form action=\"http://www.google.de\"");
                out.println("\" method=\"POST\" >");
                out.println("<br><br><input type=\"submit\" value=\"Chat verlassen\">");
                out.println("</body></html>");
                out.println("</form>");
                
                
                //Ende HTML-Teil
                out.println("</body></html>");
                /*if (vorhanden.equals("nein")){
                    out.println("<meta http-equiv=\"refresh\" content=\"1;URL=http://localhost:8080/webChat/Servlet\">"); 
                    //auf Servlet weiterleiten
                }vorhanden = "";*/
            }  

            
            
        } 
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RemoteException {
        try {
            processRequest(request, response);
        } catch (NotBoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            throws ServletException, IOException, RemoteException {
        try {
            processRequest(request, response);
            
        } catch (NotBoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

