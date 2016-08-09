
<%-- 
    Document   : searchRes
    Created on : 08.08.2016, 11:24:41
    Author     : manuela
--%>

<%-- Alle Reiseziele (Destination) werden aus der Datenbank gelesen und in result gespeichert --%>
<script><sql:query var="result" dataSource="jdbc/travelmate">
    SELECT DISTINCT destination FROM profils ORDER BY destination ASC
</sql:query></script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Chat.ChatInterface"%>
<%@page import="Chat.ClientInterface"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.xml.ws.WebServiceRef"%>
<%@page import="webservice.TmWebService_Service"%>
<%@page import="webservice.User"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
        function meldung(){
              alert("No valid session, please login!");
              location= window.location.href='Index';
            };
            
    </script>
    <link rel="stylesheet" href="css/css02.css" type="text/css">
    
    
    </head>
      <% //Prüfen, ob Session gültig ist, sonst wird alert über Funktion meldung() ausgegeben
        HttpSession nsession = request.getSession(true);
        if(nsession.getAttribute("email")==null) {
           %><script>meldung();</script><%     
        } 
      %>
      
      
      
      <% //In search.jsp ausgewählte Parameter
         String destination = request.getParameterValues("Destination")[0];
         String gender = request.getParameterValues("Gender")[0];
      %>

    <body>
        <div>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              </button>
              <a class="navbar-brand" href="${pageContext.request.contextPath}/toHome">TravelMate</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/toProfil">Profile</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/toSearch">Search<span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/Inbox">Messages</a></li>
                <li><a href="${pageContext.request.contextPath}/toChat">Chat</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
    </div>   
       
    <div class="fixed-bg container">
        <div class="row center-me profilesheet-search" >
            <div class="col-xs-12 col-sm-12 col-md-12 abstand" style="text-align: center">
                
                    <h4><font size="5" color="#2a96c0">Find your travelmates</font><h4>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-12 abstand " style="text-align: center; border-bottom:1px solid grey">
                        <!--Button "New Search":-->
                        <form action="toSearch" method="POST" >
                            <input class="btn btn-primary btn-lg" type="submit" name="search" value="New Search">
                        </form>
                        <br>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-12 abstand " style="text-align:center;">
                        <!--Ausgewählte Destination:-->
                        <font size="6" color="grey">Destination:</font>
                        <br>
                        <!--Ausgewählte Destination:-->
                        <font size="6" color="grey"><%out.println(destination);%></font>
                    </div>
                    <div class="col-xs-1 col-sm-2 col-md-3 abstand" ></div>
                    <div class="col-xs-11 col-sm-10 col-md-9 abstand" >

                        <!--
                        *-------------------------------Find TravelMates------------------------------------------------*
                        - Die Methode findTravelmates() gibt eine Liste mit Objekten von User zurück, die zu den
                          gesuchten Vorgaben passen
                        - Diese werden dann mit in einer Liste ausgeben, um dann die Möglichkeit zu haben auf das Profil
                          weitergeleitet zu werden
                        -->

                        <%java.util.List<webservice.User> travelmates = (java.util.List<webservice.User>)session.getAttribute("travelmates");
                         tm.User user = (tm.User) nsession.getAttribute("user");%>
                        <!--Ausgabe der potenziellen Travelmates-->
                        <ul>
                        <%for (int i = 0; i < travelmates.size(); i++) {

                            //Damit der aktuelle User nicht selbst bei der Suche ausgeben wird:
                            if (travelmates.get(i).getUserId() != user.getId()) { 


                                out.println("</br>");
                                out.println("<li>" + travelmates.get(i).getName() + " " + travelmates.get(i).getLastName() + "</br>");
                                out.println("Looking for: " + travelmates.get(i).getLookingFor() + "</br>");
                                out.println("Startdate: " + travelmates.get(i).getStartdate() + "</br>");
                                out.println(" <form action=\"toProfil\" method=\"POST\">");
                                out.println(" <input type=\"hidden\" name=\"email\" value=\"" + travelmates.get(i).getEmail() + "\">");
                                out.println(" <input id=\"tmMail\" onclick=\"setTmEmail()\" type=submit class=\"btn btn-info btn-xs\" style=\"margin-top:5px;\" value=\"show profile\">\n"
                                        + "        </form>");
                                out.println("</li>");
                                out.println("</br>");
                            }
                        }%>
                        </ul>
                    </div>
                    
                </form>
            </div>
            <br>
        </div>
    </body>
</html>

