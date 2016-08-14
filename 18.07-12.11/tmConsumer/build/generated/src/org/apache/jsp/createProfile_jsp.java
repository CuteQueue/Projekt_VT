package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <style>\n");
      out.write("        input[type=number] {\n");
      out.write("            -moz-appearance: textfield;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"Pragma\" content=\"no-cache\">\n");
      out.write("        <meta http-equiv=\"Expires\" content=\"-1\">\n");
      out.write("        <title>TravelMate</title>\n");
      out.write("        \n");
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
      out.write("        <link rel=\"stylesheet\" href=\"css/css02.css\" type=\"text/css\">\n");
      out.write("        \n");
      out.write("        <!--Datepicker für die Datumseingabe anlegen, falls Browser das Eingabeformat date nicht unterstützt-->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var datefield=document.createElement(\"input\");\n");
      out.write("            datefield.setAttribute(\"type\", \"date\");\n");
      out.write("            if (datefield.type!==\"date\"){ //if browser doesn't support input type=\"date\", load files for jQuery UI Date Picker\n");
      out.write("                document.write('<link href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\" />\\n');\n");
      out.write("                document.write('<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js\"><\\/script>\\n');\n");
      out.write("                document.write('<script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js\"><\\/script>\\n'); \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <!--Datepicker initialisieren, falls Browser das Eingabeformat date nicht unterstützt-->\n");
      out.write("        <script>\n");
      out.write("        if (datefield.type!==\"date\"){ \n");
      out.write("            jQuery(function($){ //on document.ready\n");
      out.write("                $('#startdate').datepicker({ dateFormat: 'yy-mm-dd' });\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("        </script>   \n");
      out.write("        \n");
      out.write("        <!--Funktionen store(), load(), meldung(), setStatus(), checkBoxes()-->\n");
      out.write("        <script>\n");
      out.write("            window.onload = load;\n");
      out.write("            var ids = ['mobilenumber', 'age', 'location', 'destination', 'startdate', 'interests', 'looking_for', 'about'];\n");
      out.write("\n");
      out.write("            ///Eingegebene Daten im LocalStorage hinterlegen\n");
      out.write("            function store() {\n");
      out.write("                for (i = 0; i < ids.length; i++) { \n");
      out.write("                    var data = ids[i];\n");
      out.write("                    var value = document.getElementById(data).value;\n");
      out.write("\n");
      out.write("                    localStorage.setItem(data, value);\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            \n");
      out.write("            ///bereits eingegebene Daten aus dem LocalStorage laden\n");
      out.write("            function load(){\n");
      out.write("                for (i = 0; i < ids.length; i++) { \n");
      out.write("                    var data = ids[i];\n");
      out.write("                    var value = localStorage.getItem(data);\n");
      out.write("                    document.getElementById(data).value = value;\n");
      out.write("                }\n");
      out.write("                checkBoxes();\n");
      out.write("            };\n");
      out.write("            \n");
      out.write("            ///Wert für gewählte Checkbox im localStorage setzen\n");
      out.write("            function setStatus() {\n");
      out.write("                if(document.getElementById('female').checked) {\n");
      out.write("                    localStorage.setItem('female', \"store\");\n");
      out.write("                    localStorage.setItem('male', \"unstore\");\n");
      out.write("                } else {\n");
      out.write("                    localStorage.setItem('male', \"store\");\n");
      out.write("                    localStorage.setItem('female', \"unstore\");\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            \n");
      out.write("            ///Checkboxen prüfen und localStorage abfragen\n");
      out.write("            function checkBoxes(){\n");
      out.write("                var getStatus = localStorage.getItem('female');\n");
      out.write("                if (getStatus === \"store\") {\n");
      out.write("                    document.getElementById(\"female\").checked = true;\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"male\").checked = true;\n");
      out.write("                }   \n");
      out.write("            };\n");
      out.write("            \n");
      out.write("            function meldung(){\n");
      out.write("              alert(\"No valid session, please login!\");\n");
      out.write("              location= window.location.href='Index';\n");
      out.write("            };\n");
      out.write("           \n");
      out.write("        </script>\n");
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
      out.write("            <div class=\"navbar-header\">\n");
      out.write("              <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("              </button>\n");
      out.write("              <a class=\"navbar-brand\" href=\"#\">TravelMate</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("              <ul class=\"nav navbar-nav\">\n");
      out.write("                <li class=\"disabled\"><a href=\"#\">Profile<span class=\"sr-only\">(current)</span></a></li>\n");
      out.write("                <li class=\"disabled\"><a href=\"#\">Search</a></li>\n");
      out.write("                <li class=\"disabled\"><a href=\"#\">Messages</a></li>\n");
      out.write("                <li class=\"disabled\"><a href=\"#\">Chat</a></li>\n");
      out.write("              </ul>\n");
      out.write("              <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Logout\"><span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span> Logout</a></li>\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <div class=\"fixed-bg container-fluid\">\n");
      out.write("              <div class=\"row\" >\n");
      out.write("                \n");
      out.write("              <div class=\"col-xs-12 col-sm-12 text-center\">\n");
      out.write("                <div class=\"panel panel-default center-me\" style=\"max-width:300px;\">\n");
      out.write("                  <div class=\"panel-heading\">No profile data found.</div>\n");
      out.write("                    <form action=\"CreateProfile\" method = \"POST\">\n");
      out.write("                        <table border=\"0\" style=\"margin-left:25px; margin-top:15px\">\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Phone:</td>\n");
      out.write("                                    <td><input class=\"formInputRegister\" type=\"number\" name=\"mobilenumber\" id=\"mobilenumber\" onchange=\"store()\" value=\"\" placeholder=\"e.g. 0173XXXXXXXX\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Age:</td>\n");
      out.write("                                    <td><input class=\"formInputRegister\" type=\"number\" name=\"age\" value=\"\" id=\"age\" onchange=\"store()\" placeholder=\"your age\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Location:</td>\n");
      out.write("                                    <td><input class=\"formInputRegister\" type=\"text\" name=\"location\" value=\"\" id=\"location\" onchange=\"store()\" placeholder=\"your current location\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Gender:</td>\n");
      out.write("                                    <td>\n");
      out.write("                                    male\n");
      out.write("                                    <input type=\"radio\" style=\"margin-right:15px;margin-bottom:15px\" class=\"checkboxTypo\" name=\"sex\" value=\"male\" id=\"male\" onclick=\"setStatus()\" checked >\n");
      out.write("                                    female\n");
      out.write("                                    <input type=\"radio\" class=\"checkboxTypo\" name=\"sex\" value=\"female\" id=\"female\" onclick=\"setStatus()\" checked>\n");
      out.write("                                    </td>\n");
      out.write("                                    \n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Destination:</td>\n");
      out.write("                                    <td><input class=\"formInputRegister\" type=\"text\" name=\"destination\" value=\"\" id=\"destination\" onchange=\"store()\" placeholder=\"your travel destination\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Startdate:</td>\n");
      out.write("                                    <td><input class=\"formInputRegister\" type=\"date\" name=\"startdate\" value=\"\" id=\"startdate\" onchange=\"store()\" placeholder=\"startdate of your trip\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Interests:</td>\n");
      out.write("                                    <td><input class=\"formInputRegister\" type=\"text\" name=\"interests\" value=\"\"  id=\"interests\" onchange=\"store()\" placeholder=\"e.g. party, surfing, sight-seeing\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Looking for:</td>\n");
      out.write("                                    <td><input class=\"formInputRegister\" type=\"text\" name=\"looking_for\" value=\"\"  id=\"looking_for\" onchange=\"store()\" placeholder=\"e.g. share a car, meet-up, party\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>About</td>\n");
      out.write("                                    <td><input class=\"formInputRegister\" type=\"textarea\" name=\"about\" value=\"\"  id=\"about\" onchange=\"store()\" placeholder=\"sth. about you and your trip\" required/></td>\n");
      out.write("                                </tr\n");
      out.write("                                <tr>\n");
      out.write("                                    <td></td>\n");
      out.write("                                    <td><input class=\"formInputRegister btn btn-primary btn-s\" style=\"margin-bottom:15px;margin-right: 30px\" type=\"submit\" value=\"Create Profile\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </form>\n");
      out.write("                  </div>\n");
      out.write("                  <br><br>\n");
      out.write("                </div>\n");
      out.write("        </div>\n");
      out.write("      </body>\n");
      out.write("    </html>");
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
