/**
* <h1>tmChatServlet</h1>
* Servlet legt bei valider Session Session-Attribute
* für die spätere Handhabung des Chats im tmChatOn-Servlet an
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class tmChatServlet extends HttpServlet {
    ServerInterface stub;
    
    String buffer [] = new String[10]; 
    String post = "";
    String ausgabe = "";
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
        String ip;
        String name;
        
        try {
            String msg = "Moin moin";
           
            // Neue Session anlegen
            
            HttpSession session = req.getSession(true); //Erzeugt eine neue Session, wenn noch keine vorhanden und speichert diese in session
            if(session.getAttribute("email")==null) {
                out.println("<script>function meldung(){alert(\\\"No valid session, please login!\\\"); location= window.location.href='Index';};</script>");
            } 
            
            //IP des Nutzers
            try{
                ip = (String) session.getAttribute("serverIp"); //wird aus Session gelesen
                session.setAttribute("ip", ip);
                System.out.println("IP aus Session geholt.");
            } catch (Exception ex){
                System.out.println("error tmChat ip");
                session.setAttribute("ip", null);
                ip = (String)session.getAttribute("ip");
            }
            
            //Name des Nutzers
             try{
                //Wird beim ersten Aufruf aufgerufen
                name = (String) session.getAttribute("nickname");
                System.out.println("nickname aus Session geholt.");
            } catch (Exception ex){
                //Wird beim refresh aufgerufen
                name = "noNameFound";
                System.out.println("nickname konnte nicht gefunden werden.");
            }

            
            ClientInterface user = null; 
            try {
            user = new ClientImpl(ip); //neuen User erstellen
            System.out.println("neuer ChatUser erstellt");
            session.setAttribute("chatUser", user); //in Session speichern
            System.out.println("ChatUser in Session gespeichert.");
            } catch (RemoteException | MalformedURLException | NotBoundException ex) {
                out.printf("Server nicht erreichbar");
                out.close();
            }
            //Prüfung ob der Nickname schon vergeben ist:
            if(user.getStub().getClients().containsKey(name)){ 
                System.out.println("if(user.getStub().getClients().containsKey(name))");
                vorhanden = "ja";
                System.out.println("Nickname aus Clientliste werfen, weil nicht korrekt ausgeloggt.");
                user.getStub().unsubscribeUser(name);
                
            } 
                user.setUsername(name); //Usernamen festlegen
                ChatInterface chat = user.getStub().subscribeUser(user.getUsername(), user); //User beim Chat anmelden
                
                if (session.isNew()){ //Damit "User hat sich eingeloggt" nicht mehrfach ausgeben wird
                    chat.sendMessage(user.getUsername(),"hat sich eingeloggt.");
                }
                System.out.println("bevor chat in session gespeichert wird");
                session.setAttribute("chat", chat); //Chat in Session speichern
                 System.out.println("nachdem chat in session gespeichert wird");


                /*----------------------------HTML-Teil----------------------------*/
                
                
                //auf Servlet weiterleiten
                out.println("<meta http-equiv=\"refresh\" content=\"0;URL=http://"+session.getAttribute("serverIp")+":8080/tmConsumer/tmChatOn\">"); 
                    
           
    
        } finally {            
            out.close();
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
            Logger.getLogger(tmChatServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tmChatServlet.class.getName()).log(Level.SEVERE, null, ex);
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