<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/3/2023
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ChucVu</title>
</head>
<body>
<form action="">
    id: <input type="text" name="id" value="${cv.id}"/><br>
    mã: <input type="text" name="ma" value="${cv.ma}"/><br>
    tên: <input type="text" name="ten" value="${cv.ten}"/><br>
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
    <c:forEach items="${chucVu}" var="cv">
        <tr>
            <td>${cv.id}</td>
            <td>${cv.ma}</td>
            <td>${cv.ten}</td>
            <td>
                <button><a href="/chuc-vu/xoa-chuc-vu?DeleteId=${cv.id}">Delete</a></button>
                <button><a href="/chuc-vu/hien-thi-chi-tiet?DetailId=${cv.id}">Detail</a></button>
                <button><a href="/chuc-vu/hien-thi-cap-nhat?UpdateId=${cv.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
