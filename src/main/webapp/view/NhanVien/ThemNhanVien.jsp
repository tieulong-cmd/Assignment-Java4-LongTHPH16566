<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 8/2/2023
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ThemNhanVien</title>
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
<form action="/nhan-vien/them-nhan-vien" method="post">
    mã: <input type="text" name="ma" value="${nva.ma}"/><br>
    tên: <input type="text" name="ten" value="${nva.ten}"/><br>
    tên đệm: <input type="text" name="tenDem" value="${nva.tenDem}"/><br>
    họ: <input type="text" name="ho" value="${nva.ho}"/><br>
    ngày sinh: <input type="date" name="ngaySinh" value="${nva.ngaySinh}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${nva.diaChi}"/><br>
    sdt: <input type="text" name="sdt" value="${nva.sdt}"/><br>
    mật khẩu: <input type="text" name="matKhau" value="${nva.matKhau}"/><br>
    IdCH: <input type="text" name="IdCH" value="${nva.idCH}"/><br>
    IdCV: <input type="text" name="IdCV" value="${nva.idCv}"/><br>
    IdGuiBC: <input type="text" name="IdGuiBC" value="${nva.idGUIBC}"/><br>
    trạng thái: <input type="text" name="trangThai" value="${nva.trangThai}"/><br>
    <button type="submit">Add</button>
</form>
</body>
</html>
