package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.SanPham;
import fpoly.longth.ph16566.repository.SanPhamRepository;
import fpoly.longth.ph16566.service.SanPhamService;

import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public Boolean add(SanPham sanPham) {
        return sanPhamRepository.add(sanPham);
    }

    @Override
    public Boolean remove(SanPham sanPham) {
        return sanPhamRepository.remove(sanPham);
    }

    @Override
    public Boolean update(SanPham sanPham) {
        return sanPhamRepository.update(sanPham);
    }

    @Override
    public SanPham getOne(String idParam) {
        return sanPhamRepository.getOne(idParam);
    }
}
