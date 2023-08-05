<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/3/2023
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ThemChucVu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="text"],
        input[type="number"] {
            padding: 5px;
            width: 200px;
            margin-bottom: 10px;
        }

        button {
            background-color: #007bff;
            padding: 5px 10px;
            border: none;
            color: white;
            cursor: pointer;
            margin-right: 10px;
            border-radius: 3px;
        }

    </style>
</head>
<body>
<form action="/chuc-vu/them-chuc-vu" method="post">
    mã: <input type="text" name="ma" /><br>
    tên: <input type="text" name="ten" /><br>
    <button type="submit">Add</button>
</form>
</body>
</html>
