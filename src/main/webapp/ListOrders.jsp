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
        <%  List<Order> listOrders;
        try {
            Customer cus = (Customer) request.getSession().getAttribute(LoginUser.ATTRIBUTE_CUSTTOMER);
            //System.out.println(cus);
            listOrders = OracleDataAccess.getInstance().getAllOrder();
            //System.out.println(listOrders);
        } catch (Exception e) {
            listOrders = null;
        }
        if (listOrders != null || listOrders.size() == 0) {
        for (Order order : listOrders) {%>
    <div class="book">
        <form name="order" method="GET" action="MainServlet?action=Buy"><p><%--/////////////////////////////////--%>
            <b>
                <a href="<%="MainServlet?action=viewDetailBooks&IdDetail=" + order.getIdOrder() %>"><%= order.getContents().get(0).getBooks().getName()%></a>
            </b>
            </p>
            </form>
            </div>
    <%}%>
    <%} else { %>
    List of books is empty.
    <br>
    <br>
    <%}%>
</div>
</body>
</html>
