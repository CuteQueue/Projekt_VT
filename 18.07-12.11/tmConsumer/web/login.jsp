<%-- 
    Document   : login
    Created on : 18.07.2016, 11:36:16
    Author     : manuela & nina
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/css01.css" type="text/css">
    
        <script>
            function meldung(){
              alert("Welcome to TravelMate!\nLogin and let the adventure begin!");
              location= window.location.href='toLogin';
            };
        </script>
    </head>
    <!--Abfrage, ob Attribut "registered" gesetzt, dann Attribute entfernen und meldung ausgeben-->
    <% HttpSession nsession = request.getSession(true);
        if(nsession.getAttribute("registered")!=null) {
            nsession.removeAttribute("registered");
            %><script>meldung();</script><%  
    } %>
    <body>
        <div class="fixed-bg">
        <div class="parent">
          <div class="child container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-12 text-center">
                    <img src="images/TravelMateLogo.png" style="max-width:300px;padding-bottom:15pt;"> 
                </div>
              <div class="col-xs-12 col-sm-12 text-center">
                <div class="panel panel-default center-me" style="max-width:300px;">
                  <!-- Default panel contents -->
                  <div class="panel-heading">Login</div>
                    <form class="form-horizontal" action="Login" method="POST">
                        <div class="form-group">
                        <input type="hidden" name="serverIp" id="serverIp" >            
                        <br>
                        Email:
                        <input type="text" name="email" style="margin-bottom:15px; margin-left:25px"><br>
                        Password:
                        <input type="password" name="pw">
                        <br><br>
                        <input type=submit class="btn btn-primary btn-s" value="Submit">
                        <input type="button" class="btn btn-primary btn-s" onclick="window.location.href='toRegister'" value="Register" name="button" id="button"/>​<br>
                        <input type="button" class="btn btn-default btn-xs" style="margin-top:15px;" onclick="window.location.href='Index'" value="Change Server-IP" name="button" id="button"/>​ 
                        <br><br>
                      </div>
                    </form>
                    
                    <script>
                        function getLocation() {
                            var href = window.location.href ;
                            var l = document.createElement("a");
                            l.href = href;
                            return l.hostname;
                        };
                        document.getElementById("serverIp").value = getLocation();
                        localStorage.clear();
                    </script>
                  </div>
                </div>
            </div>
          </div>
        </div>
        </div>
      </body>
    </html>
       
      