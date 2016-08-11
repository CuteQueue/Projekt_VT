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

   
    <link rel="stylesheet" href="css/css02.css" type="text/css">
    
    
    </head>

    <body>
      <div>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              </button>
              <a class="navbar-brand" href="#">TravelMate<span class="sr-only">(current)</span></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
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
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
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
                              Ich bin unterwegs zu Orten<br>
                            Die so schnell vorüberziehen<br>
                            Die unbeschreiblich sind mit Worten<br>
                            Man muss sie selber sehen<br>
                            Die Sonne geht grad auf und nimmt mich ein Stück mit<br>
                            Weil ich die Ferne brauch<br>
                            Und bin ich auch weit weg<br>
                            Mein Zuhause ist immer im Gepäck<br>
                            <br>
                            Das Leben ist wie eine Reise<br>
                            Und keiner weiß wohin<br>
                            Warum spür ich deine Nähe am Meisten<br>
                            Wenn ich meilenweit entfernt von dir bin<br>
                            Das Leben ist wie eine Reise<br>
                            Die mich in Atem hält.<br>
                            Der Kürzeste Weg zu sich selbst<br>
                            Führt manchmal ganz um die Welt<br>
                            <br>
                            Ich bin unterwegs durchs Leben<br>
                            Das Ziel ist der Moment<br>
                            Man muss nur weitergehen<br>
                            Auch wenn man die Richtung mal nicht kennt<br>
                            Mit jedem neuen Schritt entdeck ich immer mehr<br>
                            Ich nehm dich überall hin mit<br>
                            Vielleicht lauf ich davon<br>
                            Und bin doch längst schon angekommen<br>
                            <br>
                            Das Leben ist wie eine Reise<br>
                            Und keiner weiß wohin<br>
                            Warum spür ich deine Nähe am Meisten<br>
                            Wenn ich meilenweit entfernt von dir bin<br>
                            Das Leben ist wie eine Reise<br>
                            Die mich in Atem hält<br>
                            Der Kürzeste Weg zu sich selbst<br>
                            Führt manchmal ganz um die Welt<br>
                            <br>
                            Manchmal auch bis zum Mond je nachdem<br>
                            Wo hast du dich zuletzt denn gesehn<br>
                            Und wo genau verlorn<br>
                            Doch ich weiß<br>
                            <br>
                            Das Leben ist wie eine Reise<br>
                            Und man kommt niemals an<br>
                            Warum such ich mein Glück in der Weite<br>
                            Obwohl es gar nicht näher sein kann<br>
                            <br>
                            Das Leben ist eine Reise<br>
                            Man kommt niemals an<br>
                            Warum such ich mein Glück in der Weite<br>
                            Das Leben ist eine Reise<br>
                            Die mich in Atem hält<br>
                            Der Kürzeste Weg zu sich selbst<br>
                            Führt manchmal ganz um die Welt<br>
                          </td>
                      </tr>
                      
                      
                    </tbody>
                  </table>
                </div>
              </div>

            <br><br>
    </body>
</html>

