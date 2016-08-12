<%-- 
    Document   : inbox
    Created on : 09.08.2016, 13:27:15
    Author     : nina
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>TravelMate</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

        <!-- Bootstrap -->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <script>
            function meldung() {
                alert("No valid session, please login!");
                location = window.location.href = 'Index';
            }
            ;
        </script>
        <link rel="stylesheet" href="css/css02.css" type="text/css">


        <% HttpSession nsession = request.getSession(true);
            if (nsession.getAttribute("email") == null) {
                %><script>meldung();</script><%
            }
        %>
    </head>

    <body>
        <div>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        </button>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/toHome">TravelMate</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="${pageContext.request.contextPath}/toProfil">Profile</a></li>
                            <li><a href="${pageContext.request.contextPath}/toSearch">Search</a></li>
                            <li class="active"><a href="${pageContext.request.contextPath}/Inbox">Messages<span class="sr-only">(current)</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/toChat">Chat</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>   


        <div class="fixed-bg container">
            <div class="row center-me profilesheet-search" >
                <div class="col-xs-12 col-sm-12 col-md-12 abstand" style="text-align: center">
                    <h4><font size="5" color="#2a96c0">Inbox</font></h4>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 abstand " style="text-align: center">

                    <%java.util.List<webservice.User> conversations = (java.util.List<webservice.User>) session.getAttribute("conversations");
                      java.util.List<webservice.User> anyNewMessages = (java.util.List<webservice.User>) session.getAttribute("anyNewMessages");

                        if (conversations.size() == 0) { %>
                            <p><strong>Your inbox is empty.</strong> 
                            <p>Look for Travelmates using the Search Button on top.
                            Once you find a traveller you want to contact, click on the Contact Button on their profile</p>
                        <% } else {
                            out.println("</br>");
                        %>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 abstand">
                    <!--Die verschiedenen Unterhalten mit den jeweiligen Nutzernamen anzeigen
                    Wird der Name angeklickt, wird der zugehörige Chatverlauf angezeigt-->
                    <ul class="chat"> <%                    
                        boolean newMessage = false;
                        for (int i = 0; i < conversations.size(); i++) {
                            newMessage =false;
                             for (int j = 0; j < anyNewMessages.size(); j++) {
                                if (conversations.get(i).getName().equals(anyNewMessages.get(j).getName())){
                                  %>
                                    <li class="left clearfix">
                                    <form action="toMessages" method="POST">
                                        <%
                                            out.println("<input type=\"hidden\" name=\"chatPartnerId\" value=\"" + conversations.get(i).getUserId() + "\">");
                                            out.println("<input type=\"hidden\" name=\"chatPartnerName\" value=\"" + conversations.get(i).getName() + "\">");
                                            out.println("<p><font size=\"4\">" + conversations.get(i).getName() + " " + conversations.get(i).getLastName() + " " + "</font><font size=\"2\">" +" - New Message(s)!</font>");
                                            out.println("<input type=\"submit\" class=\"btn btn-primary btn-s pull-right\" style=\"margin-top:5px;\" value=\"Open\" name=\"button\" id=\"button\"></p>");
                                        %>
                                    </form>
                                    </li>
                                    <%
                                    newMessage = true;
                                }                           
                            }   
                            if (newMessage == false){
                                out.println("<li class=\"left clearfix\">");
                                out.println(" <form action=\"toMessages\" method=\"POST\">");
                                out.println("<input type=\"hidden\" name=\"chatPartnerId\" value=\"" + conversations.get(i).getUserId() + "\">");
                                out.println("<input type=\"hidden\" name=\"chatPartnerName\" value=\"" + conversations.get(i).getName() + "\">");
                                out.println("<p><font size=\"4\">" + conversations.get(i).getName() + " " + conversations.get(i).getLastName() + "</font>");
                                out.println("<input type=\"submit\" class=\"btn btn-primary btn-s pull-right\" style=\"margin-top:5px;\" value=\"Open\" name=\"button\"></p>");
                                out.println("</form>");
                                out.println("</li>");
                            }
                        }
                    }
                    %>
                    </ul>
                  </br>
                  </br>
                </div>
            </div>
        </div>
    </body>
</html>