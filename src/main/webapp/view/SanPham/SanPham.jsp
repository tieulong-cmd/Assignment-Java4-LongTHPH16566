<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 8/3/2023
  Time: 4:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SanPham</title>
</head>
<body>
<form action="">
    id: <input type="text" name="id" value="${sp.id}"/><br>
    mã: <input type="text" name="ma" value="${sp.ma}"/><br>
    tên: <input type="text" name="ten" value="${sp.ten}"/><br>
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
    <c:forEach items="${sanPham}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>
                <button><a href="/san-pham/xoa-san-pham?DeleteId=${sp.id}">Delete</a></button>
                <button><a href="/san-pham/hien-thi-chi-tiet?DetailId=${sp.id}">Detail</a></button>
                <button><a href="/san-pham/hien-thi-cap-nhat?UpdateId=${sp.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

