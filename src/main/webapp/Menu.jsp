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
            if (true) {%>
                entry
            <%} else {%>
                exit
            <%}%>
        </a>
    </p>

</div>