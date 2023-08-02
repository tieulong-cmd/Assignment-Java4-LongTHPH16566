package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.NhanVien;

import java.util.List;

public interface NhanVienService {
    List<NhanVien> getAll();

    Boolean add(NhanVien nhanVien);

    Boolean remove(NhanVien nv);

    List<NhanVien> searchName(String ma);

    Boolean update(NhanVien nhanVien);

    NhanVien getOne(String idParam);
}
