package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"Pragma\" content=\"no-cache\">\n");
      out.write("        <meta http-equiv=\"Expires\" content=\"-1\">\n");
      out.write("        <title>TravelMate</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css01.css\" type=\"text/css\">\n");
      out.write("        \n");
      out.write("        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("    \n");
      out.write("        <script>\n");
      out.write("            function meldung(){\n");
      out.write("              alert(\"Welcome to TravelMate!\\nLogin and let the adventure begin!\");\n");
      out.write("              location= window.location.href='toLogin';\n");
      out.write("            };\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <!--Abfrage, ob Session gültig ist, sonst kein Zugriff auf create.jsp-->\n");
      out.write("    ");
 HttpSession nsession = request.getSession(true);
        if(nsession.getAttribute("registered")!=null) {
            nsession.removeAttribute("registered");
            
      out.write("<script>meldung();</script>");
  
        } 
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"fixed-bg\">\n");
      out.write("        <div class=\"parent\">\n");
      out.write("          <div class=\"child container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-xs-12 col-sm-12 text-center\">\n");
      out.write("                    <img src=\"images/TravelMateLogo.png\" style=\"max-width:300px;padding-bottom:15pt;\"> \n");
      out.write("                </div>\n");
      out.write("              <div class=\"col-xs-12 col-sm-12 text-center\">\n");
      out.write("                <div class=\"panel panel-default center-me\" style=\"max-width:300px;\">\n");
      out.write("                  <!-- Default panel contents -->\n");
      out.write("                  <div class=\"panel-heading\">Login</div>\n");
      out.write("                    <form class=\"form-horizontal\" action=\"Login\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                        <input type=\"hidden\" name=\"serverIp\" id=\"serverIp\" >            \n");
      out.write("                        <br>\n");
      out.write("                        Email:\n");
      out.write("                        <input type=\"text\" name=\"email\" style=\"margin-bottom:15px; margin-left:25px\"><br>\n");
      out.write("                        Password:\n");
      out.write("                        <input type=\"password\" name=\"pw\">\n");
      out.write("                        <br><br>\n");
      out.write("                        <input type=submit class=\"btn btn-primary btn-s\" value=\"Submit\">\n");
      out.write("                        <input type=\"button\" class=\"btn btn-primary btn-s\" onclick=\"window.location.href='toRegister'\" value=\"Register\" name=\"button\" id=\"button\"/>​<br>\n");
      out.write("                        <input type=\"button\" class=\"btn btn-default btn-xs\" style=\"margin-top:15px;\" onclick=\"window.location.href='Index'\" value=\"Change Server-IP\" name=\"button\" id=\"button\"/>​ \n");
      out.write("                        <br><br>\n");
      out.write("                      </div>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    <script>\n");
      out.write("                        function getLocation() {\n");
      out.write("                            //alert(window.location.href);\n");
      out.write("                            var href = window.location.href ;\n");
      out.write("                            var l = document.createElement(\"a\");\n");
      out.write("                            l.href = href;\n");
      out.write("                            //alert(l.hostname);\n");
      out.write("                            return l.hostname;\n");
      out.write("                        };\n");
      out.write("                        document.getElementById(\"serverIp\").value = getLocation();\n");
      out.write("                        localStorage.clear();\n");
      out.write("                    </script>\n");
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
      out.write("       \n");
      out.write("        <!--<script>\n");
      out.write("            function getLocation() {\n");
      out.write("                //alert(window.location.href);\n");
      out.write("                var href = window.location.href ;\n");
      out.write("                var l = document.createElement(\"a\");\n");
      out.write("                l.href = href;\n");
      out.write("                //alert(l.hostname);\n");
      out.write("                return l.hostname;\n");
      out.write("            };\n");
      out.write("            document.getElementById(\"serverIp\").value = getLocation();\n");
      out.write("        </script>-->\n");
      out.write("       \n");
      out.write("       <!--LOCALSTORAGE abfragen-->\n");
      out.write("       <!-- <script>\n");
      out.write("            function load(){\n");
      out.write("                alert(localStorage.getItem('serverIp'));\n");
      out.write("                var serverIp = localStorage.getItem('serverIp');\n");
      out.write("                return serverIp;\n");
      out.write("            };\n");
      out.write("            document.getElementById(\"serverIp\").value = load();  \n");
      out.write("       </script>-->\n");
      out.write("       \n");
      out.write("\n");
      out.write("<!-- Umleitung bei Nutzung des Back-Buttons\n");
      out.write("<script>\n");
      out.write("    (function(window, location) {\n");
      out.write("        var href = window.location.href ;\n");
      out.write("        var l = document.createElement(\"a\");\n");
      out.write("        l.href = href;\n");
      out.write("        var host = l.hostname;\n");
      out.write("        var hash = l.h\n");
      out.write("        \n");
      out.write("        history.replaceState(null, document.title, location.pathname+\"#!/history\");\n");
      out.write("        history.pushState(null, document.title, location.pathname);\n");
      out.write("\n");
      out.write("        window.addEventListener(\"popstate\", function() {\n");
      out.write("          if(location.hash === \"#!/history\") {\n");
      out.write("            history.replaceState(null, document.title, location.pathname);\n");
      out.write("            setTimeout(function(){\n");
      out.write("              location.replace(\"http://\"+host+\":8080/tmConsumer#nosession\");\n");
      out.write("            },0);\n");
      out.write("          }\n");
      out.write("        }, false);\n");
      out.write("    }(window, location));\n");
      out.write("</script>-->\n");
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
