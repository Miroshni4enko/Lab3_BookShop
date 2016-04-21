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
        <form name = "edit_form" method="post" action="<%=isEdit?"MainServlet?action=updateBook&IdDetail=" + book.getId():"MainServlet?action=addBook"%>">

            <p class="prob">
                <div><label for="<%=UpdateBook.BOOK_NAME + "ID"%>">Name</label></div>
                <input type="text" id ="<%=UpdateBook.BOOK_NAME+"ID"%>"  name ="<%=UpdateBook.BOOK_NAME%>"
                    <%=isEdit?"value=" + "\"" +  book.getName() +"\"":"placeholder=\"Book name\"" %> />
                </label>
            </p>

            <p class="prob">
               <div> <label for="<%=UpdateBook.BOOK_AMOUNT + "ID"%>">Amount</label></div>
                <input type="number" id ="<%=UpdateBook.BOOK_AMOUNT+"ID"%>" name="<%=UpdateBook.BOOK_AMOUNT%>"
                        <%=isEdit?"value=" + "\""+ book.getAmount()+ "\"":"placeholder=\"amount\"" %> />
            </p>

            <p class="prob">
                <div><label  for="<%=UpdateBook.BOOK_PAGES + "ID"%>">Pages</label></div>
                <input id ="<%=UpdateBook.BOOK_PAGES+"ID"%>" type="number" name="<%=UpdateBook.BOOK_PAGES%>"
                    <%=isEdit?"value="+ "\"" + book.getPages()+ "\"":"placeholder=\"pages\"" %>/>
            </p>

            <p class="prob">
                <div><label for="<%=UpdateBook.BOOK_AUTHOR_NAME + "ID"%>">Author name </label></div>
                <input id ="<%=UpdateBook.BOOK_AUTHOR_NAME+"ID"%>" type="text" name ="<%=UpdateBook.BOOK_AUTHOR_NAME%>"
                    <%=isEdit?"value=" + "\""+ book.getAuthor().getName()+ "\"":"placeholder=\"Author name\"" %>/>
            </p>

            <p class="prob">
               <div><label for="<%=UpdateBook.BOOK_AUTHOR_SURNAME + "ID"%>">Author surname </label></div>
                <input id ="<%=UpdateBook.BOOK_AUTHOR_SURNAME+"ID"%>" type="text" name ="<%=UpdateBook.BOOK_AUTHOR_SURNAME%>"
                    <%=isEdit?"value=" + "\""+ book.getAuthor().getSurname()+ "\"":"placeholder=\"Author surname\"" %>/>
            </p>

            <p class="prob">
                <div><label for="<%=UpdateBook.BOOK_PRICE + "ID"%>">Price </label></div>
                <input id ="<%=UpdateBook.BOOK_PRICE+"ID"%>" type="number" name ="<%=UpdateBook.BOOK_PRICE%>"
                    <%=isEdit?"value="+ "\"" + book.getPrice()+ "\"":"placeholder=\"price\"" %>/>
            </p>

            <p class="prob">
                 <div><label for="<%=UpdateBook.BOOK_DESCRIPTION + "ID"%>">Description </label></div>
                <input id ="<%=UpdateBook.BOOK_DESCRIPTION+"ID"%>" type="text" name ="<%=UpdateBook.BOOK_DESCRIPTION%>"
                    <%=isEdit?"value=" + "\""+ book.getDescription()+ "\"":"placeholder=\"description\"" %>/>
            </p>
            <p class="prob">
            <div><label for="<%=UpdateBook.BOOK_RUBRIC_NAME + "ID"%>">Rubric</label></div>
            <input id ="<%=UpdateBook.BOOK_RUBRIC_NAME+"ID"%>" type="text" name ="<%=UpdateBook.BOOK_RUBRIC_NAME%>"
                    <%=isEdit?"value=" + "\""+ book.getParent().getName()+ "\"":"placeholder=\"rubric\"" %>/>
            </p>

            <div class="prob">  <input class="btn" type="submit"  value="<%=isEdit?"Edit book":"Create book"%>" /></div>
        </form>
    </div>
                    <span id="edit_modal_close">
                        <a class="close"  title="Close" >X</a>
                    </span>

</div>
<div id="overlay"></div>