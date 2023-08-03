package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.MauSac;

import java.util.List;

public interface MauSacService {
    List<MauSac> getAll();

    Boolean add(MauSac mauSac);

    Boolean remove(MauSac mauSac);

    Boolean update(MauSac mauSac);

    MauSac getOne(String idParam);
}
