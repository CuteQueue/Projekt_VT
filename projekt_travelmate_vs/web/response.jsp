<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : response
    Created on : 14.07.2016, 10:29:06
    Author     : Manuela
--%>
<sql:query var="userQuery" dataSource="jdbc/travelmate">
    SELECT * FROM users, profils 
    WHERE profils.user_id = ? <sql:param value="${param.id}"/>
    AND users.id = profils.user_id 
</sql:query>
    
<c:set var="userDetails" value="${userQuery.rows[0]}"/>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>TravelMate - response page</title>
    </head>
    <body>
        <table border="0">
            <thead>
                <tr>
                    <th colspan="2">${userDetails.name}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><strong>Description: </strong></td>
                    <td><span style="font-size:smaller; font-style:italic;">${userDetails.name}</span></td>
                </tr>
                <tr>
                    <td><strong>Counselor: </strong></td>
                    <td>{placeholder}
                        <br>
                        <span style="font-size:smaller; font-style:italic;">
                        id: ${userDetails.user_id}</span>
                    </td>
                </tr>
                <tr>
                    <td><strong>Further details </strong></td>
                    <td><strong>email: </strong>
                        <a href="mailto:${userDetails.email}">${userDetails.email}</a>
                        <br><strong>age: </strong>${userDetails.age}
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
