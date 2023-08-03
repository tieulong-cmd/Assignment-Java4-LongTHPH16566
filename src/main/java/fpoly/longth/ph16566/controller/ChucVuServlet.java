package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.ChucVu;
import fpoly.longth.ph16566.service.ChucVuService;
import fpoly.longth.ph16566.service.impl.ChucVuServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/chuc-vu/*")
public class ChucVuServlet extends HttpServlet {
    private ChucVuService chucVuService = new ChucVuServiceImpl();

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
                timKiemChucVu(req, resp);
                break;
            case "/hien-thi-cap-nhat":
                hienThiCapNhat(req, resp);
                break;
            case "/hien-thi-them":
                hienThiThem(req, resp);
                break;
            case "/xoa-chuc-vu":
                xoaChucVu(req, resp);
                break;
            default:
                resp.sendRedirect("/chuc-vu/hien-thi-danh-sach");
        }
    }

    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ChucVu> chucVuList = chucVuService.getAll();
        req.setAttribute("chucVu", chucVuList);
        req.getRequestDispatcher("/view/ChucVu/ChucVu.jsp").forward(req, resp);
    }

    private void hienThiChiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("DetailId");
        ChucVu chucVu = chucVuService.getOne(idParam);
        req.setAttribute("cvc", chucVu);

        hienThiDanhSach(req, resp);
    }

    private void timKiemChucVu(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String maParam = req.getParameter("ma");
        List<ChucVu> chucVuList = chucVuService.searchName(maParam);
        req.setAttribute("chucVu", chucVuList);
        req.getRequestDispatcher("/view/ChucVu/ChucVu.jsp").forward(req, resp);
    }

    private void hienThiCapNhat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("UpdateId");
        ChucVu chucVu = chucVuService.getOne(idParam);
        req.setAttribute("cvcu", chucVu);
        req.getRequestDispatcher("/view/ChucVu/CapNhatChucVu.jsp").forward(req, resp);
    }

    private void hienThiThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/ChucVu/ThemChucVu.jsp").forward(req, resp);
    }

    private void xoaChucVu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("DeleteId");
        ChucVu chucVu = chucVuService.getOne(idParam);
        if (chucVu != null) {
            chucVuService.remove(chucVu);
        }
        resp.sendRedirect("/chuc-vu/hien-thi-danh-sach");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/hien-thi-danh-sach";
        }

        switch (action) {
            case "/them-chuc-vu":
                themChucVu(req, resp);
                break;
            case "/cap-nhat-chuc-vu":
                capNhatChucVu(req, resp);
                break;
            default:
                resp.sendRedirect("/chuc-vu/hien-thi-danh-sach");
        }
    }

    private void themChucVu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        ChucVu chucVu = ChucVu.builder()
                .ma(maParam)
                .ten(tenParam)
                .build();

        chucVuService.add(chucVu);
        resp.sendRedirect("/chuc-vu/hien-thi-danh-sach");
    }

    private void capNhatChucVu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");

        ChucVu chucVu = ChucVu.builder()
                .id(idParam)
                .ma(maParam)
                .ten(tenParam)
                .build();

        chucVuService.update(chucVu);
        resp.sendRedirect("/chuc-vu/hien-thi-danh-sach");
    }
}
