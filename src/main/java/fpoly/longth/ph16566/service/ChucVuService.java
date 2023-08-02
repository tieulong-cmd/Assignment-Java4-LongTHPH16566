package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.ChucVu;

import java.util.List;

public interface ChucVuService {
    List<ChucVu> getAll();

    Boolean add(ChucVu chucVu);

    Boolean remove(ChucVu chucVu);

    List<ChucVu> searchName(String ma);

    Boolean update(ChucVu chucVu);

    ChucVu getOne(String idParam);
}
