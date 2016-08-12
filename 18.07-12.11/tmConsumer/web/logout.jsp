<%-- 
    Document   : logout
    Created on : 21.07.2016, 10:22:47
    Author     : Manuela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
    <html>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    </head>
    <body>
        <div class="fixed-bg" >
        <div class="parent">
          <div class="child container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-12  text-center">
                    <img src="images/TravelMateLogo.png" style="max-width:300px;padding-bottom:15pt;"> 
                </div>
              <div class="col-xs-12 col-sm-12 text-center">
                <div class="panel panel-default center-me" style="max-width:300px;">
                  <!-- Default panel contents -->
                  <div class="panel-heading">You have logged out!</div>
            
                    <form action="toLogin" method="POST">
                        <input type="hidden" name="start"><br>
                        <input type=submit class="btn btn-primary btn-md" value="Head to login.">
                    </form>
                  </br></br>
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
    
    
<!--Deaktivieren des Back-Buttons-->
<script>
    window.location.hash="session ended";
    window.location.hash="session ended";//again because google chrome don't insert first hash into history
    window.onhashchange=function(){window.location.hash="noSession";};   };
</script> 

        
<%
    session.invalidate();
%>