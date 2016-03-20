<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 19.03.2016
  Time: 15:27
  To change this template use File | Settings | File Templates.
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