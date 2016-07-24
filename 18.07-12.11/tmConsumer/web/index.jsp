<%-- 
    Document   : index
    Created on : 18.07.2016, 11:36:16
    Author     : manuela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <script>
        function store() {
            var serverIp = document.getElementById('serverIp').value;

            // Save the name in localStorage.
            localStorage.setItem('serverIp', serverIp);
            //alert(localStorage.getItem('serverIp'));
        }
    </script>
    
    
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>TravelMate</title>
    </head>
    <body>
       <strong>Login:</strong><br>
        <form id="IP" action="Start" method="POST">
            Server IP:
            <input type="text" name="serverIp" id="serverIp" onchange="store()"><br>
            <input type=submit value="Abschicken">
        </form>
       
       
       <br><br>

     
    </body>
</html>




