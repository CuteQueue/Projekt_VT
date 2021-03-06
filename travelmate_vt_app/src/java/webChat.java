/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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


@WebServlet(name = "webChat", urlPatterns = {"/webChat"})
public class webChat extends HttpServlet  {
    ServerInterface stub;
    
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
        String ip;
        String name;
        
        try {
            String msg = "Moin moin";
           
            // Neue Session anlegen
            HttpSession session = req.getSession(true); //Erzeugt eine neue Session, wenn noch keine vorhanden und speichert diese in session
            
            
            //IP des Nutzers
            try{
                //Wird beim ersten Aufruf aufgerufen
                ip = req.getParameterValues("ip")[0]; //wird aus Eingabe gelesen
                 session.setAttribute("ip", ip); //in Session gespeichert
            } catch (Exception ex){
                //Wird beim refresh aufgerufen
                ip = (String) session.getAttribute("ip"); //wird aus Session gelesen
            }
            
            //Name des Nutzers
             try{
                //Wird beim ersten Aufruf aufgerufen
                name = req.getParameterValues("name")[0];
                session.setAttribute("name", name);
            } catch (Exception ex){
                //Wird beim refresh aufgerufen
                name = (String) session.getAttribute("name");
            }

            
            ClientInterface user = null; 
            try {
            user = new ClientImpl(ip); //neuen User erstellen
            session.setAttribute("user", user); //in Session speichern
            } catch (RemoteException | MalformedURLException | NotBoundException ex) {
                out.printf("Error71");
                out.close();
            }
            //Prüfung ob der Nickname schon vergeben ist:
            if(user.getStub().getClients().containsKey(name)){ 
                vorhanden = "ja";
                out.println("<html><head><body>");
                out.print("<form action=\"");
                out.print(res.encodeURL ("webChat"));
                out.println("\" method=\"POST\" >");
                out.println("<h2>Der Nickname ist bereits vergeben!</h2>");
                out.println("<p>Bitte geben Sie einen neuen Namen ein: <input type=\"text\" name=\"name\"></p>");
                out.println("<input type=\"submit\" name = \"name\" value=\"Abschicken\">");
                out.println("</form></body></html>");
                out.close();
               
                name = req.getParameterValues("name")[0];
                if (!user.getStub().getClients().containsKey(name)){
                    vorhanden = "nein";
                    
                    session.setAttribute("name", name);
                }
           
            } else {
                vorhanden = "nein";
                user.setUsername(name); //Usernamen festlegen
                ChatInterface chat = user.getStub().subscribeUser(user.getUsername(), user); //User beim Chat anmelden
                
                if (session.isNew()){ //Damit "User hat sich eingeloggt" nicht mehrfach ausgeben wird
                    chat.sendMessage(user.getUsername(),"hat sich eingeloggt.");
                }
                session.setAttribute("chat", chat); //Chat in Session speichern


                /*----------------------------HTM-Teil----------------------------*/
                out.println("<html><head><title>Chat</title>");
                out.println("<meta http-equiv=\"refresh\" content=\"10;URL=\"http://localhost:8080/webChat/Servlet\"></head>"); 
                //auf Servlet weiterleiten
                out.println("<body style=\"font-family:arial;\">\n");
               out.println("<h2>Willkommen im Chat, " + user.getUsername()
                        + "!</h2>");
               
  
                //Eingabefeld für die Nachricht
                out.print("<form action=\"");
                out.print(res.encodeURL ("Servlet")); //damit das Session-Tracking auch funktioniert, wenn Cookies deaktiviert sind
                out.println("\" method=\"POST\" >");
                out.println("<h3>Nachricht hier:</h3>");
                out.println("<input type=\"hidden\" name=\"name\" value="+user.getUsername()+">");
                out.println("<input type=\"text\" name=\"message\">");
                out.println("<br><br><input type=\"submit\" value=\"Abschicken\">");
                out.println("</form>");

                //Chatfenster
                out.println("<textarea name=\"chatoutput\" cols=\"50\" rows=\"10\"readonly>");
                List <String> chatAusgabe = user.getAusgaben();
                for (String nachricht : chatAusgabe) {
                    out.println(nachricht + "\n");
                }
                out.println("</textarea>");

                //Button zum Verlassen des Chats
                out.println("</br>");
                out.print("<form action=\"http://localhost:8080/travelmate_vt_app\"");
                out.println("\" method=\"POST\" >");
                out.println("<br><br><input type=\"submit\" value=\"Chat verlassen\">");
                out.println("</body></html>");
                out.println("</form>");
                
                
                //Ende HTML-Teil
                out.println("</body></html>");
                if (vorhanden.equals("nein")){
                    out.println("<meta http-equiv=\"refresh\" content=\"1;URL=http://localhost:8080/travelmate_vt_app/Servlet\">"); 
                    //auf Servlet weiterleiten
                }vorhanden = "";
            }  

            
            
        } finally {
            //out.println("Finally WebChat");
            
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
            Logger.getLogger(webChat.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(webChat.class.getName()).log(Level.SEVERE, null, ex);
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

