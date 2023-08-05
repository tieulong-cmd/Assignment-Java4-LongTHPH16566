<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 8/3/2023
  Time: 4:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CapNhatCuaHang</title>
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

        .error-message {
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body>
<form action="/cua-hang/cap-nhat-cua-hang" method="post">
    id: <input type="text" name="id" value="${chu.id}"/><br>
    mã: <input type="text" name="ma" value="${chu.ma}"/><br>
    tên: <input type="text" name="ten" value="${chu.ten}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${chu.diaChi}"/><br>
    thành phố: <input type="text" name="thanhPho" value="${chu.thanhPho}"/><br>
    quốc gia: <input type="text" name="quocGia" value="${chu.quocGia}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
