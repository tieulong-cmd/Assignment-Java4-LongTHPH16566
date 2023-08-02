package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.ChucVu;
import fpoly.longth.ph16566.repository.ChucVuRepository;
import fpoly.longth.ph16566.service.ChucVuService;

import java.util.List;

public class ChucVuServiceImpl implements ChucVuService {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public Boolean add(ChucVu chucVu) {
        return chucVuRepository.add(chucVu);
    }

    @Override
    public Boolean remove(ChucVu chucVu) {
        return chucVuRepository.remove(chucVu);
    }

    @Override
    public List<ChucVu> searchName(String ma) {
        return null;
    }

    @Override
    public Boolean update(ChucVu chucVu) {
        return chucVuRepository.update(chucVu);
    }

    @Override
    public ChucVu getOne(String idParam) {
        return chucVuRepository.getOne(idParam);
    }
}
