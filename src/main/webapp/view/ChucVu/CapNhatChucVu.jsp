<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/3/2023
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CapNhatChucVu</title>
</head>
<body>
<form action="/chuc-vu/cap-nhat-chuc-vu" method="post">
    id: <input type="text" name="id" value="${cv.id}"/><br>
    mã: <input type="text" name="ma" value="${cv.ma}"/><br>
    tên: <input type="text" name="ten" value="${cv.ten}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
