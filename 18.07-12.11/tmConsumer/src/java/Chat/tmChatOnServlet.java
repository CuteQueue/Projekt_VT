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
public class tmChatOnServlet extends HttpServlet {
String exit = "";
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException, RemoteException, NotBoundException {
        PrintWriter out = res.getWriter();
           try {
            HttpSession session = req.getSession(false); //Liefert null zurück, wenn es keine aktuelle Session gibt
            session.setMaxInactiveInterval(11);
             if (session == null) {
                out.println("<html><head><title>SessionError</title></head>");
                out.println("<body><h2>Keine Session vorhanden</h2>");
                out.print("<form action=\"http://"+session.getAttribute("ip")+":8080/tmConsumer/Home\"");
                out.println("\" method=\"POST\" >");
                out.println("<br><br><input type=\"submit\" value=\"Startseite\">");
                out.println("</form>");
                out.println("</body>");
                out.close();
                return;
            }
            res.setContentType("text/html;charset=UTF-8");
            System.out.println("Session serverIp: " + session.getAttribute("serverIp"));
            System.out.println("Session Ip: " + session.getAttribute("ip"));
            ClientInterface user = (ClientInterface) session.getAttribute("chatUser"); //user aus Session holen
            ChatInterface chat = (ChatInterface) session.getAttribute("chat"); //chat aus Session erholen
            String msg = "Moin moin";
            try{
                msg = req.getParameterValues("message")[0];
                               
            }catch(Exception ex){
               
                msg = " ";
            }
         
            
            
            /*----------------------------HTML-Teil----------------------------*/
            out.println("<html><head><title>Chat</title>");
            out.println("<meta http-equiv=\"refresh\" content=\"10;URL=\"http://"+session.getAttribute("ip")+":8080/tmConsumer/tmChatOn></head>");
            out.println("<style>textarea {resize: none;}</style>");
            out.println("<body style=\"font-family:arial;\">\n");
            out.println("<h2>Willkommen im Chat, " + user.getUsername()
                    + "!</h2>");
            
            //Scrollbalken des Chatfensters immer unten
            out.println("<script>\n" +
                        "window.onload = load;\n" +
                        "function load(){\n" +
                        "	var chatWindow = document.getElementById(\"chatWindow\");\n" +
                        "	chatWindow.scrollTop = chatWindow.scrollHeight;\n" +
                        "};\n" +
                        "</script>");
            
            
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
            
             try{
                msg = req.getParameterValues("message")[0]; //eingebene Nachricht in msg speichern
                               
            }catch(Exception ex){
               
                msg = " "; 
            }
             if(!msg.equals(" ")){
                //user.getStub().ausgabeHinzu(user.getUsername() + ": " + msg); //Name des Users + seine Nachricht zur ausgaben-Liste hinzufügen
                chat.sendMessage(user.getUsername(), msg); //Nachricht senden
                msg="";
            }
             
            //Chatfenster und Client-Ausgabeliste
            out.println("<div>\n" +
                        "	<table>\n" +
                        "		<td>\n" +
                        "			<textarea name=\"chatoutput\" id =\"chatWindow\" cols=\"100\" rows=\"30\" readonly=\"\">");
            List <String> chatAusgabe = user.getAusgaben();
            for (String nachricht : chatAusgabe) {
                out.println(nachricht + "\n");
            }
            
            out.println("</textarea>\n" +
                        "		</td>\n" +
                        "		<td>\n" +
                        "			<textarea name=\"clientsOnline\" cols=\"15\" rows=\"30\" readonly=\"\">");
            Set<String> clientsOnline = user.getStub().getClients().keySet();
            for ( String key : clientsOnline ) {
                out.println( key );
            }
            out.println("</textarea>\n" +
                        "		</td>\n" +
                        "	</table>\n" +
                        "</div>");
            
            
           
            //Button zum Verlassen des Chats
            out.println("</br>");
            out.print("<form action=\"");
            out.println("\" method=\"POST\" >");
            out.println("<input type=\"submit\" name=\"logout\" value=\"Home\">");
            out.println("</form>");
            
            
             if(exit.equals("exit")){
                String ipSession = (String) session.getAttribute("ip");
                chat.sendMessage(user.getUsername(), "hat sich ausgeloggt");
                user.getStub().unsubscribeUser(user.getUsername());
                exit ="";
                
                //session.invalidate();
                out.println("<meta http-equiv=\"refresh\" content=\"1; URL=http://"+session.getAttribute("ip")+":8080/tmConsumer/Home\">");
            }
             
            //Ende HTML-Teil
            out.println("</body></html>");
            
            } finally {
            //out.print("Finally Servlet");
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
            logout(request, response);
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
    
    public void logout(HttpServletRequest request, HttpServletResponse response) throws RemoteException, IOException{
        PrintWriter out = response.getWriter();
        if (request.getParameter("logout")!=null) {
            HttpSession session = request.getSession();
            ClientInterface user = (ClientInterface) session.getAttribute("chatUser");
            
            exit = "exit";
        }
    }
    
}
