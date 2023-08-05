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

@WebServlet("/chi-tiet-sp/*")
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImpl();

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
//                timKiemChiTietSP(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
            case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-chi-tiet-sp":
                xoaChiTietSP(req, resp);
                break;
            default:
                resp.sendRedirect("/chi-tiet-sp/hien-thi-danh-sach");
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ChiTietSP> chiTietSPList = chiTietSPService.getAll();
        req.setAttribute("chiTietSP", chiTietSPList);

        req.getRequestDispatcher("/view/ChiTietSP/ChiTietSP.jsp").forward(req, resp);
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        ChiTietSP chiTietSP = chiTietSPService.getOne(idParam);
        req.setAttribute("CTSPV", chiTietSP);

        hienThiDanhSach(req, resp);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        ChiTietSP chiTietSP = chiTietSPService.getOne(idParam);
        req.setAttribute("CTSPU", chiTietSP);
        req.getRequestDispatcher("/view/ChiTietSP/CapNhatChiTietSP.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/ChiTietSP/ThemChiTietSP.jsp").forward(req, resp);
    }

    private void xoaChiTietSP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("DeleteId");
        ChiTietSP chiTietSP = chiTietSPService.getOne(idParam);
        if (chiTietSP != null) {
            chiTietSPService.remove(chiTietSP);
        }
        resp.sendRedirect("/chi-tiet-sp/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-chi-tiet-sp":
                themChiTietSP(req, resp);
                break;
            case "/cap-nhat-chi-tiet-sp":
                capNhatChiTietSP(req, resp);
                break;
            default:
                resp.sendRedirect("/chi-tiet-sp/hien-thi-danh-sach");
        }
    }

    private void themChiTietSP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idSPParam = req.getParameter("idSP");
        String idNsxParam = req.getParameter("idNsx");
        String idMauSacParam = req.getParameter("idMauSac");
        String idDongSPParam = req.getParameter("idDongSP");
        String namBHParam = req.getParameter("namBH");
        String moTaParam = req.getParameter("moTa");
        String soLuongTonParam = req.getParameter("soLuongTon");
        String giaNhapParam = req.getParameter("giaNhap");
        String giaBanParam = req.getParameter("giaBan");

        ChiTietSP chiTietSP = ChiTietSP.builder()
                .idSP(idSPParam)
                .idNsx(idNsxParam)
                .idMauSac(idMauSacParam)
                .idDongSP(idDongSPParam)
                .namBH(Integer.valueOf(namBHParam))
                .moTa(moTaParam)
                .soLuongTon(Integer.valueOf(soLuongTonParam))
                .giaNhap(Double.valueOf(giaNhapParam))
                .giaBan(Double.valueOf(giaBanParam))
                .build();

        chiTietSPService.add(chiTietSP);
        resp.sendRedirect("/chi-tiet-sp/hien-thi-danh-sach");
    }

    private void capNhatChiTietSP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String idSPParam = req.getParameter("idSP");
        String idNsxParam = req.getParameter("idNsx");
        String idMauSacParam = req.getParameter("idMauSac");
        String idDongSPParam = req.getParameter("idDongSP");
        String namBHParam = req.getParameter("namBH");
        String moTaParam = req.getParameter("moTa");
        String soLuongTonParam = req.getParameter("soLuongTon");
        String giaNhapParam = req.getParameter("giaNhap");
        String giaBanParam = req.getParameter("giaBan");

        ChiTietSP chiTietSP = ChiTietSP.builder()
                .id(idParam)
                .idSP(idSPParam)
                .idNsx(idNsxParam)
                .idMauSac(idMauSacParam)
                .idDongSP(idDongSPParam)
                .namBH(Integer.valueOf(namBHParam))
                .moTa(moTaParam)
                .soLuongTon(Integer.valueOf(soLuongTonParam))
                .giaNhap(Double.valueOf(giaNhapParam))
                .giaBan(Double.valueOf(giaBanParam))
                .build();

        chiTietSPService.update(chiTietSP);
        resp.sendRedirect("/chi-tiet-sp/hien-thi-danh-sach");
    }
}
