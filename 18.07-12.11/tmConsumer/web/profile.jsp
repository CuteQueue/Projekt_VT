<%-- 
    Document   : profile
    Created on : 09.08.2016, 15:23:39
    Author     : Nina & Manuela
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
        function meldung(){
              alert("No valid session, please login!");
              location= window.location.href='Index';
            };
        
        //Wurde in der DB kein Bild gefunden, wird blank-profile-picture als Alternative ausgegeben 
        function noImage() {
            document.getElementById('foo').src='images/blank-profile-picture-973460_1280.png';
        };
    </script>
    <link rel="stylesheet" href="css/css02.css" type="text/css">
    
    
    </head>
      <% 
        //Prüfen, ob gültige session vorhanden ist.
        HttpSession nsession = request.getSession(true);
        if(nsession.getAttribute("email")==null) {
            %><script>meldung();</script><%     
        } 
        
        //Prüfen, ob Profil des eingeloggten Users oder fremdes Profil angezeigt werden soll
        String foreignProfile = null;
        User u = new User((String) session.getAttribute("email"));
        User user = (User) session.getAttribute("user");
        if(!u.getEmail().equals(user.getEmail())){
            session.setAttribute("email", user.getEmail());
            foreignProfile = "yes";
        }
        u.getProfileData(); //Profildaten holen
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
                <!-- Markierung der Navbar setzen, je nachdem, ob man über search oder über profile ein Profil anschaut -->
                <% if(foreignProfile ==null){
                    out.println("<li class=\"active\"><a href=\"toProfil\">Profile<span class=\"sr-only\">(current)</span></a></li>\n" +
                    "                <li><a href=\"toSearch\">Search</a></li>");
                }else{
                    out.println("<li><a href=\"toProfil\">Profile</a></li>\n" +
                    "                <li class=\"active\"><a href=\"toSearch\">Search<span class=\"sr-only\">(current)</span></a></li>");
                }
                %>
                
                <li><a href="${pageContext.request.contextPath}/Inbox">Messages</a></li>
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
                <div class="col-xs-12 col-sm-5 col-md-5 abstand">
                    <% int user_id = u.getUser_id();%>
                       <img id="foo" src="/tmConsumer/getImageServlet?user_id=<%out.println(user_id);%>" class="img-fluid img-rounded pull-xs-left profile-img" onerror="noImage()"/>
                </div>
                <div class="col-xs-3 col-sm-2 col-md-2 ">
                  <table class="table abstand table-borderless">
                    <tbody>
                      <tr>
                        <td><h4><font color="#2a96c0">Profile </font><h4></td>
                      </tr>
                      <tr>
                        <td>Name: </td>
                      </tr>
                      <tr>
                        <td>Last&nbspname: </td>
                      </tr>
                      <tr>
                        <td>Nickname: </td>
                      </tr>
                      <tr>
                        <td>Age: </td>
                      </tr>
                      <tr>
                        <td>Gender: </td>
                      </tr>

                    </tbody>
                  </table>
                </div> 
                <div class="col-xs-5 col-sm-5 col-md-5 ">
                  <table class="table abstand table-borderless">
                    <tbody>
                      <tr>
                        <td><h4></br><h4></td>
                      </tr>
                      <tr>
                        <td>
                            <%  
                                out.println(u.getName());
                            %> 
                        </td>
                      </tr>
                      <tr>
                          <td>
                              <% 
                                out.println(u.getLast_name());
                              %> 
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <% 
                                out.println(u.getNickname());
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                if(u.getAge()==0){
                                    out.println("---");
                                }else{
                                    out.println(u.getAge());
                                }
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                if(u.getSex()==null){
                                    out.println("---");
                                }else{
                                    out.println(u.getSex());
                                }
                              %> 
                          </td>
                      </tr>

                    </tbody>
                  </table>
                </div> 
              </div>

              <div class="row center-me profilesheet-about" >
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                  <table class="table abstand table-borderless">
                    <tbody>
                      <tr>
                        <td><h4><font color="#2a96c0">About&nbspme</font><h4></td>
                      </tr>
                      <tr>
                        <td>
                            <% 
                              if(u.getAbout()==null){
                                out.println("---");
                              }else{
                                out.println(u.getAbout());
                              }
                            %> 
                        </td>
                      </tr>
                      
                    </tbody>
                  </table>
                </div>
              </div>

              <div class="row center-me profilesheet-bottom" >
                <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">
                  <table class="table abstand table-borderless">
                    <tbody>
                      <tr>
                        <td><h4><font color="#2a96c0">My&nbsptravel&nbspplans</font><h4></td>
                      </tr>
                      <tr>
                        <td>Current&nbsplocation: </td>
                      </tr>
                      <tr>
                        <td>Next&nbspdestination: </td>
                      </tr>
                      <tr>
                        <td>Startdate: </td>
                      </tr>
                      <tr>
                        <td>Looking&nbspfor: </td>
                      </tr>
                      <tr>
                        <td>Interests: </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="col-xs-7 col-sm-7 col-md-9 col-lg-9">
                  <table class="table abstand table-borderless">
                    <tbody>
                      <tr>
                        <td><h4></br><h4></td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                if(u.getLocation()==null){
                                    out.println("---");
                                }else{
                                    out.println(u.getLocation());
                                }
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                if(u.getDestination()==null){
                                    out.println("---");
                                }else{
                                    out.println(u.getDestination());
                                }
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                if(u.getStartdate()==null){
                                    out.println("---");
                                }else{
                                    out.println(u.getStartdate());
                                }
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                if(u.getLooking_for()==null){
                                    out.println("---");
                                }else{
                                    out.println(u.getLooking_for());
                                }
                              %> 
                        </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                if(u.getInterests()==null){
                                    out.println("---");
                                }else{
                                    out.println(u.getInterests());
                                }
                              %> 
                          </td>
                      </tr>
                    </tbody>
                  </table>
                </div> 
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                  <table class="table table-borderless">
                    <tbody>
                      <tr>
                        <td>
                            <%
                                if(foreignProfile ==null){
                                    out.println("<input type=\"button\" class=\"btn btn-primary btn-s\" style=\"margin-top:5px;\" onclick=\"window.location.href='Edit'\" value=\"edit profile\" name=\"button\" id=\"button\"/>");
                                    out.println("<input type=\"button\" class=\"btn btn-primary btn-s\" style=\"margin-top:5px;\" onclick=\"window.location.href='uploadImage.jsp'\" value=\"upload Image\" name=\"button2\" id=\"button2\"/>");
                                }else{
                                    foreignProfile=null;
                                    session.setAttribute("chatPartnerId", u.getId()); 
                                    session.setAttribute("chatPartnerName", u.getName()); 
                                    out.println("<button type=\"button\" class=\"btn btn-primary btn-s center-block\" onclick=\"window.location.href='newMessage.jsp'\"><span class=\"glyphicon glyphicon-envelope\"></span> Contact</button>");
                                }
                            %> 
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
            </div>
        </br></br>
        </div>
    </body>
</html>