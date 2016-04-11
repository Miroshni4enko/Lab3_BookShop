<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>

<html>
<head>
    <title>Error</title>
</head>
    <body bgcolor="white">
        <p><% exception.getCause(); %>
        </p>
        <p>Details:
            </br> <% exception.printStackTrace(response.getWriter()); %>
        </p>
    </body>
</html>