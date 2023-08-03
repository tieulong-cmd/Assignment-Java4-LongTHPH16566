package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.MauSac;
import fpoly.longth.ph16566.repository.MauSacRepository;
import fpoly.longth.ph16566.service.MauSacService;

import java.util.List;

public class MauSacServiceImpl implements MauSacService {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public Boolean add(MauSac mauSac) {
        return mauSacRepository.add(mauSac);
    }

    @Override
    public Boolean remove(MauSac mauSac) {
        return mauSacRepository.remove(mauSac);
    }

    @Override
    public Boolean update(MauSac mauSac) {
        return mauSacRepository.update(mauSac);
    }

    @Override
    public MauSac getOne(String idParam) {
        return mauSacRepository.getOne(idParam);
    }
}
