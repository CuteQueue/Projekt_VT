package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.io.IOException;
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
import Chat.ChatInterface;
import Chat.ClientInterface;
import Chat.ServerInterface;

public final class chat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <style>\n");
      out.write("        input[type=number] {\n");
      out.write("            -moz-appearance: textfield;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"Pragma\" content=\"no-cache\">\n");
      out.write("        <meta http-equiv=\"Expires\" content=\"-1\">\n");
      out.write("        <title>TravelMate</title>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css01.css\" type=\"text/css\">\n");
      out.write("        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("  \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function meldung(){\n");
      out.write("              alert(\"No valid session, please login!\");\n");
      out.write("              location= window.location.href='Index';\n");
      out.write("            };    \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <!--Abfrage, ob Session gültig ist, sonst kein Zugriff auf create.jsp-->\n");
      out.write("    ");
 HttpSession nsession = request.getSession(true);
        if(nsession.getAttribute("email")==null) {
            
      out.write("<script>meldung();</script>");
     
        } 
      out.write("\n");
      out.write("            \n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("          <div class=\"container-fluid\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("              <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("              </button>\n");
      out.write("              <a class=\"navbar-brand\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/toHome\">TravelMate</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("              <ul class=\"nav navbar-nav\">\n");
      out.write("                <li class=\"active\"><a href=\"#\">Profile<span class=\"sr-only\">(current)</span></a></li>\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/toSearch\">Search</a></li>\n");
      out.write("                <li><a href=\"#\">Messages</a></li>\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/toChat\">Chat</a></li>\n");
      out.write("              </ul>\n");
      out.write("              <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Logout\"><span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span> Logout</a></li>\n");
      out.write("              </ul>\n");
      out.write("            </div><!-- /.navbar-collapse -->\n");
      out.write("          </div><!-- /.container-fluid -->\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <div class=\"fixed-bg container-fluid\">\n");
      out.write("        <div class=\"parent\">\n");
      out.write("          <div class=\"child\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                \n");
      out.write("              <div class=\"col-xs-12 col-sm-12 text-center\">\n");
      out.write("                <div class=\"panel panel-default center-me\" style=\"max-width:800px;\">\n");
      out.write("                  <!-- Default panel contents -->\n");
      out.write("                  <div class=\"panel-heading\">TravelMate Chat</div>\n");
      out.write("                    \n");
      out.write("                  ");

                      ClientInterface user = (ClientInterface) session.getAttribute("chatUser"); //user aus Session holen
            ChatInterface chat = (ChatInterface) session.getAttribute("chat"); //chat aus Session erholen
            String msg = "Moin moin";
            
      out.write("\n");
      out.write("            \n");
      out.write("            <h2>Willkommen im Chat, \" + user.getUsername()+ \"!</h2>\n");
      out.write("            \n");
      out.write("            <!--Scrollbalken des Chatfensters immer unten-->\n");
      out.write("            <script>window.onload = load;\n");
      out.write("                    function load(){\n");
      out.write("                        var chatWindow = document.getElementById(\"chatWindow\");\n");
      out.write("                        chatWindow.scrollTop = chatWindow.scrollHeight;\n");
      out.write("                    };\n");
      out.write("            </script>\n");
      out.write("            \n");
      out.write("             \n");
      out.write("            <!--Chatfenster und Client-Ausgabeliste-->\n");
      out.write("            <div>\n");
      out.write("                <table>\n");
      out.write("                    <td>\n");
      out.write("                        <textarea name=\"chatoutput\" id =\"chatWindow\" cols=\"100\" rows=\"30\" readonly>\n");
      out.write("                            ");
List <String> chatAusgabe = user.getAusgaben();
                            for (String nachricht : chatAusgabe) {
                                out.println(nachricht + "\n");
                            }
      out.write("\n");
      out.write("                        </textarea>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <textarea name=\"clientsOnline\" cols=\"15\" rows=\"30\" readonly>\n");
      out.write("                            ");
Set<String> clientsOnline = user.getStub().getClients().keySet();
                            for ( String key : clientsOnline ) {
                                out.println( key );
                            }
      out.write("\n");
      out.write("                        </textarea>\n");
      out.write("                    </td>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <!--Eingabefeld für die Nachricht-->\n");
      out.write("            <form action=\"\"  method=\"POST\" >\n");
      out.write("            <h3>Nachricht hier:</h3>\n");
      out.write("            <input type=\\\"hidden\\\" name=\\\"name\\\" value=\"+user.getUsername()+\">\n");
      out.write("            <div>\n");
      out.write("                <td>\n");
      out.write("                    <input vk_13ff6=\\\"subscribed\\\" size=\\\"50\\\" name=\\\"message\\\" type=\\\"text\\\">\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input value=\\\"Abschicken\\\" type=\\\"submit\\\">\n");
      out.write("                </td>\n");
      out.write("            </div>\n");
      out.write("            </form>\n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              <!-- Optional: clear the XS cols if their content doesn't match in height -->\n");
      out.write("              <div class=\"col-xs-12 col-sm-12 text-center\"></div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("      </body>\n");
      out.write("    </html>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
