<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 8/3/2023
  Time: 4:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SanPham</title>
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
    id: <input type="text" name="id" value="${sp.id}"/><br>
    mã: <input type="text" name="ma" value="${sp.ma}"/><br>
    tên: <input type="text" name="ten" value="${sp.ten}"/><br>
</form>
<button><a href="/san-pham/hien-thi-them">chuyển trang add</a></button>
<br>
<br>
<table>
    <tr>
        <th>id</th>
        <th>mã</th>
        <th>tên</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sanPham}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>
                <button><a href="/san-pham/xoa-san-pham?DeleteId=${sp.id}">Delete</a></button>
                <button><a href="/san-pham/hien-thi-chi-tiet?DetailId=${sp.id}">Detail</a></button>
                <button><a href="/san-pham/hien-thi-cap-nhat?UpdateId=${sp.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

