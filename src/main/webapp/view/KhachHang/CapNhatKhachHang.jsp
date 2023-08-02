<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 8/2/2023
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CapNhatKhachHang</title>
</head>
<body>
<form action="/khach-hang/cap-nhat-khach-hang" method="post">
    id: <input type="text" name="id" value="${khu.id}"/><br>
    mã: <input type="text" name="ma" value="${khu.ma}"/><br>
    tên: <input type="text" name="ten" value="${khu.ten}"/><br>
    tên đệm: <input type="text" name="tenDem" value="${khu.tenDem}"/><br>
    họ: <input type="text" name="ho" value="${khu.ho}"/><br>
    ngày sinh: <input type="text" name="ngaySinh" value="${khu.ngaySinh}"/><br>
    sdt: <input type="text" name="sdt" value="${khu.sdt}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${khu.diaChi}"/><br>
    thành phố: <input type="text" name="thanhPho" value="${khu.thanhPho}"/><br>
    quốc gia: <input type="text" name="quocGia" value="${khu.quocGia}"/><br>
    mật khẩu: <input type="text" name="matKhau" value="${khu.matKhau}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
