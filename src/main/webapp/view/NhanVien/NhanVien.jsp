<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 7/31/2023
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>NhanVien</title>
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

        button a {
            text-decoration: none;
            color: #fff;
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

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<form action="">
    id: <input type="text" name="id" value="${nvv.id}"/><br>
    mã: <input type="text" name="ma" value="${nvv.ma}"/><br>
    tên: <input type="text" name="ten" value="${nvv.ten}"/><br>
    tên đệm: <input type="text" name="tenDem" value="${nvv.tenDem}"/><br>
    họ: <input type="text" name="ho" value="${nvv.ho}"/><br>
    ngày sinh: <input type="date" name="ngaySinh" value="${nvv.ngaySinh}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${nvv.diaChi}"/><br>
    sdt: <input type="text" name="sdt" value="${nvv.sdt}"/><br>
    mật khẩu: <input type="text" name="matKhau" value="${nvv.matKhau}"/><br>
    IdCH: <input type="text" name="IdCH" value="${nvv.idCH}"/><br>
    IdCV: <input type="text" name="IdCV" value="${nvv.idCV}"/><br>
    IdGuiBC: <input type="text" name="IdGuiBC" value="${nvv.idGUIBC}"/><br>
    trạng thái: <input type="text" name="trangThai" value="${nvv.trangThai}"/><br>
</form>
<button><a href="/nhan-vien/hien-thi-them">chuyển trang add</a></button>
<br>
<br>
<table>
    <tr>
        <th>id</th>
        <th>mã</th>
        <th>tên</th>
        <th>tên đệm</th>
        <th>họ</th>
        <th>ngày sinh</th>
        <th>địa chỉ</th>
        <th>sdt</th>
        <th>mật khẩu</th>
        <th>IdCH</th>
        <th>IdCV</th>
        <th>IdGuiBC</th>
        <th>trạng thái</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${nhanVien}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.idCH}</td>
            <td>${nv.idCV}</td>
            <td>${nv.idGUIBC}</td>
            <td>${nv.trangThai}</td>
            <td>
                <button><a href="/nhan-vien/xoa-nhan-vien?DeleteId=${nv.id}">Delete</a></button>
                <button><a href="/nhan-vien/hien-thi-chi-tiet?DetailId=${nv.id}">Detail</a></button>
                <button><a href="/nhan-vien/hien-thi-cap-nhat?UpdateId=${nv.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
