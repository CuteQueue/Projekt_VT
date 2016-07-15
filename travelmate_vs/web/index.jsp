<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 14.07.2016, 10:29:05
    Author     : nina
--%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TravelMate</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2><strong>TravelMate</strong>
        </h2>

        <table border="0">
            <thead>
                <tr>
                    <th>Please Log in:</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <form>
                            <tr> 
                                <td>Email: <input type="text" name="email" value="" /></td>
                                <td>Password: <input type="text" name="password" value="" /></td>
                            </tr>
                            <tr>
                                <td>
                                    <button onClick="postHttpRequest('LoginServlet')">Log in</button>
                                </td>
                            </tr>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
