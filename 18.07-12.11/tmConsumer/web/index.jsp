<%-- 
    Document   : index
    Created on : 18.07.2016, 11:36:16
    Author     : nina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>JSP Page</title>
    </head>
    <body>
       <strong>Serververbindung herstellen:</strong><br>
        <form action="Start" method="POST">
            Server IP:
            <input type="text" name="serverIp"><br>
            <input type=submit value="Abschicken">
        </form>
       <br><br>
    </body>
</html>
