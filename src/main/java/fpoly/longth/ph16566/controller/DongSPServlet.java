package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.DongSP;
import fpoly.longth.ph16566.service.DongSPService;
import fpoly.longth.ph16566.service.impl.DongSPServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/dong-sp/*")
public class DongSPServlet extends HttpServlet {
    private DongSPService dongSPService = new DongSPServiceImpl();

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
//                timKiemDongSP(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
            case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-dong-sp":
                xoaDongSP(req, resp);
                break;
            default:
                resp.sendRedirect("/dong-sp/hien-thi-danh-sach");
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DongSP> dongSPList = dongSPService.getAll();
        req.setAttribute("dongSanPham", dongSPList);
        req.getRequestDispatcher("/view/DongSP/DongSP.jsp").forward(req, resp);
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        DongSP dongSP = dongSPService.getOne(idParam);
        req.setAttribute("dsp", dongSP);

        hienThiDanhSach(req, resp);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        DongSP dongSP = dongSPService.getOne(idParam);
        req.setAttribute("dspu", dongSP);
        req.getRequestDispatcher("/view/DongSP/CapNhatDongSP.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/DongSP/ThemDongSP.jsp").forward(req, resp);
    }

    private void xoaDongSP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("DeleteId");
        DongSP dongSP = dongSPService.getOne(idParam);
        if (dongSP != null) {
            dongSPService.remove(dongSP);
        }
        resp.sendRedirect("/dong-sp/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-dong-sp":
                themDongSP(req, resp);
                break;
            case "/cap-nhat-dong-sp":
                capNhatDongSP(req, resp);
                break;
            default:
                resp.sendRedirect("/dong-sp/hien-thi-danh-sach");
        }
    }

    private void themDongSP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        DongSP dongSP = DongSP.builder()
                .ma(maParam)
                .ten(tenParam)
                .build();

        dongSPService.add(dongSP);
        resp.sendRedirect("/dong-sp/hien-thi-danh-sach");
    }

    private void capNhatDongSP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        DongSP dongSP = DongSP.builder()
                .id(idParam)
                .ma(maParam)
                .ten(tenParam)
                .build();

        dongSPService.update(dongSP);
        resp.sendRedirect("/dong-sp/hien-thi-danh-sach");
    }
}
