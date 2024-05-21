<%@ page import="java.util.List" %>
<%@ page import="org.time.model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/21/2024
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- Khai báo sử dụng JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
</head>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Birth Date</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.birthDate}</td>
            <td>${customer.address}</td>
            <td>${customer.image}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
