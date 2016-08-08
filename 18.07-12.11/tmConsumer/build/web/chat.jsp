<%-- 
    Document   : createProfile
    Created on : 08.08.2016, 13:48:08
    Author     : manuela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <style>
        input[type=number] {
            -moz-appearance: textfield;
        }
        
        
    </style>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>TravelMate</title>

        
        <link rel="stylesheet" href="css/css01.css" type="text/css">
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

        <!-- Bootstrap -->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
        
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
        } %>
            
    <body>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              </button>
              <a class="navbar-brand" href="${pageContext.request.contextPath}/toHome">TravelMate</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Profile<span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/toSearch">Search</a></li>
                <li><a href="#">Messages</a></li>
                <li><a href="${pageContext.request.contextPath}/toChat">Chat</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
        
        <div class="fixed-bg container-fluid">
        <div class="parent">
          <div class="child">
            <div class="row">
                
              <div class="col-xs-12 col-sm-12 text-center">
                <div class="panel panel-default center-me" style="max-width:300px;">
                  <!-- Default panel contents -->
                  <div class="panel-heading">No profile data found.</div>
                    <form action="CreateProfile" method = "POST">
                        <table border="0" style="margin-left:25px; margin-top:15px">
                            <tbody>
                                <tr>
                                    <td>Phone:</td>
                                    <td><input class="formInputRegister" type="number" name="mobilenumber" id="mobilenumber" onchange="store()" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Age:</td>
                                    <td><input class="formInputRegister" type="number" name="age" value="" id="age" onchange="store()" /></td>
                                </tr>
                                <tr>
                                    <td>Location:</td>
                                    <td><input class="formInputRegister" type="text" name="location" value="" id="location" onchange="store()"/></td>
                                </tr>
                                <tr>
                                    <td>Gender:</td>
                                    <td>
                                    male
                                    <input type="radio" style="margin-right:15px;margin-bottom:15px" class="checkboxTypo" name="sex" value="male" id="male" onclick="setStatus()" checked>
                                    female
                                    <input type="radio" class="checkboxTypo" name="sex" value="female" id="female" onclick="setStatus()" checked>
                                    </td>
                                    
                                </tr>
                                <tr>
                                    <td>Destination:</td>
                                    <td><input class="formInputRegister" type="text" name="destination" value="" id="destination" onchange="store()"/></td>
                                </tr>
                                <tr>
                                    <td>Startdate:</td>
                                    <td><input class="formInputRegister" type="date" name="startdate" value="" id="startdate" onchange="store()" /></td>
                                </tr>
                                <tr>
                                    <td>Interests:</td>
                                    <td><input class="formInputRegister" type="text" name="interests" value=""  id="interests" onchange="store()"/></td>
                                </tr>
                                <tr>
                                    <td>Looking for:</td>
                                    <td><input class="formInputRegister" type="text" name="looking_for" value=""  id="looking_for" onchange="store()"/></td>
                                </tr>
                                <tr>
                                    <td>About</td>
                                    <td><input class="formInputRegister" type="text" name="about" value=""  id="about" onchange="store()"/></td>
                                </tr
                                <tr>
                                    <td></td>
                                    <td><input class="formInputRegister btn btn-primary btn-s" style="margin-bottom:15px;margin-right: 30px" type="submit" value="Create Profile" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                  </div>
                </div>
              <!-- Optional: clear the XS cols if their content doesn't match in height -->
              <div class="col-xs-12 col-sm-12 text-center"></div>
            </div>
          </div>
        </div>
        </div>
      </body>
    </html>
              
              
              
