<%-- 
    Document   : home
    Created on : 19.07.2016, 13:48:22
    Author     : Manuela & Nina
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="tm.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
        function meldung(){
              alert("No valid session, please login!");
              location= window.location.href='Index';
            };
    </script>
    
    <link rel="stylesheet" href="css/css02.css" type="text/css">
    
    </head>
      <% HttpSession nsession = request.getSession(true);
          if(nsession.getAttribute("email")==null) {
              %><script>meldung();</script><%     
          } 
      %>

    <body>
      <div>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              </button>
              <a class="navbar-brand" href="#">TravelMate<span class="sr-only">(current)</span></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/toProfil">Profile</a></li>
                <li><a href="${pageContext.request.contextPath}/toSearch">Search</a></li>
                <li><a href="${pageContext.request.contextPath}/Inbox">Messages</a></li>
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
              <div class="row center-me profilesheet" >
                <div class="col-xs-12 col-sm-12 col-md-12 abstand" style="text-align: center;">
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12">
                  <table class="table abstand table-borderless" style="text-align: center">
                    <tbody>
                      <tr>
                        <td><h4><font color="#2a96c0">TM FAQ</font><h4></td>
                      </tr>
                      <tr>
                          <td>
                              TravelMate by Nina Gödde and Manuela Reker<br>
                              Version 1.0, August 2016<br><br>
                              
                              Die grundlegende Idee zur von uns erstellten <br>
                              Anwendung liegt darin, dass Reisende weltweit<br>
                              nach anderen Reisenden mit demselben Reiseziel <br>
                              mittels einer eingebauten Suchfunktion suchen können. <br>
                              Durch ein hinterlegtes Profil mit Angaben zu den<br>
                              einzelnen Nutzern (Alter, Interessen, <br>
                              aktueller Standort, Reiseziel, Startdatum der Reise etc.)<br>
                              und Kontaktfunktion sollten sich die Reisenden <br>
                              miteinander in Verbindung setzen können. <br>
                              Die Nutzer sollen somit die Möglichkeit erhalten,<br>
                              sich über die Anwendung zu verabreden bzw. zu <br>
                              planen gemeinsam Reiseabschnitte zurückzulegen, <br>
                              Ticketpreise zu teilen, oder sich einfach in der <br>
                              aktuellen Stadt auf einen Kaffee zu treffen, 
                              <br>gemeinsam feiern zu gehen etc. 
                              <br>Die für die Nutzer wichtigen Aspekte 
                              <br>(bspw. Geschlecht, Reiseziel, ...) bezüglich <br>
                              der Suche nach anderen Reisenden sollten individuell <br>
                              in der Suchanfrage auswählbar sein. <br><br>

                              Eine weitere Idee, ergänzend zur privaten Kontaktfunktion<br>
                              über das Profil, bestand darin Chats umzusetzen in denen<br>
                              sich mehrere Nutzer gleichzeitig auf unkomplizierte Weise<br> 
                              live austauschen sowie Reisetipps und Erfahrungen <br>
                              weitergeben können. <br><br>

                              Da es sich bei der App um die Suche nach Reisepartnern<br>
                              und Gleichgesinnten handelt lautet ihr Arbeitstitel "TravelMate".

                              
                          </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            <br><br>
    </body>
</html>

