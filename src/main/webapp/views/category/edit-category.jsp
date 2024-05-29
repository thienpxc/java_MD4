<%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/28/2024
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Muc</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<h1>Chinh sua danh muc</h1>
<a href="/category?action=LIST">Quay lại</a>
<form action="/category?action=EDIT" method="post" >
    <input type="hidden" name="id" value="${category.id}"/>
    <div class="mb-3">
        <label for="name" class="form-label"> Name</label>
        <input type="text" class="form-control" id="name" name="name" value="${category.name}">
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <select class="form-control" name="status" id="status">
            <option value="${category.status}">${category.status ? 'Active' : 'Inactive'}</option>
            <option value="true">Active</option>
            <option value="false">Inactive</option>
        </select>
    </div>
    <input type="submit" name="action" value="EDIT" class="btn btn-primary"/>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
