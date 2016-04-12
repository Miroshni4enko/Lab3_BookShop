<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
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
            listOfAllBooks = null;
        } catch (Exception e) {
            listOfAllBooks = null;
        }
        if (listOfAllBooks != null || listOfAllBooks.size() == 0) {
        for (Book book : listOfAllBooks) {%>
            <div class="book">
                <form name="book" method="GET" action="MainServlet?action=Buy"><p><%--/////////////////////////////////--%>
                    <b>
                        <a href="<%="MainServlet?action=viewDetailBooks&IdDetail=" + book.getId() %>"><%= book.getName() %></a>
                        </a>
                    </b>
                    <p align="right">
                    <a href="#" id="go" >
                    <input type="submit" value="Buy">
                    </a>

                    <div id="modal_form">
                    <div >
                        <h3>Do you want to buy a book?<br>Write your phone number and <br> e-mail!</h3>
                    </div>
                    <div >
                        <form>
                            <p class="prob"><input type="text" placeholder="telephone" /></p>
                            <p class="prob"><input type="text" placeholder="@mail" /></p>
                            <div><input class="btn" type="submit" value="Buy book" /></div>
                        </form>
                    </div>
                    <span id="modal_close">
                        <a class="close"  title="Close" >X</a>
                    </span>

                    </div>
                    <div id="overlay"></div>

                    </p>
                    </p>
                </form>
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
