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
    <title>KhachHang</title>
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
    id: <input type="text" name="id" value="${khv.id}"/><br>
    mã: <input type="text" name="ma" value="${khv.ma}"/><br>
    tên: <input type="text" name="ten" value="${khv.ten}"/><br>
    tên đệm: <input type="text" name="tenDem" value="${khv.tenDem}"/><br>
    họ: <input type="text" name="ho" value="${khv.ho}"/><br>
    ngày sinh: <input type="text" name="ngaySinh" value="${khv.ngaySinh}"/><br>
    sdt: <input type="text" name="sdt" value="${khv.sdt}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${khv.diaChi}"/><br>
    thành phố: <input type="text" name="thanhPho" value="${khv.thanhPho}"/><br>
    quốc gia: <input type="text" name="quocGia" value="${khv.quocGia}"/><br>
</form>
<button><a href="/khach-hang/hien-thi-them">chuyển trang add</a></button>
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
        <th>sdt</th>
        <th>địa chỉ</th>
        <th>thành phố</th>
        <th>quốc gia</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${khachHang}" var="kh">
        <tr>
            <td>${kh.id}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>
                <button><a href="/khach-hang/xoa-khach-hang?DeleteId=${kh.id}">Delete</a></button>
                <button><a href="/khach-hang/hien-thi-chi-tiet?DetailId=${kh.id}">Detail</a></button>
                <button><a href="/khach-hang/hien-thi-cap-nhat?UpdateId=${kh.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
