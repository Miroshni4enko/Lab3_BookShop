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
<div id="login">
    <div >
        <div class="form-signup">
            <h1>Registration</h1>
            <fieldset>

                <form>
                    <input type="text" placeholder="login" required />
                    <input type="password" placeholder="password" required />
                    <input type="email" placeholder="email " required />
                    <input type="text" placeholder="telephone" required />
                    <input type="submit" value="sign up" />
                </form>
            </fieldset>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp" />
</body>
</html>
