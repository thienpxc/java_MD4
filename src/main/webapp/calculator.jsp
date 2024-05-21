<%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/21/2024
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Result</title>
</head>
<body>
<c:if test="${not empty error}">
    <p>Error: ${error}</p>
</c:if>
<c:if test="${not empty result}">
    <p>Result: ${result}</p>
</c:if>
<a href="index.jsp">Back to calculator</a>
</body>
</html>
