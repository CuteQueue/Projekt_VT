<%-- 
    Document   : newMessage
    Created on : 08.08.2016, 15:28:22
    Author     : nina
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
        function meldung() {
            alert("No valid session, please login!");
            location = window.location.href = 'Index';
        };
    </script>
    <link rel="stylesheet" href="css/css02.css" type="text/css">


</head>
<% HttpSession nsession = request.getSession(true);
    if (nsession.getAttribute("email") == null) {
        %><script>meldung();</script><%
    }
%>

<body>
    <div>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/toHome">TravelMate</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/toProfil">Profile</a></li>
                        <li><a href="${pageContext.request.contextPath}/toSearch">Search</a></li>
                        <li  class="active"><a href="${pageContext.request.contextPath}/Inbox">Messages<span class="sr-only">(current)</span></a></li>
                        <li><a href="${pageContext.request.contextPath}/toChat">Chat</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>     


    <div class="fixed-bg container">
        <div class="row center-me profilesheet" >
            <div class="col-xs-12 col-sm-12 col-md-12 ">
                <%
                    String chatPartnerName = (String) session.getAttribute("chatPartnerName");
                %> 
                 <h4 style="text-align: center;"><font size="5" color="#2a96c0" >Send  <%out.println(chatPartnerName);%> A Message!</font></h4>
               
                 <%-- Chatfenster zum Senden einer neuen Nachricht: --%>
                <form action="SendNewMessage" method="post">
                <div class="form-group">
                    <label for="content"></label>
                    <textarea class="form-control" rows="5" name="content"></textarea>
                </div>
                    <input type="submit" class="btn btn-primary btn-s center-block" style="margin-top:5px; margin-bottom: 5px" value="Send" name="button">
                </form>
                </br>
            </div>
        </div>
    </div>
</br></br>
</body>
</html>


