<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 19.03.2016
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">

    <% for (int i=0;i < 5; i++) {%>
    <div class="book">
    <form name="book" method="post" action="Buy">
        <p>
            <b>get name</b>
            <p align="right">
                <input type="submit" value="Buy">
            </p>
        </p>
    </form>
    </div>
    <br>
    <% } %>
</div>