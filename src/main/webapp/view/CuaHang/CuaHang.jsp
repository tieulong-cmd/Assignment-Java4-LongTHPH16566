<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 8/3/2023
  Time: 4:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CuaHang</title>
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
    id: <input type="text" name="id" value="${chv.id}"/><br>
    mã: <input type="text" name="ma" value="${chv.ma}"/><br>
    tên: <input type="text" name="ten" value="${chv.ten}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${chv.diaChi}"/><br>
    thành phố: <input type="text" name="thanhPho" value="${chv.thanhPho}"/><br>
    quốc gia: <input type="text" name="quocGia" value="${chv.quocGia}"/><br>
</form>
<button><a href="/cua-hang/hien-thi-them">chuyển trang add</a></button>
<br>
<br>
<table>
    <tr>
        <th>id</th>
        <th>mã</th>
        <th>tên</th>
        <th>địa chỉ</th>
        <th>thành phố</th>
        <th>quốc gia</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cuaHang}" var="ch">
        <tr>
            <td>${ch.id}</td>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td>
                <button><a href="/cua-hang/xoa-cua-hang?DeleteId=${ch.id}">Delete</a></button>
                <button><a href="/cua-hang/hien-thi-chi-tiet?DetailId=${ch.id}">Detail</a></button>
                <button><a href="/cua-hang/hien-thi-cap-nhat?UpdateId=${ch.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
