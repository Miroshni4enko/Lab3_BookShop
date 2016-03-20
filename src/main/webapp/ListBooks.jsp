<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 19.03.2016
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <%  final int countBooksOnPages = 10;
        int amountOfBooks = 20; //get
        int countPages = 1;
        if (amountOfBooks > countBooksOnPages) { %>
        <form name="pages" method="post" action="">
            <%for (int i = countBooksOnPages * countPages;i > 0; i--) {%>
                <div class="book">
                    <form name="book" method="post" action="Buy"><p>
                        <b>get name</b>
                        <p align="right">
                        <input type="submit" value="Buy">
                        </p>
                        </p>
                    </form>
                </div>
                <br>
                <br>
            <% }%>
            <div style="text-align: center; margin: 15pt;">
                <input type="button" value="see more">
            </div>
        </form>
        <%} else {
            for (int i = 0;i < amountOfBooks; i++) {%>
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
            <% }
        } %>
</div>