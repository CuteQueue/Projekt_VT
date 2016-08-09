/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuela
 */
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
            
            
            //IP des Nutzers
            try{
                //Wird beim ersten Aufruf aufgerufen
                ip = req.getParameterValues("serverIp")[0]; //wird aus Eingabe gelesen
                session.setAttribute("ip", ip); //in Session gespeichert
            } catch (Exception ex){
                //Wird beim refresh aufgerufen
                ip = (String) session.getAttribute("serverIp"); //wird aus Session gelesen
                session.setAttribute("ip", ip);
                System.out.println("IP aus Session geholt.");
            }
            
            //Name des Nutzers
             try{
                //Wird beim ersten Aufruf aufgerufen
                name = (String) session.getAttribute("nickname");
                //name = req.getParameterValues("name")[0];
                session.setAttribute("name", name);
                System.out.println("nickname aus Session geholt.");
            } catch (Exception ex){
                //Wird beim refresh aufgerufen
                name = (String) session.getAttribute("nickname");
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
                
                /*out.println("<html><head><body>");
                out.print("<form action=\"");
                out.print(res.encodeURL ("tmChatOn"));
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
                }*/
           
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
                out.println("<html><head><title>Chat</title>");
                out.println("<meta http-equiv=\"refresh\" content=\"10;URL=\"http://"+session.getAttribute("ip")+":8080/tmConsumer/tmChatOn>");
                out.println("<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n" +
                "\n" +
                "    <!-- Bootstrap -->\n" +
                "    <!-- Latest compiled and minified CSS -->\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "    <!-- Optional theme -->\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "    <!-- Latest compiled and minified JavaScript -->\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script></head>\n");
                out.println("<style>textarea {resize: none;}</style>");

                out.println("<body>\n" +
                "      <div>\n" +
                "        <nav class=\"navbar navbar-default\">\n" +
                "          <div class=\"container-fluid\">\n" +
                "            <!-- Brand and toggle get grouped for better mobile display -->\n" +
                "            <div class=\"navbar-header\">\n" +
                "              <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n" +
                "              </button>\n" +
                "              <a class=\"navbar-brand\" href=\"toHome\">TravelMate</a>\n" +
                "            </div>\n" +
                "            <!-- Collect the nav links, forms, and other content for toggling -->\n" +
                "            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
                "              <ul class=\"nav navbar-nav\">\n" +
                "                <li><a href=\"toHome\">Profile</a></li>\n" +
                "                <li><a href=\"toSearch\">Search</a></li>\n" +
                "                <li><a href=\"Inbox\">Messages</a></li>\n" +
                "                <li class=\"active\"><a href=\"tmChat\">Chat<span class=\"sr-only\">(current)</span></a></li>\n" +
                "              </ul>\n" +
                "              <ul class=\"nav navbar-nav navbar-right\">\n" +
                "                <li><a href=\"Logout\"><span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span> Logout</a></li>\n" +
                "              </ul>\n" +
                "            </div><!-- /.navbar-collapse -->\n" +
                "          </div><!-- /.container-fluid -->\n" +
                "        </nav>\n" +
                "       </div>     ");

                out.println("<div class=\"fixed-bg container\">\n" +
    "              <div class=\"row center-me profilesheet\" >\n" +
    "                <div class=\"col-xs-12 col-sm-5 col-md-5 abstand\">");

                out.println("<h2>Willkommen im Chat, " + user.getUsername()
                        + "!</h2>");

                
                //Chatfenster und Client-Ausgabeliste
                out.println("<div>\n" +
                "               <table>\n" +
                "                   <td>\n" +
                "                       <textarea name=\"chatoutput\" id =\"chatWindow\" cols=\"100\" rows=\"20\" readonly=\"\">");
                                            List <String> chatAusgabe = user.getAusgaben();
                                            for (String nachricht : chatAusgabe) {
                                                out.println(nachricht + "\n");
                                            }
                            out.println("</textarea>\n" +
                            "       </td>\n" +
                            "	<td>\n" +
                            "           <textarea name=\"clientsOnline\" cols=\"15\" rows=\"20\" readonly=\"\">");
                                            Set<String> clientsOnline = user.getStub().getClients().keySet();
                                            for ( String key : clientsOnline ) {
                                                out.println( key );
                                            }
                            out.println("</textarea>\n" +
                            "       </td>\n" +
                            "   </table>\n" +
                            "</div>");

                //Eingabefeld für die Nachricht
                out.print("<form action=\"");
                out.print(res.encodeURL ("tmChatOn")); //damit das Session-Tracking auch funktioniert, wenn Cookies deaktiviert sind
                out.println("\" method=\"POST\" >");
                out.println("<h3>Nachricht hier:</h3>");
                out.println("<input type=\"hidden\" name=\"name\" value="+user.getUsername()+">");
                out.println("<div>\n" +
                            "	<td>\n" +
                            "		<input vk_13ff6=\"subscribed\" size=\"50\" name=\"message\" type=\"text\">\n" +
                            "	</td>\n" +
                            "	<td>\n" +
                            "		<input value=\"Abschicken\" type=\"submit\">\n" +
                            "	</td>\n" +
                            "</div>\n" +
                            "</form>");
                
                
                //Ende HTML-Teil
                out.println("</body></html>");
                if (vorhanden.equals("nein")){
                    out.println("<meta http-equiv=\"refresh\" content=\"0;URL=http://"+session.getAttribute("serverIp")+":8080/tmConsumer/tmChatOn\">"); 
                    //auf Servlet weiterleiten
                }vorhanden = "";
            

            
            
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

