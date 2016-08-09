<%-- 
    Document   : index
    Created on : 18.07.2016, 11:36:16
    Author     : manuela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
   <script>
        function store() {
            var serverIp = document.getElementById('serverIp').value;

            // Save the name in localStorage.
            localStorage.setItem('serverIp', serverIp);
            //alert(localStorage.getItem('serverIp'));
        };
        
        function add(){
            var href = window.location.href ;
            var l = document.createElement("a");
            l.href = href;
            var host = l.hostname;
            
            var TheTextBox = document.forms[0].elements['serverIp']; //I think that's right, haven't done it in a while
            TheTextBox.value = host;
        };
        
    </script>
    
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
                  <div class="panel-heading">Server-IP</div>
                    <form id="IP" action="Start" method="POST">
                      <br>
                      <input type="text" style="width:180px" name="serverIp" id="serverIp" onchange="store()" placeholder="e.g. 127.0.0.1" required>
                          <br><br>
                          <input type="button" class="btn btn-primary btn-s" onclick="add()" value="import from url" name="button" id="button"  />​ 
                        <input type=submit class="btn btn-primary btn-s" value="Submit">
                      <br><br>
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

<!-- Umleitung bei Nutzung des Back-Buttons
<script>
    (function(window, location) {
        var href = window.location.href ;
        var l = document.createElement("a");
        l.href = href;
        var host = l.hostname;
        
        history.replaceState(null, document.title, location.pathname+"#!/history");
        history.pushState(null, document.title, location.pathname);

        window.addEventListener("popstate", function() {
          if(location.hash === "#!/history") {
            history.replaceState(null, document.title, location.pathname);
            setTimeout(function(){
              location.replace("http://"+host+":8080/tmConsumer");
            },0);
          }
        }, false);
    }(window, location));
</script>-->



