<%-- 
    Document   : home
    Created on : 19.07.2016, 13:48:22
    Author     : Manuela
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="tm.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

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
    <% HttpSession nsession = request.getSession(true);
        if(nsession.getAttribute("email")==null) {
            %><script>meldung();</script><%     
        } 
    %>
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
                <li class="active"><a href="${pageContext.request.contextPath}/toProfil">Profile<span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/toSearch">Search</a></li>
                <li><a href="${pageContext.request.contextPath}/Inbox">Messages</a></li>
                <li><a href="${pageContext.request.contextPath}/toChat">Chat</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</a></li>
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
                    <table>
                        <tbody>
                            <tr style="margin-bottom:10px">Please add information to your profile.</tr>
                            <br>
                            <tr><input type="button" class="btn btn-primary btn-s" onclick="window.location.href='Create'" value="Add profile data" style="margin-bottom:10px" name="button" id="button"/>​</tr>
                            <br>
                        </tbody>
                    </table>
                  </div>
                </div>
              <!-- Optional: clear the XS cols if their content doesn't match in height -->
              <div class="col-xs-12 col-sm-12 text-center"></div>
            </div>
          </div>
        </div>    
                    </br></br>

        </div>
      </body>
    </html>
      
