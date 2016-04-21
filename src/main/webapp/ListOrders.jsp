<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="model.OracleDataAccess" %>
<%@ page import="model.Customer" %>
<%@ page import="controller.processors.AddCustomer" %>
<%@ page import="controller.processors.LoginUser" %>
<%@ page import="model.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Слава
  Date: 19.04.2016
  Time: 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Title</title>
</head>
<body>
<div class="order_content">
        <%List<Order> listOrders = null;
        try {
            //System.out.println(cus);
             listOrders = (List<Order>) request.getSession().getAttribute("listOfAllOrders");
            //System.out.println(listOrders);
        } catch (Exception e) {
            listOrders = null;
        }
        if (listOrders != null && listOrders.size() > 0) {
        for (Order order : listOrders) {%>
    <div class="book"> <p><%--/////////////////////////////////--%>
        <b>
            <a href="<%="MainServlet?action=viewDetailBooks" + order.getIdOrder() %>"><%= order.getContents().get(1).getBooks().getName() %></a>
            </a>
        </b>
        <p align="right">
            <a href="#" id="go" >
                <input type="submit" value="edit">
            </a>
            <%}%>
        </p>
        </p>
    </div>
    <br>
    <%} else { %>
    List of books is empty.
    <br>
    <br>
    <%}%>
    <br>
    <br>
</div>
</body>
</html>
