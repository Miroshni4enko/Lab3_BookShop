<%--
    Document   : Menu
    Author     : Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="menu">
    <p class="leftstr">
        <a href="index.jsp">Shop</a> |
        <a href="index.jsp">About us</a>
    </p>
    <p class="rightstr">
        <a href="index.jsp"><%
            boolean login;
            try{
                login = (boolean) request.getSession().getAttribute("login");//login!!!!!!!!!!!!!!!
            } catch (Exception e){
                login = false;
            }
                if (login == true) { %>
                <a href="index.jsp">Exit</a>
                <a href="showProfile.jsp">Profile</a>
            <%} else {%>
                <a href="Login.jsp">Entry</a>
                <a href="showProfile.jsp">Registration</a>
            <%}%>
        </a>
    </p>
</div>