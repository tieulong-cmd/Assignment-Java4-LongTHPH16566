package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.CuaHang;
import fpoly.longth.ph16566.service.CuaHangService;
import fpoly.longth.ph16566.service.impl.CuaHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/cua-hang/*")
public class CuaHangServlet extends HttpServlet {
    private CuaHangService cuaHangService = new CuaHangServiceImpl();

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
                timKiemCuaHang(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
            case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-cua-hang":
                xoaCuaHang(req, resp);
                break;
            default:
                resp.sendRedirect("/cua-hang/hien-thi-danh-sach");
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CuaHang> cuaHangList = cuaHangService.getAll();
        req.setAttribute("cuaHang", cuaHangList);
        req.getRequestDispatcher("/view/CuaHang/CuaHang.jsp").forward(req, resp);
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        CuaHang cuaHang = cuaHangService.getOne(idParam);
        req.setAttribute("chv", cuaHang);
        req.getRequestDispatcher("/view/CuaHang/ChiTietCuaHang.jsp").forward(req, resp);
    }

    private void timKiemCuaHang(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String tenParam = req.getParameter("ten");
        List<CuaHang> cuaHangList = cuaHangService.searchName(tenParam);
        req.setAttribute("cuaHang", cuaHangList);
        req.getRequestDispatcher("/view/CuaHang/CuaHang.jsp").forward(req, resp);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        CuaHang cuaHang = cuaHangService.getOne(idParam);
        req.setAttribute("chu", cuaHang);
        req.getRequestDispatcher("/view/CuaHang/CapNhatCuaHang.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/CuaHang/ThemCuaHang.jsp").forward(req, resp);
    }

    private void xoaCuaHang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("DeleteId");
        CuaHang cuaHang = cuaHangService.getOne(idParam);
        if (cuaHang != null) {
            cuaHangService.remove(cuaHang);
        }
        resp.sendRedirect("/cua-hang/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-cua-hang":
                themCuaHang(req, resp);
                break;
            case "/cap-nhat-cua-hang":
                capNhatCuaHang(req, resp);
                break;
            default:
                resp.sendRedirect("/cua-hang/hien-thi-danh-sach");
        }
    }

    private void themCuaHang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String diaChiParam = req.getParameter("diaChi");
        String thanhPhoParam = req.getParameter("thanhPho");
        String quocGiaParam = req.getParameter("quocGia");

        CuaHang cuaHang = CuaHang.builder()
                .ma(maParam)
                .ten(tenParam)
                .diaChi(diaChiParam)
                .thanhPho(thanhPhoParam)
                .quocGia(quocGiaParam)
                .build();
        cuaHangService.add(cuaHang);
        resp.sendRedirect("/cua-hang/hien-thi-danh-sach");
    }

    private void capNhatCuaHang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String diaChiParam = req.getParameter("diaChi");
        String thanhPhoParam = req.getParameter("thanhPho");
        String quocGiaParam = req.getParameter("quocGia");

        CuaHang cuaHang = CuaHang.builder()
                .id(String.valueOf(Long.parseLong(idParam)))
                .ma(maParam)
                .ten(tenParam)
                .diaChi(diaChiParam)
                .thanhPho(thanhPhoParam)
                .quocGia(quocGiaParam)
                .build();
        cuaHangService.update(cuaHang);
        resp.sendRedirect("/cua-hang/hien-thi-danh-sach");
    }
}
