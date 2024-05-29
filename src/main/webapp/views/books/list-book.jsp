<%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/28/2024
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1>Danh sach books</h1>
<a href="books?action=ADD"> THEM SACH</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Stock</th>
        <th scope="col">Category</th>
        <th scope="col">TotalPages</th>
        <th scope="col">YearCreated</th>
        <th scope="col">Author</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.stock}</td>
            <c:forEach items="${categories}" var="category">
                <c:if test="${category.id == book.category_id}">
                    <td>${category.name}</td>
                </c:if>
            </c:forEach>
            <td>${book.totalPages}</td>
            <td>${book.yearCrated}</td>
            <td>${book.author}</td>
            <td>${book.status}</td>
            <td><a href="/books?action=EDIT&id=${book.id}" class="btn btn-warning">Edit</a></td>
            <td><a href="/books?action=DELETE&id=${book.id}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoa ko')">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
