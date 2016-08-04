<%-- 
    Document   : home
    Created on : 19.07.2016, 13:48:22
    Author     : Manuela
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="tm.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
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

   
  </head>
    <body>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">TravelMate</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Profile<span class="sr-only">(current)</span></a></li>
                <li><a href="#">Search</a></li>
                <li><a href="#">Messages</a></li>
                <li><a href="#">Chat</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
            
        <% String email;
        
            try {
        
            //--------Passende Userdaten holen ----------------------------------
                email = (String) session.getAttribute("email");
                User u = new User(email);
                session.setAttribute("user", u); //in Session gespeichert 
                session.setAttribute("userId", u.getId());
                User user = (User) session.getAttribute("user");
                out.println("<h2>Willkommen " + user.getName() + " " + user.getLast_name() + "!</h2>");
                out.println("</br>");

                u.getProfileData(); //Profildaten holen
                if (u.getLocation() != null) { //Wenn Profil schon vorhanden
                    //-----------Ausgabe der Profildaten------------------------------------------
                    out.println("Location: " + u.getLocation() + "</br>");
                    out.println("Age: " + u.getAge() + "</br>");
                    out.println("Destination: " + u.getDestination() + "</br>");
                    out.println("Startdate: " + u.getStartdate() + "</br>");
                    out.println("Interests: " + u.getInterests() + "</br>");
                    out.println("Looking for: " + u.getLooking_for() + "</br>");
                    out.println("About: " + u.getAbout() + "</b>");

                    //--------Edit Button----------------------------------------------------
                    out.println("<form action=\"http://" + session.getAttribute("serverIp") + ":8080/tmConsumer/editProfile.jsp\">");
                    out.println("<input type=submit value=\"Edit\">");
                    out.println("</form>");

                } else { //Wenn noch kein Profil vorhanden:
                    out.println("Noch kein Profil vorhanden");
                    out.println("Jetzt anlegen: ");
                    out.println("<form action=\"http://" + session.getAttribute("serverIp") + ":8080/tmConsumer/Create\">");
                    out.println("<input type=submit value=\"Create Profile\">");
                    out.println("</form>");

                }
                
            }catch(Exception err){
                System.out.println("catch, home.jsp");
            }

        %>

      
      
      
    </body>
</html>
