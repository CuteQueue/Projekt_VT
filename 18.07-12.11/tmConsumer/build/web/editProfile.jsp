<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : editProfile
    Created on : 21.07.2016, 11:07:33
    Author     : nina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<sql:query var="result" dataSource="jdbc/travelmate">
    SELECT name FROM users WHERE id = ${sessionScope.userId}
</sql:query>
    
<sql:query var="destination" dataSource="jdbc/travelmate">
    SELECT destination FROM profils WHERE user_id = ${sessionScope.userId}
</sql:query>
    




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>Edit Profile</title>
    </head>
    <script>
        var destination = <sql:query var="destination" dataSource="jdbc/travelmate">
                            SELECT destination FROM profils WHERE user_id = ${sessionScope.userId}
                        </sql:query>;
    </script>
    
    <body>
        <table border="1">
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                    </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        
        <form action="CreateProfile" method = "POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>TEST</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" value="${sessionScope.email}" /></td>
                        <td><input type="text" value="${sessionScope.id}" /></td>
                       
                    </tr>
                    <tr>
                        <td>Location:</td>
                        <td><input type="text" name="location" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>

                        <td><input type="radio" name="sex" value="male" checked> Male<br></td>
                        <td><input type="radio" name="sex" value="female"> Female<br></td>
                    </tr>
                    <tr>
                        <td>Destination:</td>
                        <td><input type="text" name="destination" value="${destination}" /></td>
                    </tr>
                    <tr>
                        <td>Startdate:</td>
                        <td><input type="date" name="startdate" value="" /></td>
                    </tr>
                    <tr>
                        <td>Interests:</td>
                        <td><input type="text" name="interests" value="" /></td>
                    </tr>
                    <tr>
                        <td>Looking for:</td>
                        <td><input type="text" name="looking_for" value="" /></td>
                    </tr>
                    <tr>
                        <td>About</td>
                        <td><input type="text" name="about" value="" /></td>
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
