<%-- 
    Document   : createProfile
    Created on : 20.07.2016, 13:48:08
    Author     : nina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>Create Profile</title>
    </head>
    <body>
        <form action="CreateProfile" method = "POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>Create Profile</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Mobilenumber:</td>
                        <td><input type="text" name="mobilenumber" value="" /></td>
                    </tr>
                    <tr>
                        <td>Age:</td>
                        <td><input type="int" name="age" value="" required /></td>
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
                        <td><input type="text" name="destination" value="" /></td>
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
                        <td><input type="submit" value="Create Profile" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
