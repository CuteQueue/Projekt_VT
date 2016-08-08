<%-- 
    Document   : login
    Created on : 18.07.2016, 11:36:16
    Author     : manuela
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
    </head>
    
    <style>
        .parent {
          width: 100%;
          height: 100%;
        }
        .child {
          width: 100%;
          position: absolute;
          top: 50%;
          transform: translateY(-50%);
        }
        .center-me {
          margin: 0 auto;
        }
        
        /*für Hintergrunddarstellung im Browser*/
        html { 
            background: url(backgrounds/pexels-photo-25562_edit.jpg) no-repeat center center fixed; 
            -webkit-background-size: 100%; 
            -moz-background-size: 100%; 
            -o-background-size: 100%; 
            background-size: 100%; 
            -webkit-background-size: cover; 
            -moz-background-size: cover; 
            -o-background-size: cover; 
            background-size: cover; 
            min-height: 100%;
          }
        
         /*fixed-bg für korrekte Darstellung auf dem Smartphone bei Wisch-Geste*/
        .fixed-bg {
            background-image: url(backgrounds/pexels-photo-25562_edit.jpg);
            min-height: 600px;
            background-attachment: fixed;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
    
    <body>
        <div class="fixed-bg">
        <div class="parent">
          <div class="child">
            <div class="row">
                <div class="col-xs-12 col-sm-12 text-center">
                    <img src="backgrounds/TravelMateLogo.png" style="max-width:300px;padding-bottom:15pt;"> 
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
                        <input type="button" class="btn btn-primary btn-s" onclick="window.location.href='register.jsp'" value="Register" name="button" id="button"/>​<br>
                        <input type="button" class="btn btn-default btn-xs" style="margin-top:15px;" onclick="window.location.href='index.jsp'" value="Change Server-Ip" name="button" id="button"/>​ 
                        <br><br>
                      </div>
                    </form>
                    
                    <script>
                        function getLocation() {
                            //alert(window.location.href);
                            var href = window.location.href ;
                            var l = document.createElement("a");
                            l.href = href;
                            //alert(l.hostname);
                            return l.hostname;
                        };
                        document.getElementById("serverIp").value = getLocation();
                        localStorage.clear();
                    </script>
                  </div>
                </div>
              <!-- Optional: clear the XS cols if their content doesn't match in height -->
              <div class="col-xs-12 col-sm-12 text-center"></div>
            </div>
          </div>
        </div>
        </div>
      </body>
    </html>
       
        <!--<script>
            function getLocation() {
                //alert(window.location.href);
                var href = window.location.href ;
                var l = document.createElement("a");
                l.href = href;
                //alert(l.hostname);
                return l.hostname;
            };
            document.getElementById("serverIp").value = getLocation();
        </script>-->
       
       <!--LOCALSTORAGE abfragen-->
       <!-- <script>
            function load(){
                alert(localStorage.getItem('serverIp'));
                var serverIp = localStorage.getItem('serverIp');
                return serverIp;
            };
            document.getElementById("serverIp").value = load();  
       </script>-->
       

<!-- Umleitung bei Nutzung des Back-Buttons
<script>
    (function(window, location) {
        var href = window.location.href ;
        var l = document.createElement("a");
        l.href = href;
        var host = l.hostname;
        var hash = l.h
        
        history.replaceState(null, document.title, location.pathname+"#!/history");
        history.pushState(null, document.title, location.pathname);

        window.addEventListener("popstate", function() {
          if(location.hash === "#!/history") {
            history.replaceState(null, document.title, location.pathname);
            setTimeout(function(){
              location.replace("http://"+host+":8080/tmConsumer#nosession");
            },0);
          }
        }, false);
    }(window, location));
</script>-->
