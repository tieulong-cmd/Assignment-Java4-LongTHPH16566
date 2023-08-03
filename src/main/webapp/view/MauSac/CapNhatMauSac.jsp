<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/4/2023
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CapNhatMauSac</title>
</head>
<body>
<form action="/mau-sac/cap-nhat-mau-sac" method="post">
    id: <input type="text" name="id" value="${ms.id}"/><br>
    mã: <input type="text" name="ma" value="${ms.ma}"/><br>
    tên: <input type="text" name="ten" value="${ms.ten}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
