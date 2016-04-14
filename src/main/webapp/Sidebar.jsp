<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.Comparator" %><%--
    Document   : Sidebar
    Author     : Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <p>
        Category:
        <%List<String> list = new ArrayList<>();
            list.add("c1");
            list.add("c2");
            list.add("c3");
        List<String> list2 = new ArrayList<>();
            list2.add("rrr1");
            list2.add("rrr2");
            list2.add("rrr3");
        TreeMap list3 = (TreeMap) request.getSession().getAttribute("Category");
        %>
        <% for (String l : list) { %>
            <li><%= l %>
                <ul>
                    <% for (String l2 : list2) { %>
                    <li><%= l2 %></li>
                    <%}%>
                </ul>
            </li>
        <%}%>
    </p>
</div>
