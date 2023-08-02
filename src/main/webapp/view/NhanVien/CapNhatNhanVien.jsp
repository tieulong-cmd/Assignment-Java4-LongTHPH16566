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
    <title>CapNhatNhanVien</title>
</head>
<body>
<form action="/nhan-vien/cap-nhat-nhan-vien" method="post">
    id: <input type="text" name="id" value="${nvu.id}"/><br>
    mã: <input type="text" name="ma" value="${nvu.ma}"/><br>
    tên: <input type="text" name="ten" value="${nvu.ten}"/><br>
    tên đệm: <input type="text" name="tenDem" value="${nvu.tenDem}"/><br>
    họ: <input type="text" name="ho" value="${nvu.ho}"/><br>
    ngày sinh: <input type="text" name="ngaySinh" value="${nvu.ngaySinh}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${nvu.diaChi}"/><br>
    sdt: <input type="text" name="sdt" value="${nvu.sdt}"/><br>
    mật khẩu: <input type="text" name="matKhau" value="${nvu.matKhau}"/><br>
    IdCH: <input type="text" name="IdCH" value="${nvu.cuaHang.id}"/><br>
    IdCV: <input type="text" name="IdCV" value="${nvu.chucVu.id}"/><br>
    IdGuiBC: <input type="text" name="IdGuiBC" value="${nvu.nhanVien.id}"/><br>
    trạng thái: <input type="text" name="trangThai" value="${nvu.trangThai}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
