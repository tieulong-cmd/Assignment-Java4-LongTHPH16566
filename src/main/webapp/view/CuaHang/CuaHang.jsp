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
</head>
<body>
<form action="">
    id: <input type="text" name="id" value="${ch.id}"/><br>
    mã: <input type="text" name="ma" value="${ch.ma}"/><br>
    tên: <input type="text" name="ten" value="${ch.ten}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${ch.diaChi}"/><br>
    thành phố: <input type="text" name="thanhPho" value="${ch.thanhPho}"/><br>
    quốc gia: <input type="text" name="quocGia" value="${ch.quocGia}"/><br>
</form>
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
