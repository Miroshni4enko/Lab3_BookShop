<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<%@ page import="controller.processors.AddCustomer" %>
<%@ page import="controller.processors.AddOrder" %>
<%@ page errorPage="errorPage.jsp"%>
<%--
    Document   : ListBooks
    Author     : Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Modal</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
<div class="content">
    <%  List<Book> listOfAllBooks;
        try {
            listOfAllBooks = (List<Book>) request.getSession().getAttribute("listOfAllBooks");
        } catch (Exception e) {
            listOfAllBooks = null;
        }
        if (listOfAllBooks != null || listOfAllBooks.size() == 0) {
        for (Book book : listOfAllBooks) {%>
            <div class="book">
                 <p><%--/////////////////////////////////--%>
                    <b>
                        <a href="<%="MainServlet?action=viewDetailBooks&IdDetail=" + book.getId() %>"><%= book.getName() %></a>
                        </a>
                    </b>
                    <p align="right">
                    <a href="#" id="go" >
                    <input type="submit" value="Buy">
                    </a>
                        <%@include file="BuyModalForm.jsp"%>
                    </p>
                    </p>
            </div>
            <br>
        <%}%>
            <center>
                <a href="MainServlet?action=viewListBooks">view more books</a><%--/////////////////////////////////--%>
            </center>
        <%} else { %>
            List of books is empty.
            <br>
            <br>
        <%}%>
    <br>
    <br>
</div>
</body>
