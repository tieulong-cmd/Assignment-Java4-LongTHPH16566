package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.KhachHang;
import fpoly.longth.ph16566.service.KhachHangService;
import fpoly.longth.ph16566.service.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/khach-hang/*")
public class KhachHangServlet extends HttpServlet {
    List<KhachHang> khachHangList = new ArrayList<>();
    KhachHangService khachHangService = new KhachHangServiceImpl();

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
                timKiemKhachHang(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
            case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-khach-hang":
                xoaKhachHang(req, resp);
                break;
            default:
                resp.sendRedirect("/khach-hang/hien-thi-danh-sach");
        }
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        KhachHang khachHang = khachHangService.getOne(idParam);
        req.setAttribute("khv", khachHang);

        hienThiDanhSach(req, resp);
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhachHang> khachHangList = khachHangService.getAll();
        req.setAttribute("khachHang", khachHangList);
        req.getRequestDispatcher("/view/KhachHang/KhachHang.jsp").forward(req, resp);
    }

    private void timKiemKhachHang(HttpServletRequest req, HttpServletResponse resp) {
        String tenParam = req.getParameter("ten");
        khachHangService.searchName(tenParam);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        KhachHang khachHang = khachHangService.getOne(idParam);
        req.setAttribute("khu", khachHang);
        req.getRequestDispatcher("/view/KhachHang/CapNhatKhachHang.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/KhachHang/ThemKhachHang.jsp").forward(req, resp);
    }

    private void xoaKhachHang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("DeleteId");
        KhachHang khachHang = khachHangService.getOne(maParam);
        khachHangService.remove(khachHang);
        resp.sendRedirect("/khach-hang/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-khach-hang":
                themKhachHang(req, resp);
                break;
            case "/cap-nhat-khach-hang":
                capNhatKhachHang(req, resp);
                break;
            default:
                resp.sendRedirect("/khach-hang/hien-thi-danh-sach");
        }
    }

    private void themKhachHang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String tenDemParam = req.getParameter("tenDem");
        String hoParam = req.getParameter("ho");
        String ngaySinhParam = req.getParameter("ngaySinh");
        String sdtParam = req.getParameter("sdt");
        String diaChiParam = req.getParameter("diaChi");
        String thanhPhoParam = req.getParameter("thanhPho");
        String quocGiaParam = req.getParameter("quocGia");
        String matKhauParam = req.getParameter("matKhau");

        KhachHang khachHang = KhachHang.builder()
                .ma(maParam)
                .ten(tenParam)
                .tenDem(tenDemParam)
                .ho(hoParam)
                .ngaySinh(ngaySinhParam)
                .sdt(sdtParam)
                .diaChi(diaChiParam)
                .thanhPho(thanhPhoParam)
                .quocGia(quocGiaParam)
                .matKhau(matKhauParam)
                .build();
        khachHangService.add(khachHang);
        resp.sendRedirect("/khach-hang/hien-thi-danh-sach");
    }

    private void capNhatKhachHang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String tenDemParam = req.getParameter("tenDem");
        String hoParam = req.getParameter("ho");
        String ngaySinhParam = req.getParameter("ngaySinh");
        String sdtParam = req.getParameter("sdt");
        String diaChiParam = req.getParameter("diaChi");
        String thanhPhoParam = req.getParameter("thanhPho");
        String quocGiaParam = req.getParameter("quocGia");
        String matKhauParam = req.getParameter("matKhau");

        KhachHang khachHang = KhachHang.builder()
                .id(idParam)
                .ma(maParam)
                .ten(tenParam)
                .tenDem(tenDemParam)
                .ho(hoParam)
                .ngaySinh(ngaySinhParam)
                .sdt(sdtParam)
                .diaChi(diaChiParam)
                .thanhPho(thanhPhoParam)
                .quocGia(quocGiaParam)
                .matKhau(matKhauParam)
                .build();
        khachHangService.update(khachHang);
        resp.sendRedirect("/khach-hang/hien-thi-danh-sach");
    }
}
