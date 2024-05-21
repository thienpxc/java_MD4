<%--
  Created by IntelliJ IDEA.
  User: dokie
  Date: 5/21/2024
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="calculator" method="post">
    Operand 1: <input type="number" name="operand1"><br>
    Operator:
    <select name="operator">
        <option value="+">Cộng</option>
        <option value="-">Trừ</option>
        <option value="*">Nhân</option>
        <option value="/">Chia</option>
    </select>
    <br>
    Operand 2: <input type="number" name="operand2"><br>
    <input type="submit" value="Calculate">
</form>

</body>
</html>
