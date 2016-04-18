<%@ page import="controller.processors.AddCustomer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Customer" %>
<%@ page errorPage="errorPage.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: Фокстрот
  Date: 05.04.2016
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <TITLE>login</TITLE>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reg.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>

<body>
<jsp:include page="Head.jsp" />
<jsp:include page="Menu.jsp" />
<%!List<String> list =null;%>
<% Customer cus  = (Customer) request.getSession().getAttribute("customer");
if(cus==null){
    list = new ArrayList<String> ();
    list.add("Registration");
    list.add("Login");
    list.add("Password");
    list.add("Email");
    list.add("Phone");
    list.add("Sign_up");
}else{
    list =new ArrayList<String> ();
    list.add("Profile");
    list.add(cus.getLogin());
    //System.out.println(cus.getLogin());
    list.add(cus.getPassword());
    list.add(cus.getMail());
    list.add(cus.getPhone());
    list.add("Edit");
}%>
<div id="login">
    <div >
        <div class="form-signup">
            <h1><%=list.get(0)%></h1>
            <fieldset>

                <form method="post" action="MainServlet?action=addCustomer">
                    <input type="text" name = "<%=AddCustomer.CUS_LOGIN%>" placeholder="<%=list.get(1)%>" required />
                    <input type="password" name = "<%=AddCustomer.CUS_PASSWORD%>" placeholder="<%=list.get(2)%>" required />
                    <input type="email" name = "<%=AddCustomer.CUS_E_MAIL%>" placeholder="<%=list.get(3)%>" required />
                    <input type="text" name = "<%=AddCustomer.CUS_PHONE%>" placeholder="<%=list.get(4)%>" required />
                    <input type="submit" value=<%=list.get(5)%> />
                </form>
            </fieldset>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp" />
</body>
</html>
