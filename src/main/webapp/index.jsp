<%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/20/2024
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Product Discount Calculator</h1>
    <form action="/LoginServlet" method="post">
       <label>Product Description:</label><br/>
        <input type="text" name="description" required> <br/>
        <label>List Price:</label><br/>
        <input type="number" name="price" required> <br/>
        <label>Discount Percent:</label><br/>
        <input type="number" name="discount_percent" required> <br/>
        <input type="submit" value="Calculate Discount">
    </form>
</body>
</html>
