<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/23/2024
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">product</a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="/Users">
                <input class="form-control me-2" type="search" value="${keyword}" placeholder="Search" name="keyword" aria-label="Search">
                <input class="btn btn-outline-success"  type="submit" name="action" value="SEARCH">
            </form>
        </div>
    </div>
</nav>
<h1>danh sach khach hang</h1>
<a href="/Users?action=ADD" class="btn btn-primary">ADD</a>
<a href="/Users?action=SORT" class="btn btn-primary">Sap xep</a>
<table class="table">
    <thead>
    <tr>

        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Phone</th>
        <th scope="col">Country</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>${user.phone}</td>
            <td>${user.country}</td>
            <td><a href="/Users?action=EDIT&id=${user.id}"  class="btn btn-warning">Edit</a></td>
            <td><a href="/Users?action=DELETE&id=${user.id}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoa ko')">Delete</a></td>
        </tr>
    </c:forEach>

<%--    <c:forEach items="${Search}" var="user" varStatus="loop">--%>
<%--        <tr>--%>
<%--            <th scope="row">${loop.count}</th>--%>
<%--            <td>${user.name}</td>--%>
<%--            <td>${user.email}</td>--%>
<%--            <td>${user.address}</td>--%>
<%--            <td>${user.phone}</td>--%>
<%--            <td>${user.country}</td>--%>
<%--            <td><a href="/Users?action=EDIT&id=${user.id}"  class="btn btn-warning">Edit</a></td>--%>
<%--            <td><a href="/Users?action=DELETE&id=${user.id}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoa ko')">Delete</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

    <c:forEach items="${Sort}" var="user" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>${user.phone}</td>
            <td>${user.country}</td>
            <td><a href="/Users?action=EDIT&id=${user.id}"  class="btn btn-warning">Edit</a></td>
            <td><a href="/Users?action=DELETE&id=${user.id}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoa ko')">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
