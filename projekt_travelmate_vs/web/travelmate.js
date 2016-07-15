/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function $(id) {
    return document.getElementById(id);
}

function getHttpRequest(url) {
    var xmlhttp = null;
    // Mozilla
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    // IE
    else if (window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
   
    xmlhttp.open("GET", url, true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState != 4) {
            //$('posters').innerHTML = 'Seite wird geladen ...';
        }
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            //$('posters').innerHTML = xmlhttp.responseText;
           
            console.log("xmlhttp.readyState == 4 && xmlhttp.status == 200");
            
           xmlhttp.open("GET", url, true);
           xmlhttp.setRequestHeader("Content-type", "application/json");
           
           xmlhttp.send(null);    
        }
    }
    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.send(null);
}

function postHttpRequest(url) {
    var xmlhttp = null;
    // Mozilla
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    // IE
    else if (window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST", url, true);
    xmlhttp.send($('login_mail').value);
    xmlhttp.send($('login_pw').value);
}

function putHttpRequest(url, id) {
   var xmlhttp = null;
    // Mozilla
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    // IE
    else if (window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    xmlhttp.open("PUT", url, true);
    xmlhttp.send($('input_field_' + id).value + "id=" + id);
}

function deleteHttpRequest(url, id) {
    var xmlhttp = null;
    // Mozilla
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    // IE
    else if (window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    xmlhttp.open("DELETE", url, true);
    xmlhttp.setRequestHeader("id", id);
    xmlhttp.send();
}