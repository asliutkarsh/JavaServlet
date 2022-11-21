<%--
  Created by IntelliJ IDEA.
  User: utkar
  Date: 07-10-2022
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%
    Cookie name = new Cookie("name",request.getParameter("name").split(" ")[0]);
    response.addCookie(name);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Page</title>
</head>
<body>
    <h2> First Page</h2>
    <p><b>Welcome </b><%= request.getParameter("name")%></p>
    <a href="two.jsp">Next</a>

</body>
</html>
