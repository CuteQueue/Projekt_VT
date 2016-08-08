<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : editProfile
    Created on : 21.07.2016, 11:07:33
    Author     : nina
--%>
<%@page import="java.io.PrintWriter"%>
<%@page import="tm.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- Profildaten aus der Datenbank holen --%>
<sql:query var="profileQuery" dataSource="jdbc/travelmate">
    SELECT * FROM profils WHERE user_id = ${sessionScope.userId}
</sql:query>

  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
    <title>TravelMate</title>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <c:set var="profileDetails" value="${profileQuery.rows[0]}"/>
    <!-- Bootstrap -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="css/css01.css" type="text/css">
        
        <!--Datepicker für die Datumseingabe anlegen, falls Browser das Eingabeformat date nicht unterstützt-->
        <script type="text/javascript">
            var datefield=document.createElement("input");
            datefield.setAttribute("type", "date");
            if (datefield.type!=="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
                document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n');
                document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n');
                document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n'); 
            }
        </script>
        
        <!--Datepicker initialisieren, falls Browser das Eingabeformat date nicht unterstützt-->
        <script>
        if (datefield.type!=="date"){ 
            jQuery(function($){ //on document.ready
                $('#startdate').datepicker({ dateFormat: 'yy-mm-dd' });
            });
        }
        </script>   
    
        <script>

            window.onload = checkBoxes;

            function checkBoxes() {

                var getStatus = "${profileDetails.sex}";
                if (getStatus === "female") {
                    document.getElementById("female").checked = true;                   
                } else {
                    document.getElementById("male").checked = true;
                }

            };
            
            function meldung(){
              alert("No valid session, please login!");
              location= window.location.href='Index';
            };
        </script>
        <link rel="stylesheet" href="css/css02.css" type="text/css">
    </head>
    <% HttpSession nsession = request.getSession(true);
        if(nsession.getAttribute("email")==null) {
            %><script>meldung();</script><%     
        } 
    %>
    <body>
      <div>
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
                <li><a href="#">Search</a></li>
                <li><a href="#">Messages</a></li>
                <li><a href="/toChat">Chat</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
       </div>     


        <div class="fixed-bg container">
          <div class="row center-me profilesheet-edit" >
            <div class="col-xs-12 col-sm-12 col-md-12">
              <form action="EditProfile" method = "POST">
                <table class="table abstand table-borderless">
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 abstand">      
                      <h4><font color="#2a96c0">Edit profile</font></h4>      
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      Mobilenumber:
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-8 abstand-edit">
                      <input type="number" name="mobilenumber" value="${profileDetails.mobilenumber}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      Age: 
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-8 abstand-edit">
                      <input type="number" name="age" value="${profileDetails.age}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      Gender: 
                    </div>
                    <div class="col-xs-12 col-sm-4 col-md-8 abstand-edit">
                      <input type="radio" name="sex" value="male" id="male" checked><font size="2"> Male</font></br>
                      <input type="radio" name="sex" value="female" id="female"><font size="2"> Female</font></br>
                    </div>
                  </div>
                  <div class="row abstand-edit">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      About: 
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-8 abstand-edit">
                      <input type="text" name="about" value="${profileDetails.about}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      Location: 
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-8 abstand-edit">
                      <input type="text" name="location" value="${profileDetails.location}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      Destination: 
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-8 abstand-edit">
                      <input type="text" name="destination" value="${profileDetails.destination}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      Startdate: 
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-8 abstand-edit">
                      <input type="date" name="startdate" value="${profileDetails.startdate}" id="startdate" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      Looking&nbspfor: 
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-8 abstand-edit">
                      <input type="text" name="looking_for" value="${profileDetails.looking_for}" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-4 abstand-edit">      
                      Interests: 
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-8 abstand-edit">
                      <input type="text" name="interests" value="${profileDetails.interests}" />
                    </div>
                  </div>
                  <div class="row center-me">
                    <div class="col-xs-12 col-sm-12 col-md-12 abstand">
                      <input type="button" class="btn btn-primary btn-s" onclick="window.location.href='toHome'" value="cancel" name="button" id="button"/>​  
                      <input class="btn btn-primary btn-s" type="submit" value="save changes" />
                    </div>                        
                  </div>
                </table>
              </form>
            </div>
          </div>
        </div>
                        
    </body>
</html>
