<%-- 
    Document   : newMessage
    Created on : 08.08.2016, 13:52:19
    Author     : nina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Message</title>
    </head>
    <body>
        <form action=SendNewMessage method=post>
            <table border=0 width=35% align=center>
                <caption><h2>Send New Message</h2></caption>
                <tr>
                    <td><input type="hidden" name="chatPartnerId" value=chatPartnerId size="50"/></td>
                    <td><input type="hidden" name="chatPartnerId" value=chatPartnerName size="50"/></td>
                </tr>
                <tr>
                    <td><textarea rows="10" cols="39" name="content"></textarea> </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Send"/></td>
                </tr>
            </table>

        </form>
    </body>
</html>
