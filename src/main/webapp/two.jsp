<%--
  Created by IntelliJ IDEA.
  User: utkar
  Date: 07-10-2022
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second Page</title>
</head>
<body>
  <h2> Seond Page</h2>
  <%
    Cookie[] cookies = request.getCookies();
    String value ="";
    if (cookies != null){
      for (Cookie c:cookies) {
        if (c.getName().equals("name")) {
          value = c.getValue();
        }
      }
    }
  %>
  <p><b>Welcome </b><%= value%></p>
  <form action="delete.jsp">
    <input type="submit" name="click" value="Delete Coookies">
  </form>
</body>
</html>
