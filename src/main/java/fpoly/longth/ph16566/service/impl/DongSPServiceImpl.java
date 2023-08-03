package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.DongSP;
import fpoly.longth.ph16566.repository.DongSPRepository;
import fpoly.longth.ph16566.service.DongSPService;

import java.util.List;

public class DongSPServiceImpl implements DongSPService {
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.getAll();
    }

    @Override
    public Boolean add(DongSP dongSP) {
        return dongSPRepository.add(dongSP);
    }

    @Override
    public Boolean remove(DongSP dongSP) {
        return dongSPRepository.remove(dongSP);
    }

    @Override
    public Boolean update(DongSP dongSP) {
        return dongSPRepository.update(dongSP);
    }

    @Override
    public DongSP getOne(String idParam) {
        return dongSPRepository.getOne(idParam);
    }
}
