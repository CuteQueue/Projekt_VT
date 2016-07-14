<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : response
    Created on : 14.07.2016, 10:29:05
    Author     : nina
--%>
<sql:query var="userQuery" dataSource="jdbc/travelmate_vs">
    SELECT * FROM users WHERE  users.name = ? <sql:param value="${param.user_id}"/>
</sql:query>
<c:set var="userDetails" value="${userQuery.rows[0]}"/>    
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${userDetails.name}</title>
    </head>
    <table border="0">
    <thead>
        <tr>
            <th colspan="2">${userDetails.name}</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><strong>Last name: </strong></td>
            <td><span style="font-size:smaller; font-style:italic;">${userDetails.last_name}</span></td>
        </tr>
        <tr>
            <td><strong>Contact Details: </strong></td>
            <td><strong>email: </strong>
                <a href="mailto:${userDetails.email}">${userDetails.email}</a>
                <br><strong>phone: </strong>{placeholder}
            </td>
        </tr>
    </tbody>
</table>
</html>
