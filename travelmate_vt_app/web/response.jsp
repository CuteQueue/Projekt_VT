<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : response
    Created on : 12.07.2016, 14:20:31
    Author     : nina
--%>

    <sql:query var="usersRow" dataSource="jdbc/travelmate_vt_app">
        SELECT name, email, last_name FROM users
    </sql:query>
    <c:set var="aktUser" scope="request" value="${usersRow.rows[0]}"/>
    
    
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TravelMate - {placeholder}</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <table border="0">
            <thead>
                <tr>
                    <th colspan="2">${aktUser.name}</th>
                </tr>
            </thead>
            <tbody>
               <tr>
                    <td><strong>Last name: </strong></td>
                    <td><span style="font-size:smaller; font-style:italic;">${aktUser.last_name}</span></td>
                </tr>
                <tr>
                    <td><strong>Email: </strong></td>
                    <td><span style="font-size:smaller; font-style:italic;">${aktUser.email}</span></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
