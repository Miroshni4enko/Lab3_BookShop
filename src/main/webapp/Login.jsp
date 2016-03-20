<%--
  Created by IntelliJ IDEA.
  User: Слава
  Date: 20.03.2016
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>Book Shop</TITLE>
    <style type="text/css">
        <!--
        @import url("css/style.css");
        -->
    </style>
</HEAD>
<BODY>

<table border="2" cellspacing="1" cellpadding="15" align="center" class="head">
    <tr>
        <td>
            <FORM NAME="login" ACTION="/Servlet?">
                <hr >
                Name:<BR>
                <INPUT TYPE="text" NAME="username" VALUE="" SIZE="17" MAXLENGTH="60">
                <hr>
                Password:<BR>
                <INPUT TYPE="password" SIZE="17" NAME="password">
                <hr >
                <center>
                    <INPUT TYPE="submit" VALUE=" Enter "><br>
                    <INPUT TYPE="reset" name="" value="  Clean  ">
                <center>
            </FORM>
        </td>
    </tr>

</table>
</BODY>
</HTML>

