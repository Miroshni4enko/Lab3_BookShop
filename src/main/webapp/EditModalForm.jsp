<%--
  Created by IntelliJ IDEA.
  User: Слава
  Date: 20.04.2016
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Customer" %>
<%@ page import="controller.processors.AddCustomer" %>
<%@ page import="controller.processors.AddOrder" %>
<%@ page import="model.Book" %>
<%@ page import="controller.processors.UpdateBook" %>
<%@ page errorPage="errorPage.jsp"%>


<div id="edit_modal_form">
    <div>
        <h3>Change the fields that you need</h3>
    </div>
    <div >
        <form name = "edit_form" method="post" action="<%="MainServlet?action=editBook&IdDetail=" + book.getId()%>">

            <p class="prob">
                <div><label for="<%=UpdateBook.BOOK_NAME + "ID"%>">Name</label></div>
                <input type="text" id ="<%=UpdateBook.BOOK_NAME+"ID"%>"  name ="<%=UpdateBook.BOOK_NAME%>" value= "<%=book.getName() %>" />
                </label>
            </p>

            <p class="prob">
               <div> <label for="<%=UpdateBook.BOOK_AMOUNT + "ID"%>">Amount</label></div>
                <input type="number" id ="<%=UpdateBook.BOOK_AMOUNT+"ID"%>" name="<%=UpdateBook.BOOK_AMOUNT%>" value= "<%=book.getAmount() %>" />
            </p>

            <p class="prob">
                <div><label  for="<%=UpdateBook.BOOK_PAGES + "ID"%>">Pages</label></div>
                <input id ="<%=UpdateBook.BOOK_PAGES+"ID"%>" type="number" name="<%=UpdateBook.BOOK_PAGES%>" value= "<%=book.getPages() %>" />
            </p>

            <p class="prob">
                <div><label for="<%=UpdateBook.BOOK_AUTHOR_NAME + "ID"%>">Author name </label></div>
                <input id ="<%=UpdateBook.BOOK_AUTHOR_NAME+"ID"%>" type="text" name ="<%=UpdateBook.BOOK_AUTHOR_NAME%>" value= "<%=book.getAuthor().getName() %>" />
            </p>

            <p class="prob">
               <div><label for="<%=UpdateBook.BOOK_AUTHOR_SURNAME + "ID"%>">Author surname </label></div>
                <input id ="<%=UpdateBook.BOOK_AUTHOR_SURNAME+"ID"%>" type="text" name ="<%=UpdateBook.BOOK_AUTHOR_SURNAME%>" value= "<%=book.getAuthor().getSurname() %>" />
            </p>


            <p class="prob">
                <div><label for="<%=UpdateBook.BOOK_PRICE + "ID"%>">Price </label></div>
                <input id ="<%=UpdateBook.BOOK_PRICE+"ID"%>" type="number" name ="<%=UpdateBook.BOOK_PRICE%>" value= "<%=book.getPrice() %>" />
            </p>

            <p class="prob">
                 <div><label for="<%=UpdateBook.BOOK_DESCRIPTION + "ID"%>">Description </label></div>
                <input id ="<%=UpdateBook.BOOK_DESCRIPTION+"ID"%>" type="text" name ="<%=UpdateBook.BOOK_DESCRIPTION%>" value= "<%=book.getDescription() %>" />
            </p>

            <div class="prob">  <input class="btn" type="submit"  value="Edit book" /></div>
        </form>
    </div>
                    <span id="edit_modal_close">
                        <a class="close"  title="Close" >X</a>
                    </span>

</div>
<div id="overlay"></div>
