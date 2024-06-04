<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        h1 {
            color: red;
        }

        a {
            color: #0066cc;
            text-decoration: none;
        }

        a:hover {
            color: #004d99;
        }
    </style>
</head>
<body>
<h2>Kết quả khai báo y tế</h2>
<h1>${message}</h1>
<a href="/declaration-view">Xem tờ khai</a>
</body>
</html>