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
            if ( request.getSession().getAttribute("login").equals(false) ) {%>     //login!!!!!!!!!!!!!!!
                <a href="Login.jsp">Entry</a>
            <%} else {%>
                <a href="index.jsp">Exit</a>
                <% request.getSession().setAttribute("login", false);
            }%>
        </a>
    </p>
</div>