package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();

    Boolean add(SanPham sanPham);

    Boolean remove(SanPham sanPham);

    Boolean update(SanPham sanPham);

    SanPham getOne(String idParam);
}
