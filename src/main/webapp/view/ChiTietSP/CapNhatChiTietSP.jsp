<%--
  Created by IntelliJ IDEA.
  User: tieul
  Date: 8/4/2023
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật Chi tiết Sản phẩm</title>
</head>
<body>
<form action="/cap-nhat-chi-tiet-sp" method="post">
    id: <input type="text" name="id" value="${chiTietSP.id}" readonly/><br>
    Sản phẩm:
    <select name="idSP">
        <c:forEach items="${listSanPham}" var="sanPham">
            <option value="${sanPham.id}" ${chiTietSP.sanPham.id == sanPham.id ? 'selected' : ''}>${sanPham.ten}</option>
        </c:forEach>
    </select><br>
    Nhà sản xuất:
    <select name="idNsx">
        <c:forEach items="${listNSX}" var="nsx">
            <option value="${nsx.id}" ${chiTietSP.nsx.id == nsx.id ? 'selected' : ''}>${nsx.ten}</option>
        </c:forEach>
    </select><br>
    Màu sắc:
    <select name="idMauSac">
        <c:forEach items="${listMauSac}" var="mauSac">
            <option value="${mauSac.id}" ${chiTietSP.mauSac.id == mauSac.id ? 'selected' : ''}>${mauSac.ten}</option>
        </c:forEach>
    </select><br>
    Dòng sản phẩm:
    <select name="idDongSP">
        <c:forEach items="${listDongSP}" var="dongSP">
            <option value="${dongSP.id}" ${chiTietSP.dongSP.id == dongSP.id ? 'selected' : ''}>${dongSP.ten}</option>
        </c:forEach>
    </select><br>
    Năm bảo hành: <input type="text" name="namBH" value="${chiTietSP.namBH}" /><br>
    Mô tả: <input type="text" name="moTa" value="${chiTietSP.moTa}" /><br>
    Số lượng tồn: <input type="text" name="soLuongTon" value="${chiTietSP.soLuongTon}" /><br>
    Giá nhập: <input type="text" name="giaNhap" value="${chiTietSP.giaNhap}" /><br>
    Giá bán: <input type="text" name="giaBan" value="${chiTietSP.giaBan}" /><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
