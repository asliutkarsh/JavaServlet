<%--
  Created by IntelliJ IDEA.
  User: utkar
  Date: 25-08-2022
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="" method="post">
        Enter Name :- <input type="text" name="fname" /> <br/>
        Enter Age :- <input type="number" name="age"/> <br/>
        Enter Email :- <input type="text" name="email" /> <br/>
        Enter Password :- <input type="password" name="password" /> <br/>
        Gender :- <input type="radio" name="gender" value="male"/>Male
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="gender" value="female"/>Female <br>
        Hobbies :- <input type="checkbox" name="hobby" value="reading"> Reading
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="cooking"> Cooking
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="gaming"> Gaming
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="checkbox" name="hobby" value="browsing"> Browsing <br>
        Country:- <select name="country" id="">
            <option value="select">Select Country</option>
            <option value="INDIA"> INDIA </option>
            <option value="US"> US </option>
            <option value="UK"> UK </option>
            <option value="Others"> Others </option>
        </select> <br> <br>
        <input type="submit" name="register" value="Register">
    </form>
    <%
        if (request.getParameter("register")!=null){%>
            <jsp:useBean id="user2" class="dto.User2" scope="request"/>
            <jsp:setProperty name="user2" property="*"/>
            <jsp:forward page="RegisterServlet"/>
        <%}
    %>
</body>
</html>
