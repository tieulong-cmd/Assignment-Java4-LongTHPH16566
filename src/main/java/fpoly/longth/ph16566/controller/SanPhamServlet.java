package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.*;
import fpoly.longth.ph16566.service.*;
import fpoly.longth.ph16566.service.impl.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/san-pham/*")
public class SanPhamServlet extends HttpServlet {
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

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
//                timKiemSanPham(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
            case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-san-pham":
                xoaSanPham(req, resp);
                break;
            default:
                resp.sendRedirect("/san-pham/hien-thi-danh-sach");
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SanPham> sanPhamList = sanPhamService.getAll();
        req.setAttribute("sanPham", sanPhamList);
        req.getRequestDispatcher("/view/SanPham/SanPham.jsp").forward(req, resp);
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        SanPham sanPham = sanPhamService.getOne(idParam);
        req.setAttribute("sp", sanPham);

        hienThiDanhSach(req, resp);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        SanPham sanPham = sanPhamService.getOne(idParam);
        req.setAttribute("spu", sanPham);
        req.getRequestDispatcher("/view/SanPham/CapNhatSanPham.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/SanPham/ThemSanPham.jsp").forward(req, resp);
    }

    private void xoaSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("DeleteId");
        SanPham sanPham = sanPhamService.getOne(idParam);
        if (sanPham != null) {
            sanPhamService.remove(sanPham);
        }
        resp.sendRedirect("/san-pham/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-san-pham":
                themSanPham(req, resp);
                break;
            case "/cap-nhat-san-pham":
                capNhatSanPham(req, resp);
                break;
            default:
                resp.sendRedirect("/san-pham/hien-thi-danh-sach");
        }
    }

    private void themSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        SanPham sanPham = SanPham.builder()
                .ma(maParam)
                .ten(tenParam)
                .build();

        sanPhamService.add(sanPham);
        resp.sendRedirect("/san-pham/hien-thi-danh-sach");
    }

    private void capNhatSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");


        SanPham sanPham = SanPham.builder()
                .id(idParam)
                .ma(maParam)
                .ten(tenParam)
                .build();

        sanPhamService.update(sanPham);
        resp.sendRedirect("/san-pham/hien-thi-danh-sach");
    }
}
