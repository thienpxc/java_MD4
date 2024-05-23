<%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/23/2024
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<h1>Chinh sua User</h1>

<a href="/Users?action=LIST">Quay lại</a>
<form action="/Users" method="post">
    <div class="mb-3">
        <label for="name" class="form-label"> Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="User name...">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="text" class="form-control" name="email" id="email" placeholder="User Email...">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">password</label>
        <input type="text" class="form-control" name="password" id="password" placeholder="password...">
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">address</label>
        <input type="text" class="form-control" name="address" id="address" placeholder="address">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">phone</label>
        <input type="number" class="form-control" name="phone" id="phone" placeholder="phone">
    </div>
    <div class="mb-3">
        <label for="country" class="form-label">country</label>
        <input type="text" class="form-control" name="country" id="country" placeholder="country">
    </div>
    <input type="hidden" name="id" value="${user.id}" />
    <input type="submit" name="action" value="UPDATE" class="btn btn-primary"onclick="return alert('da chinh sua thanh cong')"/>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
