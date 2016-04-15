<%@ page import="model.Item" %>
<%@ page import="java.util.*" %><%--
    Document   : Sidebar
    Author     : Sasha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <p>
        Category:
        <%/*List<String> list = new ArrayList<>();
            list.add("c1");
            list.add("c2");
            list.add("c3");
        List<String> list2 = new ArrayList<>();
            list2.add("rrr1");
            list2.add("rrr2");
            list2.add("rrr3");
        TreeMap list3 = (TreeMap) request.getSession().getAttribute("Category");
        */
        ArrayList<Item> section = (ArrayList) request.getSession().getAttribute("Section");
        HashMap<Item,ArrayList<Item>> list3 = (HashMap) request.getSession().getAttribute("Category");
        %>
        <% /*for (String l : list)*/
        for (Item it : section) { %>
            <li><%= it.getName() /*l*/ %>
                <ul>
                    <% /*for (String l2 : list2)*/
                        for (int i=0; i<=list3.get(it).size()-1;i++)  { %>
                    <li><%= list3.get(it).get(i).getName()/*l2*/ %></li>
                    <%}%>
                </ul>
            </li>
        <%}%>
    </p>
</div>
