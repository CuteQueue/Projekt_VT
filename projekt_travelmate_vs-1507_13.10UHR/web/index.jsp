<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="users" dataSource="jdbc/travelmate">
    SELECT id FROM users
</sql:query>
    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!--<html>
    <head>
        <title>TravelMate Web App</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Welcome to TravelMate, let the adventure begin!</h1>
        <table border="0">
            <thead>
                <tr>
                    <th>TravelMate offers new experiences to its users.</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>To view the users information select one from below.</td>
                </tr>
                <tr>
                    <td>
                        <form action="response.jsp">
                            <strong>Select something:</strong>
                            <select name="id">
                                <%-- <c:forEach var="row" items="${users.rowsByIndex}">
                                    <c:forEach var="column" items="${row}">
                                        <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                                    </c:forEach>
                                </c:forEach>--%>
                            </select>
                            <input type="submit" value="submit" name="submit" />
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>-->
                                
                                
<html>
    <head>
        <title>TravelMate Web App</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script type="text/javascript" src="billboard.js"></script>
    </head>
    <body>
        <h1>Welcome to TravelMate, let the adventure begin!</h1>
        <table border="0">
            <thead>
                <tr>
                    <th>TravelMate Login.</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Please login to use te TravelMate App</td>
                </tr>
                <tr>
                    <td>
                        <form action="LoginServlet" method="POST">
                            <strong>Email:</strong>
                            <input type="text" size="40" maxlength="50" name="email"><br>
                            <strong>Password:</strong>
                            <input type="text" size="40" maxlength="15" name="pw">
                            <input type=submit value="Abschicken">
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
