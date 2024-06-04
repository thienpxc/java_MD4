<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
      background-color: #f8f9fa;
    }

    form {
      width: 50%; /* Adjust this to change the form width */
      background-color: white;
      padding: 30px;
      box-shadow: 0px 0px 15px rgba(0,0,0,0.1);
      border-radius: 8px;
    }

    h2 {
      color: #333;
      margin-bottom: 20px;
      text-align: center;
    }

    .form-group {
      display: flex;
      flex-direction: row;
      align-items: center;
      margin-bottom: 15px;
    }

    .form-group label {
      width: 150px;
      margin-right: 10px;
      font-weight: bold;
      color: #555;
    }

    .form-group input {
      flex: 1;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 14px;
      color: #333;
    }

    .form-group input:focus {
      border-color: #80bdff;
      outline: none;
      box-shadow: 0 0 5px rgba(128,189,255,0.5);
    }

    .error {
      color: red;
      margin-top: 5px;
      margin-left: 160px; /* Adjust to align with input fields */
    }

    .radio-group {
      display: flex;
      align-items: center;
    }

    .radio-group label {
      margin-right: 10px;
      font-weight: normal;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
      transition: background-color 0.3s ease;
      margin-top: 20px;
    }

    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>

<form:form modelAttribute="declaration" method="post" action="/update-declaration">
  <h2>Cập nhật tờ khai y tế</h2>
  <div class="form-group">
    <form:label path="fullName">Họ tên:</form:label>
    <form:input path="fullName"/>
    <form:errors path="fullName" cssClass="error"/>
  </div>

  <div class="form-group">
    <form:label path="idNumber">CMND/Hộ chiếu:</form:label>
    <form:input path="idNumber"/>
    <form:errors path="idNumber" cssClass="error"/>
  </div>

  <div class="form-group">
    <form:label path="yearOfBirth">Năm sinh:</form:label>
    <form:input path="yearOfBirth"/>
    <form:errors path="yearOfBirth" cssClass="error"/>
  </div>

  <div class="form-group">
    <form:label path="gender">Giới tính:</form:label>
    <div class="radio-group">
      <form:radiobutton path="gender" value="Nam"/> Nam
      <form:radiobutton path="gender" value="Nữ"/> Nữ
    </div>
    <form:errors path="gender" cssClass="error"/>
  </div>

  <div class="form-group">
    <form:label path="address">Địa chỉ:</form:label>
    <form:input path="address"/>
    <form:errors path="address" cssClass="error"/>
  </div>

  <div class="form-group">
    <form:label path="district">Quận:</form:label>
    <form:input path="district"/>
    <form:errors path="district" cssClass="error"/>
  </div>

  <div class="form-group">
    <form:label path="ward">Phường:</form:label>
    <form:input path="ward"/>
    <form:errors path="ward" cssClass="error"/>
  </div>

  <div class="form-group">
    <form:label path="phone">Số điện thoại:</form:label>
    <form:input path="phone"/>
    <form:errors path="phone" cssClass="error"/>
  </div>

  <div class="form-group">
    <form:label path="email">Email:</form:label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
  </div>

  <button type="submit">Cập nhật tờ khai</button>
</form:form>
</body>
</html>
