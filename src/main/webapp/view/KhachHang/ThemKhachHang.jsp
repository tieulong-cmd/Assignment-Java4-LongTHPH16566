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
    <title>ThemKhachHang</title>
</head>
<body>
<form action="/khach-hang/them-khach-hang" method="post">
    mã: <input type="text" name="ma" value="${kha.ma}"/><br>
    tên: <input type="text" name="ten" value="${kha.ten}"/><br>
    tên đệm: <input type="text" name="tenDem" value="${kha.tenDem}"/><br>
    họ: <input type="text" name="ho" value="${kha.ho}"/><br>
    ngày sinh: <input type="text" name="ngaySinh" value="${kha.ngaySinh}"/><br>
    sdt: <input type="text" name="sdt" value="${kha.sdt}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${kha.diaChi}"/><br>
    thành phố: <input type="text" name="thanhPho" value="${kha.thanhPho}"/><br>
    quốc gia: <input type="text" name="quocGia" value="${kha.quocGia}"/><br>
    <button type="submit">Add</button>
</form>
</body>
</html>
