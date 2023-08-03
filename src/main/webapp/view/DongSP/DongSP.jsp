<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/4/2023
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DongSanPham</title>
</head>
<body>
<form action="">
    id: <input type="text" name="id" value="${dsp.id}"/><br>
    mã: <input type="text" name="ma" value="${dsp.ma}"/><br>
    tên: <input type="text" name="ten" value="${dsp.ten}"/><br>
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
    <c:forEach items="${dongSanPham}" var="dongSP">
        <tr>
            <td>${dongSP.id}</td>
            <td>${dongSP.ma}</td>
            <td>${dongSP.ten}</td>
            <td>
                <button><a href="/dong-sp/xoa-dong-sp?DeleteId=${dongSP.id}">Delete</a></button>
                <button><a href="/dong-sp/hien-thi-chi-tiet?DetailId=${dongSP.id}">Detail</a></button>
                <button><a href="/dong-sp/hien-thi-cap-nhat?UpdateId=${dongSP.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
