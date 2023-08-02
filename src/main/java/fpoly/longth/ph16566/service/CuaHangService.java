package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.CuaHang;

import java.util.List;

public interface CuaHangService {
    List<CuaHang> getAll();

    Boolean add(CuaHang cuaHang);

    Boolean remove(CuaHang cuaHang);

    List<CuaHang> searchName(String ma);

    Boolean update(CuaHang cuaHang);

    CuaHang getOne(String idParam);
}
