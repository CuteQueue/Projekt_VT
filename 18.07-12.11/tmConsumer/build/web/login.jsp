<%-- 
    Document   : login
    Created on : 18.07.2016, 11:36:16
    Author     : manuela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>TravelMate</title>
    </head>
    
    <body>
       <strong>Login:</strong><br>
        <form action="Login" method="POST">
            <input type="hidden" name="serverIp" id="serverIp" >            
            <br>
            Email:
            <input type="text" name="email"><br>
            Password:
            <input type="password" name="pw">
            <input type=submit value="Abschicken">
        </form>
       
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
       <br><br>
        <form action="toRegister">
            <input type="hidden" name="serverIp2" id="serverIp2" >   
            <input type=submit value="Register">
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
            document.getElementById("serverIp2").value = getLocation();
            localStorage.clear();
        </script>
        <br>
     
    </body>
</html>

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
