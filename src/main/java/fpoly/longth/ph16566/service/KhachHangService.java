package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> getAll();

    Boolean add(KhachHang kh);

    Boolean remove(KhachHang kh);

    KhachHang detail(String ma);

    List<KhachHang> searchName(String ma);

    Boolean update(KhachHang kh);

    KhachHang getOne(String idParam);
}
