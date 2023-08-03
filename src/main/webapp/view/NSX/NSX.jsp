<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/4/2023
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>NhaSanXuat</title>
</head>
<body>
<form action="">
    id: <input type="text" name="id" value="${nsx.id}"/><br>
    mã: <input type="text" name="ma" value="${nsx.ma}"/><br>
    tên: <input type="text" name="ten" value="${nsx.ten}"/><br>
</form>
<table>
    <tr>
        <th>id</th>
        <th>mã</th>
        <th>tên</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${nhaSanXuat}" var="nsx">
        <tr>
            <td>${nsx.id}</td>
            <td>${nsx.ma}</td>
            <td>${nsx.ten}</td>
            <td>
                <button><a href="/nsx/xoa-nsx?DeleteId=${nsx.id}">Delete</a></button>
                <button><a href="/nsx/hien-thi-chi-tiet?DetailId=${nsx.id}">Detail</a></button>
                <button><a href="/nsx/hien-thi-cap-nhat?UpdateId=${nsx.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
