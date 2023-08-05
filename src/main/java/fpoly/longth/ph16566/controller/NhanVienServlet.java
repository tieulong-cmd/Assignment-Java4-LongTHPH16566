package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.ChucVu;
import fpoly.longth.ph16566.entity.CuaHang;
import fpoly.longth.ph16566.entity.NhanVien;
import fpoly.longth.ph16566.service.ChucVuService;
import fpoly.longth.ph16566.service.CuaHangService;
import fpoly.longth.ph16566.service.NhanVienService;
import fpoly.longth.ph16566.service.impl.ChucVuServiceImpl;
import fpoly.longth.ph16566.service.impl.CuaHangServiceImpl;
import fpoly.longth.ph16566.service.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/nhan-vien/*")
public class NhanVienServlet extends HttpServlet {
    private NhanVienService nhanVienService = new NhanVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/hien-thi-danh-sach":
                hienThiDanhSach(req, resp);
                break;
            case "/hien-thi-chi-tiet":
                hienThiChiTiet(req, resp);
                break;
            case "/tim-kiem":
                timKiemNhanVien(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
                case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-nhan-vien":
                xoaNhanVien(req, resp);
                break;
            default:
                resp.sendRedirect("/nhan-vien/hien-thi-danh-sach");
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhanVien> nhanVienList = nhanVienService.getAll();
        req.setAttribute("nhanVien", nhanVienList);
        req.getRequestDispatcher("/view/NhanVien/NhanVien.jsp").forward(req, resp);
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        NhanVien nhanVien = nhanVienService.getOne(idParam);
        req.setAttribute("nvv", nhanVien);

        hienThiDanhSach(req, resp);
    }

    private void timKiemNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String tenParam = req.getParameter("ten");
        List<NhanVien> nhanVienList = nhanVienService.searchName(tenParam);
        req.setAttribute("nhanVien", nhanVienList);
        req.getRequestDispatcher("/view/NhanVien/NhanVien.jsp").forward(req, resp);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        NhanVien nhanVien = nhanVienService.getOne(idParam);
        req.setAttribute("nvu", nhanVien);
        req.getRequestDispatcher("/view/NhanVien/CapNhatNhanVien.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/NhanVien/ThemNhanVien.jsp").forward(req, resp);
    }

    private void xoaNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("DeleteId");
        NhanVien nhanVien = nhanVienService.getOne(maParam);
        if (nhanVien != null) {
            nhanVienService.remove(nhanVien);
        }
        resp.sendRedirect("/nhan-vien/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-nhan-vien":
                themNhanVien(req, resp);
                break;
            case "/cap-nhat-nhan-vien":
                capNhatNhanVien(req, resp);
                break;
            default:
                resp.sendRedirect("/nhan-vien/hien-thi-danh-sach");
        }
    }

    private void themNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String tenDemParam = req.getParameter("tenDem");
        String hoParam = req.getParameter("ho");
        String ngaySinhParam = req.getParameter("ngaySinh");
        String diaChiParam = req.getParameter("diaChi");
        String sdtParam = req.getParameter("sdt");
        String matKhauParam = req.getParameter("matKhau");
        String idCHParam = req.getParameter("cuaHang.id"); // Đổi thành "IdCH" thay vì "idCH"
        String idCVParam = req.getParameter("chucVu.id"); // Đổi thành "IdCV" thay vì "idCV"
        String idGuiBCParam = req.getParameter("nhanVien.id"); // Đổi thành "IdGuiBC" thay vì "idGuiBC"
        String trangThaiParam = req.getParameter("trangThai");

        NhanVien nhanVien = NhanVien.builder()
                .ma(maParam)
                .ten(tenParam)
                .tenDem(tenDemParam)
                .ho(hoParam)
                .ngaySinh(ngaySinhParam)
                .diaChi(diaChiParam)
                .sdt(sdtParam)
                .matKhau(matKhauParam)
                .idCH(idCHParam)
                .idCV(idCVParam)
                .idGUIBC(idGuiBCParam)
                .trangThai(trangThaiParam)
                .build();
        nhanVienService.add(nhanVien);
        resp.sendRedirect("/nhan-vien/hien-thi-danh-sach");

    }

    private void capNhatNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String tenDemParam = req.getParameter("tenDem");
        String hoParam = req.getParameter("ho");
        String ngaySinhParam = req.getParameter("ngaySinh");
        String diaChiParam = req.getParameter("diaChi");
        String sdtParam = req.getParameter("sdt");
        String matKhauParam = req.getParameter("matKhau");
        String idCHParam = req.getParameter("cuaHang.id");
        String idCVParam = req.getParameter("chucVu.id");
        String idGuiBCParam = req.getParameter("nhanVien.id");
        String trangThaiParam = req.getParameter("trangThai");

        NhanVien nhanVien = NhanVien.builder()
                .id(idParam)
                .ma(maParam)
                .ten(tenParam)
                .tenDem(tenDemParam)
                .ho(hoParam)
                .ngaySinh(ngaySinhParam)
                .diaChi(diaChiParam)
                .sdt(sdtParam)
                .matKhau(matKhauParam)
                .idCH(idCHParam)
                .idCV(idCVParam)
                .idGUIBC(idGuiBCParam)
                .trangThai(trangThaiParam)
                .build();

        nhanVienService.update(nhanVien);

        resp.sendRedirect("/nhan-vien/hien-thi-danh-sach");
    }
}
