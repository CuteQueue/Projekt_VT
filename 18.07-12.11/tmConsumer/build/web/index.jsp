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
        <title>TravelMate</title>
    </head>
    <body>
       <strong>Login:</strong><br>
        <form action="Login" method="POST">
            Email:
            <input type="text" name="email"><br>
            Password:
            <input type="password" name="pw">
            <input type=submit value="Abschicken">
        </form>
       <br><br>
        <form action="http://localhost:8080/tmConsumer/register.jsp">
            <input type=submit value="Register">
        </form>
        <br>
     
    </body>
</html>
