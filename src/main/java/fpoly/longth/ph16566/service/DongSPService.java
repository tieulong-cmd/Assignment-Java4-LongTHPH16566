package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.DongSP;

import java.util.List;

public interface DongSPService {
    List<DongSP> getAll();

    Boolean add(DongSP dongSP);

    Boolean remove(DongSP dongSP);

    Boolean update(DongSP dongSP);

    DongSP getOne(String idParam);
}
