<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Chi tiết Sản phẩm</title>
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

        .error-message {
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body>
<form action="/chi-tiet-sp/them-chi-tiet-sp" method="post">
    Sản phẩm: <input type="text" name="idSP"/><br>
    Năm sản xuất: <input type="text" name="idNsx"/><br>
    Màu sắc: <input type="text" name="idMauSac"/><br>
    Dòng sản phẩm: <input type="text" name="idDongSP"/><br>
    Năm bảo hành: <input type="number" name="namBH"/><br>
    Mô tả: <input type="text" name="moTa"/><br>
    Số lượng tồn: <input type="number" name="soLuongTon"/><br>
    Giá nhập: <input type="number" name="giaNhap"/><br>
    Giá bán: <input type="number" name="giaBan"/><br>
    <button type="submit">Add</button>
</form>
<script>
    function validateForm() {
        var idSP = document.forms["addForm"]["idSP"].value;
        var idNsx = document.forms["addForm"]["idNsx"].value;
        var idMauSac = document.forms["addForm"]["idMauSac"].value;
        var idDongSP = document.forms["addForm"]["idDongSP"].value;
        var namBH = document.forms["addForm"]["namBH"].value;
        var moTa = document.forms["addForm"]["moTa"].value;
        var soLuongTon = document.forms["addForm"]["soLuongTon"].value;
        var giaNhap = document.forms["addForm"]["giaNhap"].value;
        var giaBan = document.forms["addForm"]["giaBan"].value;

        if (
            idSP === "" || idNsx === "" || idMauSac === "" || idDongSP === ""
            || namBH === "" || moTa === "" || soLuongTon === "" || giaNhap === ""
            || giaBan === ""
        ) {
            alert("Please fill in all fields.");
            return false;
        }
    }
</script>
</body>
</html>
