<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 12.07.2016, 16:14:48
    Author     : nina
--%>
<sql:query var="users" dataSource="jdbc/travelmate_vt_app">
    SELECT name FROM users
</sql:query>
    
    <sql:query var="users" dataSource="jdbc/travelmate_vt_app">
        SELECT name FROM users
    </sql:query>
        
    <table border="1">
        <!-- column headers -->
        <tr>
            <c:forEach var="columnName" items="${users.columnNames}">
                <th><c:out value="${columnName}"/></th>
                </c:forEach>
        </tr>
        <!-- column data -->
        <c:forEach var="row" items="${users.rowsByIndex}">
            <tr>
                <c:forEach var="column" items="${row}">
                    <td><c:out value="${column}"/></td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>TravelMate</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body style="font-family:arial;">
        <!-- <form action="webChat" method="POST">
             <h2>Bitte die Server-IP eingeben:</h2>
             <input type="text" name="ip">
             <h2>Bitte gewuenschten Namen eingeben:</h2>
             <input type="text" name="name">
             <input type=submit value="Eingabe">
         </form> -->
        <table border="0">
            <thead>
                <tr>
                    <th>Welcome to Travlemate!</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>To view the profile details of a TravelMate, select a user below:</td>
                </tr>
                <tr>
                    <td><form action="response.jsp">
                            <strong>Select a user:</strong>
                            <select name="name">
                                <option></option>
                                <option></option>
                            </select>
                            <input type="submit" value="submit" name="submit" />
                        </form></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
