package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.ChiTietSP;
import fpoly.longth.ph16566.repository.ChiTietSPRepository;
import fpoly.longth.ph16566.service.ChiTietSPService;

import java.util.List;

public class ChiTietSPServiceImpl implements ChiTietSPService {
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    public List<ChiTietSP> getAll() {
        return chiTietSPRepository.getAll();
    }

    @Override
    public Boolean add(ChiTietSP chiTietSP) {
        return chiTietSPRepository.add(chiTietSP);
    }

    @Override
    public Boolean remove(ChiTietSP chiTietSP) {
        return chiTietSPRepository.remove(chiTietSP);
    }

    @Override
    public Boolean update(ChiTietSP chiTietSP) {
        return chiTietSPRepository.update(chiTietSP);
    }

    @Override
    public ChiTietSP getOne(String idParam) {
        return chiTietSPRepository.getOne(idParam);
    }
}
