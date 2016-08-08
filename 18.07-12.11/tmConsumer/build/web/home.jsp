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
       </div>     


        <div class="fixed-bg container">
              <div class="row center-me profilesheet" >
                <div class="col-xs-12 col-sm-5 col-md-5 abstand">
                  <img src="images/blank-profile-picture-973460_1280.png" class="img-fluid img-rounded pull-xs-left profile-img" alt="responsive img">
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
                                User u = new User((String) session.getAttribute("email"));
                                User user = (User) session.getAttribute("user");
                                u.getProfileData(); //Profildaten holen
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
                                out.println(u.getAge());
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                out.println(u.getSex());
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
                              out.println(u.getAbout());
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
                                out.println(u.getLocation());
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                out.println(u.getDestination());
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                out.println(u.getStartdate());
                              %> 
                          </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                out.println(u.getLooking_for());
                              %> 
                        </td>
                      </tr>
                      <tr>
                        <td>
                              <% 
                                out.println(u.getInterests());
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
                            <input type="button" class="btn btn-primary btn-s" style="margin-top:5px;" onclick="window.location.href='Edit'" value="edit profile" name="button" id="button"/>​
                        </td>
                      </tr>
                    </tbody>
                  </table>
              </div>
        </div></br></br>
    </body>
</html>

