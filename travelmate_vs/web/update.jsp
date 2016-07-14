<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : response
    Created on : 14.07.2016, 10:29:05
    Author     : nina
--%>

<sql:update var="profils" dataSource="jdbc/travelmate_vs">
    UPDATE profils
    SET location = ? <sql:param value="${param.update_location}"/>
    WHERE user_id = 26
</sql:update>

<sql:query var="profileQuery" dataSource="jdbc/travelmate_vs">
    SELECT * FROM profils, users
    WHERE  profils.user_id = 26
    AND profils.user_id = users.id

</sql:query>
<c:set var="profileDetails" value="${profileQuery.rows[0]}"/> 


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${profileDetails.name}</title>
    </head>
    <table border="0">
        <thead>
            <tr>
                <th colspan="2">${profileDetails.name} ${profileDetails.last_name}</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><strong>Location: </strong></td>
                <td><span style="font-size:smaller; font-style:italic;">${profileDetails.location}</span></td>
            </tr>
            <tr>
                <td><strong>Gender: </strong></td>
                <td><span style="font-size:smaller; font-style:italic;">${profileDetails.sex}</span></td>
            </tr>
            <tr>
                <td><strong>Destination: </strong></td>
                <td><span style="font-size:smaller; font-style:italic;">${profileDetails.destination}</span></td>
            </tr>
            <tr>
                <td><strong>Startdate: </strong></td>
                <td><span style="font-size:smaller; font-style:italic;">${profileDetails.startdate}</span></td>
            </tr>
            <tr>
                <td><strong>Interests: </strong></td>
                <td><span style="font-size:smaller; font-style:italic;">${profileDetails.interests}</span></td>
            </tr>
            <tr>
                <td><strong>Looking for: </strong></td>
                <td><span style="font-size:smaller; font-style:italic;">${profileDetails.looking_for}</span></td>
            </tr
            <tr>
                <td><strong>About: </strong></td>
                <td><span style="font-size:smaller; font-style:italic;">${profileDetails.about}</span></td>
            </tr>

        </tbody>
    </table>
</html>