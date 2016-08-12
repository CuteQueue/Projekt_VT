<%-- 
    Document   : register
    Created on : 21.07.2016, 10:32:38
    Author     : nina & manuela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TravelMate</title>
        <link rel="stylesheet" href="css/css01.css" type="text/css">
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
        <script>
            window.onload = load;
            var ids = ['name', 'last_name', 'nickname'];

            ///Eingegebene Daten im LocalStorage hinterlegen
            function store() {
                for (i = 0; i < ids.length; i++) { 
                    var data = ids[i];
                    var value = document.getElementById(data).value;

                    localStorage.setItem(data, value);
                }
            };
            
            ///bereits eingegebene Daten aus dem LocalStorage laden
            function load(){
                for (i = 0; i < ids.length; i++) { 
                    var data = ids[i];
                    var value = localStorage.getItem(data);
                    document.getElementById(data).value = value;
                }
                checkBoxes();
            };
        </script>
    </head>
      
    <body>
        <div class="fixed-bg">
        <div class="parent">
          <div class="child container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-12 text-center">
                    <img src="images/TravelMateLogo.png" style="max-width:300px;padding-bottom:15pt;"> 
                </div>
              <div class="col-xs-12 col-sm-12 text-center">
                <div class="panel panel-default center-me" style="max-width:300px;">
                  <div class="panel-heading">Register</div>
                    <form action="Register" method="POST">
                        <table border="0" style="margin-left:30px; margin-top:15px">
                            <tbody>
                                <tr>
                                    <td>Name:</td>
                                    <td><input type="text" class="formInputRegister" name="name" id="name" onchange="store();" required><br></td>
                                </tr>
                                <tr>
                                    <td>Last name:</td>
                                    <td><input type="text" class="formInputRegister" name="last_name" id="last_name" onchange="store()" required><br></td>
                                </tr>
                                <tr>
                                    <td>Nickname:</td>
                                    <td><input type="text" class="formInputRegister" name="nickname" id="nickname" onchange="store()" required><br></td>
                                </tr>
                                <tr>
                                    <td>Email:</td>
                                    <td><input type="text" class="formInputRegister" name="email" id="email" required><br></td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td><input type="password" class="formInputRegister" name="pw" required></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type=submit class="btn btn-primary btn-s" style="margin-bottom:15px;" value="Submit">
                                    <input type="button" class="btn btn-primary btn-s" style="margin-bottom:15px;" onclick="window.location.href='login.jsp'" value="Cancel" name="button" id="button"/>​</td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>        
    </body>
</html>
