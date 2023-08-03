package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.NSX;

import java.util.List;

public interface NSXService {
    List<NSX> getAll();

    Boolean add(NSX nsx);

    Boolean remove(NSX nsx);

    Boolean update(NSX nsx);

    NSX getOne(String idParam);
}
