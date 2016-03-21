<%--
    Document   : Login
    Author     : Slava, Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>login</TITLE>
    <style type="text/css">
        <!--
        @import url("css/style.css");
        -->
    </style>
</HEAD>
<BODY>
<jsp:include page="Head.jsp" />
<jsp:include page="Menu.jsp" />

<table border="2" cellspacing="1" cellpadding="15" align="center" class="login">
    <tr>
        <td>
            <FORM NAME="login" ACTION="/Servlet?">
                <hr>
                Name:<BR>
                <INPUT TYPE="text" NAME="username" VALUE="" SIZE="17" MAXLENGTH="60">
                <hr>
                Password:<BR>
                <INPUT TYPE="password" SIZE="17" NAME="password">
                <hr>
                    <INPUT TYPE="submit" VALUE=" Enter ">
                    <INPUT TYPE="reset" name="" value="  Clean  ">
            </FORM>
        </td>
    </tr>

</table>
</BODY>
</HTML>

