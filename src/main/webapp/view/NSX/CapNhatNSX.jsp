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
    <title>CapNhatNSX</title>
</head>
<body>
<form action="/nsx/cap-nhat-nsx" method="post">
    id: <input type="text" name="id" value="${nsx.id}"/><br>
    mã: <input type="text" name="ma" value="${nsx.ma}"/><br>
    tên: <input type="text" name="ten" value="${nsx.ten}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
