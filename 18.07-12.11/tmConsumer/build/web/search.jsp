<%-- 
    Document   : search
    Created on : 28.07.2016, 09:24:41
    Author     : nina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>Search</title>
    </head>
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
                        <td> <select name="Destination">
                                <option>Amsterdam</option>
                                <option>Berlin</option>
                                <option>London</option>
                                <option>New York</option>
                                <option>Rom</option>
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

