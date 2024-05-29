<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/22/2024
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<h1>Thêm mới Books</h1>
<a href="/books?action=LIST">Quay lại</a>
<form action="/books?action=EDIT"  method="post" >
    <div class="mb-3">
        <label for="id" class="form-label">Books Id</label>
        <input type="text" class="form-control" value="${book.id}" id="id" name="id" readonly>
    </div>
    <div class="mb-3">
        <label for="category" class="form-label">Category</label>
        <select class="form-control" id="category" name="category">
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name" value="${book.name}">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label"> Price</label>
        <input type="number" class="form-control" name="price" id="price" value="${book.price}">
    </div>
    <div class="mb-3">
        <label for="stock" class="form-label">Stock</label>
        <input type="number" class="form-control" name="stock" id="stock" value="${book.stock}">
    </div>
    <div class="mb-3">
        <label for="totalPages" class="form-label">TotalPages</label>
        <input type="number" class="form-control" name="totalPages" id="totalPages" value="${book.totalPages}">
    </div>
    <div class="mb-3">
        <label for="yearCrated" class="form-label">yearCrated</label>
        <input type="number" class="form-control" name="yearCrated" id="yearCrated" value="${book.yearCrated}">
    </div>
    <div class="mb-3">
        <label for="author" class="form-label">TotalPages</label>
        <input type="text" class="form-control" name="author" id="author" value="${book.author}">
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <select class="form-control" name="status" id="status" value="${book.status}">
            <option value="true">Active</option>
            <option value="false">Inactive</option>
        </select>
    </div>
    <input type="submit" name="action" value="EDIT" class="btn btn-primary" onclick="return alert('da chinh sua thanh cong')"/>

</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
