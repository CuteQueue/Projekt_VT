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
        </body>
    </html>
<%
    session.invalidate();
%>
