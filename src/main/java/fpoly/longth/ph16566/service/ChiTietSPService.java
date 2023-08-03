package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.ChiTietSP;

import java.util.List;

public interface ChiTietSPService {
    List<ChiTietSP> getAll();

    Boolean add(ChiTietSP chiTietSP);

    Boolean remove(ChiTietSP chiTietSP);

    Boolean update(ChiTietSP chiTietSP);

    ChiTietSP getOne(String idParam);
}
