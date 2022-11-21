<%--
  Created by IntelliJ IDEA.
  User: utkar
  Date: 18-10-2022
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>JSTL Tag Example</title>
</head>
<body>
    <h3>JSTL Core "if" Tag</h3><br>
    <c:set var="income" scope="session" value="${4000*4}"/>
    <c:if test="${income > 8000}">
        <p>My income is: <c:out value="${income}"/><p><br>
    </c:if>

    <h3>JSTL Core "Choose", "When", "Otherwise" Tag</h3><br>
    <c:set var="income" scope="session" value="${4000*4}"/>
    <p>Your income is : <c:out value="${income}"/></p><br>
    <c:choose>
        <c:when test="${income <= 1000}">
            <p>Income is not good.</p><br>
        </c:when>
        <c:when test="${income > 10000}">
            <p>Income is very good.</p><br>
        </c:when>
        <c:otherwise>
            <p>Income is undetermined...</p><br>
        </c:otherwise>
    </c:choose>

    <h3>JSTL Function "split" Tag</h3>
    <c:set var="string" value="This is the first string."/>
    <p>${fn:substring(string, 5, 17)}</p><br>

    <h3>JSTL Function "toLowerCase", "toUpperCase Tag</h3>
    <c:set var="string" value="Welcome to JSP Programming"/>
    <p>${fn:toLowerCase("HELLO,")} ${fn:toLowerCase(string)}</p><br>

</body>
</html>
