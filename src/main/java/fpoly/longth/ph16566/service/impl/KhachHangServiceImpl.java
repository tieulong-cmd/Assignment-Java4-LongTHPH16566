package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.KhachHang;
import fpoly.longth.ph16566.repository.KhachHangRepository;
import fpoly.longth.ph16566.service.KhachHangService;

import java.util.List;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public Boolean add(KhachHang kh) {
        return khachHangRepository.add(kh);
    }

    @Override
    public void remove(KhachHang kh) {
        khachHangRepository.remove(kh);
    }

    @Override
    public KhachHang detail(String ma) {
        return khachHangRepository.getOne(ma);
    }

    @Override
    public List<KhachHang> searchName(String tenParam) {
        return khachHangRepository.filterByName(tenParam);
    }

    @Override
    public Boolean update(KhachHang kh) {
        return khachHangRepository.update(kh);
    }
}
