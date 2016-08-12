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
            HttpSession session = req.getSession(true); //Liefert null zurück, wenn es keine aktuelle Session gibt
            if(session.getAttribute("email")==null) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('No valid session.');");
                out.println("location='http://"+session.getAttribute("serverIp")+":8080/tmConsumer/toLogin\';");
                out.println("</script>");   
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
            out.println("<head>\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta http-equiv=\"refresh\" content=\"10;URL=\"http://"+session.getAttribute("ip")+":8080/tmConsumer/tmChatOn\">\n"+
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <meta http-equiv=\"Pragma\" content=\"no-cache\">\n" +
                "    <meta http-equiv=\"Expires\" content=\"-1\">\n" +
                "    <title>TravelMate</title>\n" +
                "    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
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
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n" +
                "\n" +
                "   \n" +
                "    <link rel=\"stylesheet\" href=\"css/css02.css\" type=\"text/css\">\n" +
                "    \n" +
                "    \n" +
                "    </head>");
            
                //Scrollbalken des Chatfensters immer unten
                out.println("<script>\n" +
                        "window.onload = load;\n" +
                        "function load(){\n" +
                        "	var chatWindow = document.getElementById(\"chatWindow\");\n" +
                        "	chatWindow.scrollTop = chatWindow.scrollHeight;\n" +
                        "};\n" +
                        "</script>");
                
                out.println("<style>textarea {resize: none;}"+
                        ".responsive-input{width: 100%;}" +
                        "</style>");

                out.println("<body>\n" +
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
                "                <li><a href=\"toProfil\">Profile</a></li>\n" +
                "                <li><a href=\"toSearch\">Search</a></li>\n" +
                "                <li><a href=\"Inbox\">Messages</a></li>\n" +
                "                <li class=\"active\"><a href=\"tmChat\">Chat<span class=\"sr-only\">(current)</span></a></li>\n" +
                "              </ul>\n" +
                "              <ul class=\"nav navbar-nav navbar-right\">\n" +
                "                <li><a href=\"Logout\"><span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span> Logout</a></li>\n" +
                "              </ul>\n" +
                "            </div><!-- /.navbar-collapse -->\n" +
                "          </div><!-- /.container-fluid -->\n" +
                "        </nav>");

 
                
                out.println("<div class=\"fixed-bg container\">\n" +
                "            <div class=\"row center-me profilesheet\" style=\"max-width:1000px;min-height:400px;\">");
                
                out.println("<div class=\"col-xs-12 col-sm-12\">\n" +
                "             <div class=\"text-center\">");

                out.println("<h3>Willkommen, " + user.getUsername()
                        + "!</h3>");

                
                //Chatfenster und Client-Ausgabeliste
                out.println("<div class=\"col-xs-9 col-sm-9 col-md-9 text-center\" style=\"padding:0;\">\n" +

                "           <textarea name=\"chatoutput\" class=\"responsive-input\" id =\"chatWindow\" cols=\"100\" rows=\"15\" readonly=\"\">");
                                List <String> chatAusgabe = user.getAusgaben();
                                for (String nachricht : chatAusgabe) {
                                    out.println(nachricht + "\n");
                                }
                            out.println("</textarea>\n" +
                            "       </div>\n" +
                            "<div class=\"col-xs-3 col-sm-3 col-md-3 text-center\" style=\"padding:0;\">\n" +
                            "           <textarea name=\"clientsOnline\" cols=\"15\" rows=\"15\" class=\"responsive-input\" readonly=\"\">");
                                            Set<String> clientsOnline = user.getStub().getClients().keySet();
                                            for ( String key : clientsOnline ) {
                                                out.println( key );
                                            }
                            out.println("</textarea>\n" +
                            "</div>");

                //Eingabefeld für die Nachricht
                out.println("<div class=\"col-xs-9 col-sm-9 col-md-9 text-center\" style=\"margin-top:15px;padding:0;\">\n");
                    out.print("<form action=\"");
                    out.print(res.encodeURL ("tmChatOn")); //damit das Session-Tracking auch funktioniert, wenn Cookies deaktiviert sind
                    out.println("\" method=\"POST\" >");
                    out.println("<input type=\"hidden\" name=\"name\" value="+user.getUsername()+">");
                    out.println("<input vk_13ff6=\"subscribed\" class=\"form-control\" name=\"message\" placeholder=\"your message...\" type=\"text\">\n" +
                                "</div>\n"+
                                "<div class=\"col-xs-3 col-sm-3 col-md-3\" text-center\" style=\"margin-top:15px;padding:0;\">\n"+
                                "<input value=\"send\" class=\"form-control\" type=\"submit\">\n" +
                                "</div>\n" +
                                "</form>\n"+
                            
                "</div");
                    
                out.println("</div></div></div></div>");
                
                try{
                    msg = req.getParameterValues("message")[0]; //eingebene Nachricht in msg speichern
                    out.println("<meta http-equiv=\"refresh\" content=\"0; URL=http://"+session.getAttribute("ip")+":8080/tmConsumer/tmChatOn\">");
                }catch(Exception ex){
                    msg = " "; 
                }
                 if(!msg.equals(" ")){
                    //user.getStub().ausgabeHinzu(user.getUsername() + ": " + msg); //Name des Users + seine Nachricht zur ausgaben-Liste hinzufügen
                    chat.sendMessage(user.getUsername(), msg); //Nachricht senden
                    msg="";
                }
            
             
            //Ende HTML-Teil
            out.println("</div>\n" +
            "            </div>\n" +
            "            </div>");
            out.println("</body></html>");
            
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