<%-- 
    Document   : register
    Created on : 21.07.2016, 10:32:38
    Author     : nina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form action="Register" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>Register:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" required><br></td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td><input type="text" name="last_name" required><br></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" required><br></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="pw" required></td>
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
