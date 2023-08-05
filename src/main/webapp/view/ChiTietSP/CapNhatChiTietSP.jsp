<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật Chi tiết Sản phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="text"],
        input[type="number"] {
            padding: 5px;
            width: 200px;
            margin-bottom: 10px;
        }

        button {
            background-color: #007bff;
            padding: 5px 10px;
            border: none;
            color: white;
            cursor: pointer;
            margin-right: 10px;
            border-radius: 3px;
        }

    </style>
</head>
<body>
<form action="/chi-tiet-sp/cap-nhat-chi-tiet-sp" method="post">
    <input type="hidden" name="id" value="${CTSPU.id}"/>
    Sản phẩm: <input type="text" name="idSP" value="${CTSPU.idSP}"/><br>
    Năm sản xuất: <input type="text" name="idNsx" value="${CTSPU.idNsx}"/><br>
    Màu sắc: <input type="text" name="idMauSac" value="${CTSPU.idMauSac}"/><br>
    Dòng sản phẩm: <input type="text" name="idDongSP" value="${CTSPU.idDongSP}"/><br>
    Năm bảo hành: <input type="number" name="namBH" value="${CTSPU.namBH}"/><br>
    Mô tả: <input type="text" name="moTa" value="${CTSPU.moTa}"/><br>
    Số lượng tồn: <input type="number" name="soLuongTon" value="${CTSPU.soLuongTon}"/><br>
    Giá nhập: <input type="number" name="giaNhap" value="${CTSPU.giaNhap}"/><br>
    Giá bán: <input type="number" name="giaBan" value="${CTSPU.giaBan}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
