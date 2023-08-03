<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/4/2023
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CapNhatDongSP</title>
</head>
<body>
<form action="/dong-sp/cap-nhat-dong-sp" method="post">
    id: <input type="text" name="id" value="${dongSP.id}"/><br>
    mã: <input type="text" name="ma" value="${dongSP.ma}"/><br>
    tên: <input type="text" name="ten" value="${dongSP.ten}"/><br>
    <button type="submit">Update</button>
</form>
</body>
