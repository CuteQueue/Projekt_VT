<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : editProfile
    Created on : 21.07.2016, 11:07:33
    Author     : nina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<sql:query var="userQuery" dataSource="jdbc/travelmate">
    SELECT * FROM users WHERE id = ${sessionScope.userId}
</sql:query>
    
    
<sql:query var="profileQuery" dataSource="jdbc/travelmate">
    SELECT * FROM profils WHERE user_id = ${sessionScope.userId}
</sql:query>
    
<c:set var="profileDetails" value="${profileQuery.rows[0]}"/>
<c:set var="userDetails" value="${userQuery.rows[0]}"/>
    




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>Edit Profile</title>
    </head>

    
    <body>
        <form action="CreateProfile" method = "POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>Edit Profile</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" value="${sessionScope.email}" /></td>
                        <td><input type="text" value="${sessionScope.id}" /></td>
                       
                    </tr>
                    <tr>
                        <td>Location:</td>
                        <td><input type="text" name="location" value="${profileDetails.location}" required /></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>

                        <td><input type="radio" name="sex" value="male" checked> Male<br></td>
                        <td><input type="radio" name="sex" value="female"> Female<br></td>
                    </tr>
                    <tr>
                        <td>Destination:</td>
                        <td><input type="text" name="destination" value="${profileDetails.destination}" /></td>
                    </tr>
                    <tr>
                        <td>Startdate:</td>
                        <td><input type="date" name="startdate" value="${profileDetails.startdate}" /></td>
                    </tr>
                    <tr>
                        <td>Interests:</td>
                        <td><input type="text" name="interests" value="${profileDetails.interests}" /></td>
                    </tr>
                    <tr>
                        <td>Looking for:</td>
                        <td><input type="text" name="looking_for" value="${profileDetails.looking_for}" /></td>
                    </tr>
                    <tr>
                        <td>About</td>
                        <td><input type="text" name="about" value="${profileDetails.about}" /></td>
                    </tr
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Edit Profile" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
