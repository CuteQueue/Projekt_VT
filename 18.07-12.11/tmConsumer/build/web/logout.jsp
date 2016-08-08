<%-- 
    Document   : logout
    Created on : 21.07.2016, 10:22:47
    Author     : Manuela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Logout</title>
            <LINK REL="stylesheet" TYPE="text/css" MEDIA="all" HREF="css/default.css">
        </head>
        <body>

            <center>
            <h1>You have logged out!</h1>
            <li>
                <form action="toLogin" method="POST">
                <input type="hidden" name="start"><br>
                <input type=submit value="Head to login.">
                </form>
            </li>
            </center>
        <script>
            localStorage.clear();
        </script>
        </body>
    </html>
    
    
<!--Deaktivieren des Back-Buttons-->
<script>
    window.location.hash="session ended";
    window.location.hash="session ended";//again because google chrome don't insert first hash into history
    window.onhashchange=function(){window.location.hash="noSession";};   
</script> 



<!-- Umleitung zum Login bei Nutzung des Back-Buttons
<script>
    (function(window, location) {
        var href = window.location.href ;
        var l = document.createElement("a");
        l.href = href;
        var host = l.hostname;
        
        history.replaceState(null, document.title, location.pathname+"#!/history");
        history.pushState(null, document.title, location.pathname);

        window.addEventListener("popstate", function() {
          if(location.hash === "#!/history") {
            history.replaceState(null, document.title, location.pathname);
            setTimeout(function(){
              location.replace("http://"+host+":8080/tmConsumer/toLogin");
            },0);
          }
        }, false);
    }(window, location));
</script>-->

        
<%
    session.invalidate();
%>
