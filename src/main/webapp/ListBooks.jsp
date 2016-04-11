<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page errorPage="errorPage.jsp"%>
<%--
    Document   : ListBooks
    Author     : Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <form name="book" method="GET" action="MainServlet?action=Buy"><p><%--/////////////////////////////////--%>
                    <b>
                         <a href="<%="MainServlet?action=viewDetailBooks&IdDetail=" + book.getId() %>"><%= book.getName() %></a>
                         </a>
                     </b>
                     <p align="right">
                         <input type="submit" value="Buy"><%--/////////////////////////////////--%>
                    </p>
                    </p>
                </form>
            </div>
            <br>

        <%}%>
            <center>
                <a href="MainServlet?action=viewListBook">view more books</a><%--/////////////////////////////////--%>
            </center>
        <%} else { %>
            List of books is empty.
            <br>
            <br>
        <%}%>
    <br>
    <br>
</div>
