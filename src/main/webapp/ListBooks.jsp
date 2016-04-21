<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<%@ page import="Servlet.Commands" %>
<%@ page import="controller.processors.DetailBook" %>
<%@ page errorPage="errorPage.jsp"%>
<%--
    Document   : ListBooks
    Author     : Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  Boolean isAdmin = false;
    String buttonName;
    try {
        Customer cus = (Customer) session.getAttribute("customer");
        buttonName = "Buy";
        if(cus.getRole() == 10){
            isAdmin = true;
            buttonName = "Delete";
        }
    } catch (NullPointerException e1){
        isAdmin = false;
        buttonName = "Buy";
    }
%>
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
                 <p>
                    <b>
                        <a href="<%="MainServlet?action=" + Commands.ACTION_DETAIL +
                            "&" + DetailBook.ID_DETAIL + "=" + book.getId() %>"><%= book.getName() %></a>
                        </a>
                    </b>
                    <p align="right">
                    <a href="#" id="go" >
                    <input type="submit" value="<%=buttonName%>">
                    </a>
                <%if( isAdmin) {
                    request.getSession().setAttribute("AuthorID",book.getAuthor().getId());
                    request.getSession().setAttribute(UpdateBook.BOOK_RUBRIC,book.getParent());
                %>

                <%@include file="Warning.jsp"%>
                <%}else {%>
                <%@include file="BuyModalForm.jsp"%>
                <%}%>
                    </p>
                    </p>
            </div>
            <br>
        <%}%>
            <center>
           <%--     <% if( !(Commands.AMOUNT_OF_BOOKS_ON_LIST >= listOfAllBooks.size()) ) {%> --%>
                    <a href="MainServlet?action=viewListBooks">view more books</a>
              <%--  <%}%> --%>
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
