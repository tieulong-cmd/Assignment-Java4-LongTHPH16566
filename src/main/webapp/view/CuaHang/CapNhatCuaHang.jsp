<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 8/3/2023
  Time: 4:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CapNhatCuaHang</title>
</head>
<body>
<form action="/cua-hang/cap-nhat-cua-hang" method="post">
    id: <input type="text" name="id" value="${ch.id}"/><br>
    mã: <input type="text" name="ma" value="${ch.ma}"/><br>
    tên: <input type="text" name="ten" value="${ch.ten}"/><br>
    địa chỉ: <input type="text" name="diaChi" value="${ch.diaChi}"/><br>
    thành phố: <input type="text" name="thanhPho" value="${ch.thanhPho}"/><br>
    quốc gia: <input type="text" name="quocGia" value="${ch.quocGia}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
