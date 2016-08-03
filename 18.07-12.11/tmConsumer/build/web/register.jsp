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
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
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
                        <td><input type="text" name="name" id="name" onchange="store();load()" required><br></td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td><input type="text" name="last_name" id="last_name" onchange="store()" required><br></td>
                    </tr>
                    <tr>
                        <td>Nickname:</td>
                        <td><input type="text" name="nickname" id="nickname" onchange="store()" required><br></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" id="email" onchange="store()" required><br></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="pw" required></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type=submit value="Abschicken"></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <!--LOCALSTORAGE abfragen-->
       
        
    </body>
    <script>
        function store() {
            var serverIp = document.getElementById('name').value;
            var serverIp = document.getElementById('last_name').value;
            var serverIp = document.getElementById('nickname').value;
            var serverIp = document.getElementById('email').value;
            // Save the name in localStorage.
            localStorage.setItem('name', name);
            localStorage.setItem('last_name', last_name);
            localStorage.setItem('nickname', nickname);
            localStorage.setItem('email', email);
            //alert(localStorage.getItem('serverIp'));
        }
    </script>
    
    <script>
        function load(){
            var name = localStorage.getItem('name');
            var last_name = localStorage.getItem('last_name');
            var nickname = localStorage.getItem('nickname');
            var email = localStorage.getItem('email');
            return name;
        };
        document.getElementById("name").value = load();  
    </script>
</html>
