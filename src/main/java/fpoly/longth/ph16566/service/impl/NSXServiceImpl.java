package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.NSX;
import fpoly.longth.ph16566.repository.NSXRepository;
import fpoly.longth.ph16566.service.NSXService;

import java.util.List;

public class NSXServiceImpl implements NSXService {
    private NSXRepository nsxRepository = new NSXRepository();

    @Override
    public List<NSX> getAll() {
        return nsxRepository.getAll();
    }

    @Override
    public Boolean add(NSX nsx) {
        return nsxRepository.add(nsx);
    }

    @Override
    public Boolean remove(NSX nsx) {
        return nsxRepository.remove(nsx);
    }

    @Override
    public Boolean update(NSX nsx) {
        return nsxRepository.update(nsx);
    }

    @Override
    public NSX getOne(String idParam) {
        return nsxRepository.getOne(idParam);
    }
}
