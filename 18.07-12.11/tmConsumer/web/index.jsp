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
       <strong>Login:</strong><br>
        <form action="Login" method="POST">
            Email:
            <input type="text" name="email"><br>
            Password:
            <input type="password" name="pw">
            <input type=submit value="Abschicken">
        </form>
       <br><br>
        <strong>Register:</strong><br>
        <form action="Register" method="POST">
            Name:
            <input type="text" name="name"><br>
            Last name:
            <input type="text" name="last_name"><br>
            Email:
            <input type="text" name="email"><br>
            Password:
            <input type="text" name="pw">
            <input type=submit value="Abschicken">
        </form>
        <br>
       <!-- <form action="getName">
            Enter id:
            <input type="text" name="txtid" value="" />
            <input type="submit" value="GetName" />
        </form>-->
    </body>
</html>
