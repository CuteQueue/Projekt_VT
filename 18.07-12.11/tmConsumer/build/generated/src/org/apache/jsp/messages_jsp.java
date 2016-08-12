package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import tm.User;

public final class messages_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta http-equiv=\"Pragma\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"Expires\" content=\"-1\">\n");
      out.write("    <title>TravelMate</title>\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <!-- Latest compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    <!-- Optional theme -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    <!-- Latest compiled and minified JavaScript -->\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function meldung() {\n");
      out.write("            alert(\"No valid session, please login!\");\n");
      out.write("            location = window.location.href = 'Index';\n");
      out.write("        }\n");
      out.write("        ;\n");
      out.write("    </script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/css02.css\" type=\"text/css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
 HttpSession nsession = request.getSession(true);
    if (nsession.getAttribute("email") == null) {

      out.write("<script>meldung();</script>");

    }

      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div>\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/toHome\">TravelMate</a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/toProfil\">Profile</a></li>\n");
      out.write("                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/toSearch\">Search</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Inbox\">Messages<span class=\"sr-only\">(current)</span></a></li>\n");
      out.write("                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/toChat\">Chat</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Logout\"><span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span> Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div><!-- /.navbar-collapse -->\n");
      out.write("            </div><!-- /.container-fluid -->\n");
      out.write("        </nav>\n");
      out.write("    </div>     \n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"fixed-bg container\">\n");
      out.write("        <div class=\"row center-me profilesheet\" >\n");
      out.write("            <div class=\"col-xs-12 col-sm-12 col-md-12 \">\n");
      out.write("\n");
      out.write("                ");

                    String chatPartnerName = (String) session.getAttribute("chatPartnerName");
                    java.util.List<webservice.Message> messages = (java.util.List<webservice.Message>) session.getAttribute("messages");
                    User user = (User) session.getAttribute("user");
                
      out.write("\n");
      out.write("\n");
      out.write("                <h4><font size=\"5\" color=\"#2a96c0\">Messages with ");
 out.println(chatPartnerName);
      out.write("</font></h4>\n");
      out.write("                </br>\n");
      out.write("                <ul class=\"chat\">\n");
      out.write("                    ");
for (int i = 0; i < messages.size(); i++) {
                            //Wenn die zur Nachrichten gespeicherte UserId gleich der Id des aktuellen Users ist,
                            //dann wurde die Nachricht vom aktuellen User gesendet:

                            if (messages.get(i).getUserId() == user.getId()) {
                                out.println("<li style =\"text-align: right;\" class=\"right clearfix\"> <span class =\"chat-img pull-right\"><img src = \"http://placehold.it/50/FA6F57/fff&text=ME\" class =\"img-circle\"> </span>");
                                out.println("<div class=\"chat-body clearfix\">");
                                out.println("<div class=\"header\"><strong class = \"primary-font\">");
                                out.println(user.getName());
                                out.println("</strong></div>");

                                out.println("<p>");
                                out.println(messages.get(i).getContent());
                                out.println("</p></div>");
                                out.println("</li>");

                            } else {
                                //Ansonsten wurde die Nachricht vom Chatpartner gesendet:
                                out.println("<li class=\"left clearfix\"> <span class =\"chat-img pull-left\"><img src = \"http://placehold.it/50/55C1E7/fff&text=U\" class =\"img-circle\"> </span>");
                                out.println("<div class=\"chat-body clearfix\">");
                                out.println("<div class=\"header\"><strong class = \"primary-font\">");
                                out.println(chatPartnerName);
                                out.println("</strong></div>");

                                out.println("<p>");
                                out.println(messages.get(i).getContent());
                                out.println("</p></div>");
                                out.println("</li>");
                        }
                    }
      out.write(" \n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("               \n");
      out.write("                ");
      out.write("\n");
      out.write("                <form action=\"SendNewMessage\" method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"content\"></label>\n");
      out.write("                    <textarea class=\"form-control\" rows=\"5\" name=\"content\"></textarea>\n");
      out.write("                </div>\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-primary btn-s center-block\" style=\"margin-top:5px; margin-bottom: 5px\" value=\"Send\" name=\"button\">\n");
      out.write("                </form>\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                \n");
      out.write("\n");
      out.write("            </div> \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    </br></br>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
