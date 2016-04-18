<%@ page import="controller.processors.LoginUser" %><%--
    Document   : Menu
    Author     : Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="menu">
    <p class="leftstr">
        <a href="index.jsp">Shop</a> |
        <a href="AboutUs.jsp">About us</a>
    </p>
    <p class="rightstr">
        <a href="index.jsp"><%
            String login = (String) request.getSession().getAttribute(LoginUser.ATTRIBUTE_LOGIN);
                if (!login.equals("false")) { %>
                <a href="showProfile.jsp"><%=login%></a>
                <a href="/">Exit</a>        <%--  НА ВЕЛКОМ --%>
            <%} else {%>
                <a href="Login.jsp">Entry</a>
                <a href="showProfile.jsp">Registration</a>
            <%}%>
        </a>
    </p>
</div>