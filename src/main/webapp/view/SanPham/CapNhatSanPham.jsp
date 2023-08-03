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
    <title>CapNhatSanPham</title>
</head>
<body>
<form action="/san-pham/cap-nhat-san-pham" method="post">
    id: <input type="text" name="id" value="${sp.id}"/><br>
    mã: <input type="text" name="ma" value="${sp.ma}"/><br>
    tên: <input type="text" name="ten" value="${sp.ten}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>

