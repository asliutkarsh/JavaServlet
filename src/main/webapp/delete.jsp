<%--
  Created by IntelliJ IDEA.
  User: utkar
  Date: 07-10-2022
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<%
  if (request.getParameter("click")!= null){
    Cookie l = null;
    Cookie[] ck = request.getCookies();
    if (ck!=null){
      for (Cookie c: ck) {
        if (c.getName().equals("name")) {
          l = c;
          break;
        }
      }
    }
    if (l !=null){
      l.setMaxAge(0);
      response.addCookie(l);
    }
    response.sendRedirect("main.jsp");
  }
%>
</body>
</html>
