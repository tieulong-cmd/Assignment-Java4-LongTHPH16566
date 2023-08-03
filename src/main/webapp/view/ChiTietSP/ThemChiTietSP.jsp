<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/4/2023
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Chi tiết Sản phẩm</title>
</head>
<body>
<form action="/them-chi-tiet-sp" method="post">
    Sản phẩm:
    <select name="idSP">
        <c:forEach items="${listSanPham}" var="sanPham">
            <option value="${sanPham.id}">${sanPham.ten}</option>
        </c:forEach>
    </select><br>
    Nhà sản xuất:
    <select name="idNsx">
        <c:forEach items="${listNSX}" var="nsx">
            <option value="${nsx.id}">${nsx.ten}</option>
        </c:forEach>
    </select><br>
    Màu sắc:
    <select name="idMauSac">
        <c:forEach items="${listMauSac}" var="mauSac">
            <option value="${mauSac.id}">${mauSac.ten}</option>
        </c:forEach>
    </select><br>
    Dòng sản phẩm:
    <select name="idDongSP">
        <c:forEach items="${listDongSP}" var="dongSP">
            <option value="${dongSP.id}">${dongSP.ten}</option>
        </c:forEach>
    </select><br>
    Năm bảo hành: <input type="text" name="namBH" /><br>
    Mô tả: <input type="text" name="moTa" /><br>
    Số lượng tồn: <input type="text" name="soLuongTon" /><br>
    Giá nhập: <input type="text" name="giaNhap" /><br>
    Giá bán: <input type="text" name="giaBan" /><br>
    <button type="submit">Add</button>
</form>
</body>
</html>
