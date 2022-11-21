<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: utkar
  Date: 18-10-2022
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Tag </title>
</head>
<body>
<h3>JSP scriptlet tag</h3><br>
<% out.print("This is an example of jsp scriptlet tag"); %><br><br>

<h3>JSP expression  tag</h3><br>
<p>Current Date is <%=new Date()%></p><br><br>

<h3>JSP declaration  tag</h3><br>
<%!
    int square(int n){
        return n*n;
    }
%>
<%= "Square of 5 is:"+square(5) %>

</body>
</html>
