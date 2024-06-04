<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
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
            padding: 20px;
        }

        .container {
            width: 60%;
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

        p {
            color: #666;
            margin-bottom: 10px;
            line-height: 1.6;
        }

        a {
            color: #0066cc;
            text-decoration: none;
        }

        a:hover {
            color: #004d99;
        }

        h3 {
            margin-top: 20px;
            color: #333;
        }

        .info-group {
            margin-bottom: 10px;
        }

        .info-group span {
            font-weight: bold;
            color: #333;
        }

        .update-link {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .update-link a {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border-radius: 4px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .update-link a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Thông Tin Tờ Khai Y Tế</h2>
    <div class="info-group">
        <span>Họ tên:</span> ${declaration.fullName}
    </div>
    <div class="info-group">
        <span>CMND/Hộ chiếu:</span> ${declaration.idNumber}
    </div>
    <div class="info-group">
        <span>Năm sinh:</span> ${declaration.yearOfBirth}
    </div>
    <div class="info-group">
        <span>Giới tính:</span> ${declaration.gender}
    </div>
    <div class="info-group">
        <span>Địa chỉ:</span> ${declaration.address}
    </div>
    <div class="info-group">
        <span>Quận:</span> ${declaration.district}
    </div>
    <div class="info-group">
        <span>Phường:</span> ${declaration.ward}
    </div>
    <div class="info-group">
        <span>Số điện thoại:</span> ${declaration.phone}
    </div>
    <div class="info-group">
        <span>Email:</span> ${declaration.email}
    </div>
    <div class="info-group">
       <span>Phương tiện đi lại: </span> ${declaration.transportations}
    </div>
    <div class="info-group">
        <span>Triệu chứng:</span> ${declaration.symptoms}
    </div>

    <div class="update-link">
        <a href="/update-declaration">Cập nhật thông tin</a>
    </div>
</div>
</body>
</html>
