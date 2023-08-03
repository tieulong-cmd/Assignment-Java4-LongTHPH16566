<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ChiTietSP</title>
</head>
<body>
<form action="">
    <input type="hidden" name="id" value="${CTSPV.id}"/>
    Sản phẩm:
    <select name="sanPham.id">
        <c:forEach items="${sanPhamList}" var="sanPham">
            <option value="${sanPham.id}" ${CTSPV.sanPham.id eq sanPham.id ? 'selected' : ''}>${sanPham.tenSanPham}</option>
        </c:forEach>
    </select><br>
    Nhà sản xuất:
    <select name="nsx.id">
        <c:forEach items="${nsxList}" var="nsx">
            <option value="${nsx.id}" ${CTSPV.nsx.id eq nsx.id ? 'selected' : ''}>${nsx.ten}</option>
        </c:forEach>
    </select><br>
    Màu sắc:
    <select name="mauSac.id">
        <c:forEach items="${mauSacList}" var="mauSac">
            <option value="${mauSac.id}" ${CTSPV.mauSac.id eq mauSac.id ? 'selected' : ''}>${mauSac.tenMau}</option>
        </c:forEach>
    </select><br>
    Dòng sản phẩm:
    <select name="dongSP.id">
        <c:forEach items="${dongSPList}" var="dongSP">
            <option value="${dongSP.id}" ${CTSPV.dongSP.id eq dongSP.id ? 'selected' : ''}>${dongSP.tenDongSP}</option>
        </c:forEach>
    </select><br>
    Năm bảo hành: <input type="number" name="namBH" value="${CTSPV.namBH}"/><br>
    Mô tả: <input type="text" name="moTa" value="${CTSPV.moTa}"/><br>
    Số lượng tồn: <input type="number" name="soLuongTon" value="${CTSPV.soLuongTon}"/><br>
    Giá nhập: <input type="number" name="giaNhap" value="${CTSPV.giaNhap}"/><br>
    Giá bán: <input type="number" name="giaBan" value="${CTSPV.giaBan}"/><br>
    <button type="submit" formaction="/chi-tiet-sp/cap-nhat-chi-tiet-sp">Cập nhật</button>
    <button type="submit" formaction="/chi-tiet-sp/xoa-chi-tiet-sp">Xóa</button>
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Sản phẩm</th>
        <th>Nhà sản xuất</th>
        <th>Màu sắc</th>
        <th>Dòng sản phẩm</th>
        <th>Năm bảo hành</th>
        <th>Mô tả</th>
        <th>Số lượng tồn</th>
        <th>Giá nhập</th>
        <th>Giá bán</th>
        <th colspan="3">Action</th>
    </tr>
    <tbody>
    <c:forEach items="${chiTietSP}" var="chiTiet">
        <tr>
            <td>${chiTiet.id}</td>
            <td>${chiTiet.sanPham.tenSanPham}</td>
            <td>${chiTiet.nsx.ten}</td>
            <td>${chiTiet.mauSac.tenMau}</td>
            <td>${chiTiet.dongSP.tenDongSP}</td>
            <td>${chiTiet.namBH}</td>
            <td>${chiTiet.moTa}</td>
            <td>${chiTiet.soLuongTon}</td>
            <td>${chiTiet.giaNhap}</td>
            <td>${chiTiet.giaBan}</td>
            <td>
                <button><a href="/chi-tiet-sp/hien-thi-chi-tiet?DetailId=${chiTiet.id}">Detail</a></button>
            </td>
            <td>
                <button><a href="/chi-tiet-sp/hien-thi-cap-nhat?UpdateId=${chiTiet.id}">Edit</a></button>
            </td>
            <td>
                <form action="/chi-tiet-sp/xoa-chi-tiet-sp" method="post">
                    <input type="hidden" name="DeleteId" value="${chiTiet.id}"/>
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
