<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ChiTietSP</title>
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
    id: <input type="text" name="id" value="${CTSPV.id}"/><br>
    Sản phẩm: <input type="text" name="idSP" value="${CTSPV.idSP}"/><br>
    Năm sản xuất: <input type="text" name="idNsx" value="${CTSPV.idNsx}"/><br>
    Màu sắc: <input type="text" name="idMauSac" value="${CTSPV.idMauSac}"/><br>
    Dòng sản phẩm: <input type="text" name="idDongSP" value="${CTSPV.idDongSP}"/><br>
    Năm bảo hành: <input type="number" name="namBH" value="${CTSPV.namBH}"/><br>
    Mô tả: <input type="text" name="moTa" value="${CTSPV.moTa}"/><br>
    Số lượng tồn: <input type="number" name="soLuongTon" value="${CTSPV.soLuongTon}"/><br>
    Giá nhập: <input type="number" name="giaNhap" value="${CTSPV.giaNhap}"/><br>
    Giá bán: <input type="number" name="giaBan" value="${CTSPV.giaBan}"/><br>
</form>
<button><a href="/chi-tiet-sp/hien-thi-them">Chuyển trang thêm</a></button>
<br>
<br>
<table>
    <tr>
        <th>ID</th>
        <th>Sản phẩm</th>
        <th>Nhà sản xuất</th>
        <th>Màu sắc</th>
        <th>Dòng sản phẩm</th>
        <th>Năm bảo hành</th>
        <th>Mô tả</th>
        <th>Số lượng tồn</th>
        <th>Giá nhập</th>
        <th>Giá bán</th>
        <th colspan="3">Action</th>
    </tr>
    <tbody>
    <c:forEach items="${chiTietSP}" var="chiTiet">
        <tr>
            <td>${chiTiet.id}</td>
            <td>${chiTiet.idSP}</td>
            <td>${chiTiet.idNsx}</td>
            <td>${chiTiet.idMauSac}</td>
            <td>${chiTiet.idDongSP}</td>
            <td>${chiTiet.namBH}</td>
            <td>${chiTiet.moTa}</td>
            <td>${chiTiet.soLuongTon}</td>
            <td>${chiTiet.giaNhap}</td>
            <td>${chiTiet.giaBan}</td>
            <td>
                <button><a href="/chi-tiet-sp/hien-thi-chi-tiet?DetailId=${chiTiet.id}">Detail</a></button>
                <button><a href="/chi-tiet-sp/hien-thi-cap-nhat?UpdateId=${chiTiet.id}">Edit</a></button>
                <button><a href="/chi-tiet-sp/xoa-chi-tiet-sp?DeleteId=${chiTiet.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
