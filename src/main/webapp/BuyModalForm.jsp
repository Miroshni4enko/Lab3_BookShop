<%--
  Created by IntelliJ IDEA.
  User: Слава
  Date: 20.04.2016
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Customer" %>
<%@ page import="controller.processors.AddCustomer" %>
<%@ page import="controller.processors.AddOrder" %>
<%@ page errorPage="errorPage.jsp"%>


<div id="modal_form">
    <div >
        <h3>Do you want to buy a book?<br>Write your phone number and <br> e-mail!</h3>
    </div>
    <div >
        <%Customer cus = (Customer) request.getSession().getAttribute("customer");%>
        <form name = "buy_form" method="post" action="<%="MainServlet?action=addOrder&IdDetail=" + book.getId()%>">
            <p class="prob"><input type="text" name ="<%=AddCustomer.CUS_PHONE %>" <%=cus!=null?"value=" + cus.getPhone():"placeholder=phone" %> /></p>
            <p class="prob"><input type="email" name="<%=AddCustomer.CUS_E_MAIL %>" <%=cus!=null?"value=" + cus.getMail():"placeholder=email"%> /></p>
            <p class="prob"><input type="number" name="<%=AddOrder.Book_Amount %>" placeholder="amount" /></p>
          <div>  <input class="btn" type="submit"  value="Buy book" /></div>
        </form>
    </div>
                    <span id="modal_close">
                        <a class="close"  title="Close" >X</a>
                    </span>

</div>
<div id="overlay"></div>