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


@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi-danh-sach",
        "/khach-hang/tim-kiem",
        "/khach-hang/hien-thi-cap-nhat",
        "/khach-hang/cap-nhat-khach-hang",
        "/khach-hang/hien-thi-them",
        "/khach-hang/them-khach-hang",
        "/khach-hang/xoa-khach-hang"})
public class KhachHangServlet extends HttpServlet {
    List<KhachHang> khachHangList = new ArrayList<>();
    KhachHangService khachHangService = new KhachHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("danh-sach")) {
            this.hienThiDanhSach(req, resp);
        } else if (uri.contains("tim-kiem")) {
            this.timKiemKhachHang(req, resp);
        } else if (uri.contains("hien-thi-cap-nhat")) {
            this.hienThiCapNhat(req, resp);
        } else if (uri.contains("hien-thi-them")) {
            this.hienThiThem(req, resp);
        } else if (uri.contains("xoa-khach-hang")) {
            this.xoaKhachHang(req, resp);
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) {
        khachHangService.getAll();
    }

    private void timKiemKhachHang(HttpServletRequest req, HttpServletResponse resp) {
        String tenParam = req.getParameter("ten");
        khachHangService.searchName(tenParam);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void xoaKhachHang(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("them-khach-hang")) {
            this.themKhachHang(req, resp);
        } else if (uri.contains("cap-nhat-khach-hang")) {
            this.capNhatKhachHang(req, resp);
        }
    }

    private void themKhachHang(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void capNhatKhachHang(HttpServletRequest req, HttpServletResponse resp) {
    }
}
