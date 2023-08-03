package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.MauSac;
import fpoly.longth.ph16566.service.MauSacService;
import fpoly.longth.ph16566.service.impl.MauSacServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mau-sac/*")
public class MauSacServlet extends HttpServlet {
    private MauSacService mauSacService = new MauSacServiceImpl();

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
//                timKiemMauSac(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
            case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-mau-sac":
                xoaMauSac(req, resp);
                break;
            default:
                resp.sendRedirect("/mau-sac/hien-thi-danh-sach");
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MauSac> mauSacList = mauSacService.getAll();
        req.setAttribute("mauSac", mauSacList);
        req.getRequestDispatcher("/view/MauSac/MauSac.jsp").forward(req, resp);
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        MauSac mauSac = mauSacService.getOne(idParam);
        req.setAttribute("ms", mauSac);

        hienThiDanhSach(req, resp);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        MauSac mauSac = mauSacService.getOne(idParam);
        req.setAttribute("msu", mauSac);
        req.getRequestDispatcher("/view/MauSac/CapNhatMauSac.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/MauSac/ThemMauSac.jsp").forward(req, resp);
    }

    private void xoaMauSac(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("DeleteId");
        MauSac mauSac = mauSacService.getOne(idParam);
        if (mauSac != null) {
            mauSacService.remove(mauSac);
        }
        resp.sendRedirect("/mau-sac/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-mau-sac":
                themMauSac(req, resp);
                break;
            case "/cap-nhat-mau-sac":
                capNhatMauSac(req, resp);
                break;
            default:
                resp.sendRedirect("/mau-sac/hien-thi-danh-sach");
        }
    }

    private void themMauSac(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        MauSac mauSac = MauSac.builder()
                .ma(maParam)
                .ten(tenParam)
                .build();

        mauSacService.add(mauSac);
        resp.sendRedirect("/mau-sac/hien-thi-danh-sach");
    }

    private void capNhatMauSac(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        MauSac mauSac = MauSac.builder()
                .id(idParam)
                .ma(maParam)
                .ten(tenParam)
                .build();

        mauSacService.update(mauSac);
        resp.sendRedirect("/mau-sac/hien-thi-danh-sach");
    }
}
