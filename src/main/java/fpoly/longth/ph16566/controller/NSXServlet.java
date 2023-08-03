package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.NSX;
import fpoly.longth.ph16566.service.NSXService;
import fpoly.longth.ph16566.service.impl.NSXServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/nsx/*")
public class NSXServlet extends HttpServlet {
    private NSXService nsxService = new NSXServiceImpl();

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
//                timKiemNSX(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
            case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-nsx":
                xoaNSX(req, resp);
                break;
            default:
                resp.sendRedirect("/nsx/hien-thi-danh-sach");
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NSX> nsxList = nsxService.getAll();
        req.setAttribute("nhaSanXuat", nsxList);
        req.getRequestDispatcher("/view/NSX/NSX.jsp").forward(req, resp);
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        NSX nsx = nsxService.getOne(idParam);
        req.setAttribute("nsx", nsx);

        hienThiDanhSach(req, resp);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        NSX nsx = nsxService.getOne(idParam);
        req.setAttribute("nsxu", nsx);
        req.getRequestDispatcher("/view/NSX/CapNhatNSX.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/NSX/ThemNSX.jsp").forward(req, resp);
    }

    private void xoaNSX(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("DeleteId");
        NSX nsx = nsxService.getOne(idParam);
        if (nsx != null) {
            nsxService.remove(nsx);
        }
        resp.sendRedirect("/nsx/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-nsx":
                themNSX(req, resp);
                break;
            case "/cap-nhat-nsx":
                capNhatNSX(req, resp);
                break;
            default:
                resp.sendRedirect("/nsx/hien-thi-danh-sach");
        }
    }

    private void themNSX(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        NSX nsx = NSX.builder()
                .ma(maParam)
                .ten(tenParam)
                .build();

        nsxService.add(nsx);
        resp.sendRedirect("/nsx/hien-thi-danh-sach");
    }

    private void capNhatNSX(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        NSX nsx = NSX.builder()
                .id(idParam)
                .ma(maParam)
                .ten(tenParam)
                .build();

        nsxService.update(nsx);
        resp.sendRedirect("/nsx/hien-thi-danh-sach");
    }
}
