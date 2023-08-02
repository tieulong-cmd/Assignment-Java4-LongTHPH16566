package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.NhanVien;
import fpoly.longth.ph16566.repository.NhanVienRepository;
import fpoly.longth.ph16566.service.NhanVienService;

import java.util.List;

public class NhanVienServiceImpl implements NhanVienService {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public Boolean add(NhanVien nhanVien) {
        return nhanVienRepository.add(nhanVien);
    }

    @Override
    public Boolean remove(NhanVien nhanVien) {
        nhanVienRepository.remove(nhanVien);
        return true;
    }

    @Override
    public List<NhanVien> searchName(String ma) {
        return null;
    }

    @Override
    public Boolean update(NhanVien nhanVien) {
        return nhanVienRepository.update(nhanVien);
    }

    @Override
    public NhanVien getOne(String idParam) {
        return nhanVienRepository.getOne(idParam);
    }
}
