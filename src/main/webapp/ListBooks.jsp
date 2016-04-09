<%@ page import="model.Book" %>
<%@ page import="java.util.List" %><%--
    Document   : ListBooks
    Author     : Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <%     List<Book> listOfAllBooks = (List<Book>) request.getSession().getAttribute("listOfAllBooks");
        for (Book book:listOfAllBooks) {%>
            <div class="book">
                <form name="book" method="GET" action="MainServlet?action=Buy"><p>/////////////////////////////////
                    <b>
                        <a href="MainServlet?action=viewDetailBooks"><%= book.getName() %></a>//////////

                    </b>
                    <p align="right">
                        <input type="submit" value="Buy">//////////////////////
                    </p>
                    </p>
                </form>
            </div>
            <br>
            <br>
        <%} %>
    <br>
    <br>
    <a href="MainServlet?action=viewListBooks">view more books</a>//////////////////////
    <br>
    <br>
</div>
