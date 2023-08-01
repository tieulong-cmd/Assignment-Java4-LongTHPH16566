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
    <title>QuanLyKhachHang</title>
</head>
<body>
<form action="">

</form>
<form action="">
    id: <input type="text" name="id" value="${kh.id}"/>
    mã: <input type="text" name="ma" value="${kh.ma}"/>
    tên: <input type="text" name="ten" value="${kh.ten}"/>
    tên đệm: <input type="text" name="tenDem" value="${kh.tenDem}"/>
    họ: <input type="text" name="ho" value="${kh.ho}"/>
    ngày sinh: <input type="text" name="ngaySinh" value="${kh.ngaySinh}"/>
    sdt: <input type="text" name="sdt" value="${kh.sdt}"/>
    địa chỉ: <input type="text" name="diaChi" value="${kh.diaChi}"/>
    thành phố: <input type="text" name="thanhPho" value="${kh.thanhPho}"/>
    quốc gia: <input type="text" name="quocGia" value="${kh.quocGia}"/>
</form>
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
            <td>${kh.ma}</td>
            <td>${kh.id}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>
                <button><a href="/may-tinh/remove?DeleteMa=${kh.ma}">Delete</a></button>
                <button><a href="/may-tinh/detail?DetailMa=${kh.ma}">Detail</a></button>
                <button><a href="/may-tinh/view-update?UpdateMa=${kh.ma}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
