<%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/28/2024
  Time: 2:07 PM
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
<h1>Danh sach Danh Muc</h1>
<a href="/category?action=ADD">Thêm Danh Mục</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Status</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${category.name}</td>
            <td>${category.status}</td>
            <td><a href="/category?action=EDIT&id=${category.id}" class="btn btn-warning">Edit</a></td>
            <td><a href="/category?action=DELETE&id=${category.id}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoa ko')">Delete</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
