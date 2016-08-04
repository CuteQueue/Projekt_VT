<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : search
    Created on : 28.07.2016, 09:24:41
    Author     : nina
--%>

<%-- Alle Reiseziele (Destination) werden aus der Datenbank gelesen und in result gespeichert --%>
<sql:query var="result" dataSource="jdbc/travelmate">
    SELECT DISTINCT destination FROM profils ORDER BY destination ASC
</sql:query>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>Search</title>
        
        <script>
            function meldung(){
              alert("No valid session, please login!");
              location= window.location.href='Index';
            };
        </script>
    </head>
    <!--Abfrage, ob Session gültig ist, sonst kein Zugriff auf create.jsp-->
    <% HttpSession nsession = request.getSession(true);
        if(nsession.getAttribute("email")==null) {
            %><script>meldung();</script><%     
        } 
    %>
    <body>
        <form action="Search" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>Find your travelmates:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Destination:</td>
                        <td>
                            <select name="Destination">
                                <c:forEach var="row" items="${result.rowsByIndex}">
                                    <c:forEach var="column" items="${row}">
                                        <option><c:out value="${column}"/></option>
                                    </c:forEach>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Gender:</td>
                        <td><select name="Gender">
                                <option>both</option>
                                <option>female</option>
                                <option>male</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type=submit value="Abschicken"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>

