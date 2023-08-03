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
    <title>ThemCuaHang</title>
</head>
<body>
<form action="/cua-hang/them-cua-hang" method="post">
    mã: <input type="text" name="ma" /><br>
    tên: <input type="text" name="ten" /><br>
    địa chỉ: <input type="text" name="diaChi" /><br>
    thành phố: <input type="text" name="thanhPho" /><br>
    quốc gia: <input type="text" name="quocGia" /><br>
    <button type="submit">Add</button>
</form>
</body>
</html>

