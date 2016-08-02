<%-- 
    Document   : createProfile
    Created on : 20.07.2016, 13:48:08
    Author     : nina
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="-1">
        <title>Create Profile</title>
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/jquery/jquery.min.js"></script>
        <script language="javascript" type="text/javascript"> </script>
        
        
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

            window.onload = load;
            var ids = ['mobilenumber', 'age', 'location', 'destination', 'startdate', 'interests', 'looking_for', 'about'];
            var idsCheck = ['male', 'female'];

            ///Eingegebene Daten im LocalStorage hinterlegen
            function store() {
                for (i = 0; i < ids.length; i++) { 
                    var data = ids[i];
                    var value = document.getElementById(data).value;

                    // Save the name in localStorage.
                    localStorage.setItem(data, value);
                    //alert(localStorage.getItem(data));
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
            
            ///Wert für gewählte Checkbox im localStorage setzen
            function setStatus() {
                if(document.getElementById('female').checked) {
                    localStorage.setItem('female', "store");
                    localStorage.setItem('male', "unstore");
                    //alert("female: " + localStorage.getItem('female'));
                } else {
                    localStorage.setItem('male', "store");
                    localStorage.setItem('female', "unstore");
                    //alert("male: " + localStorage.getItem('male'));
                }
            };
            
            ///Checkboxen prüfen und localStorage abfragen
            function checkBoxes(){
                var getStatus = localStorage.getItem('female');
                if (getStatus === "store") {
                    document.getElementById("female").checked = true;
                } else {
                    document.getElementById("male").checked = true;
                }   

            };
            
        </script>
    </head>
    <body>
        <form action="CreateProfile" method = "POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>Create Profile</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Mobilenumber:</td>
                        <td><input type="number" name="mobilenumber" id="mobilenumber" onchange="store()" value="" /></td>
                    </tr>
                    <tr>
                        <td>Age:</td>
                        <td><input type="number" name="age" value="" id="age" onchange="store()" /></td>
                    </tr>
                    <tr>
                        <td>Location:</td>
                        <td><input type="text" name="location" value="" id="location" onchange="store()"/></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>

                        <td><input type="radio" name="sex" value="male" id="male" onclick="setStatus()" checked> Male<br></td>
                        <td><input type="radio" name="sex" value="female" id="female" onclick="setStatus()"> Female<br></td>
                    </tr>
                    <tr>
                        <td>Destination:</td>
                        <td><input type="text" name="destination" value="" id="destination" onchange="store()"/></td>
                    </tr>
                    <tr>
                        <td>Startdate:</td>
                        <td><input type="date" name="startdate" value="" id="startdate" onchange="store()" /></td>
                    </tr>
                    <tr>
                        <td>Interests:</td>
                        <td><input type="text" name="interests" value=""  id="interests" onchange="store()"/></td>
                    </tr>
                    <tr>
                        <td>Looking for:</td>
                        <td><input type="text" name="looking_for" value=""  id="looking_for" onchange="store()"/></td>
                    </tr>
                    <tr>
                        <td>About</td>
                        <td><input type="text" name="about" value=""  id="about" onchange="store()"/></td>
                    </tr
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Create Profile" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
         
    </body>

</html>
