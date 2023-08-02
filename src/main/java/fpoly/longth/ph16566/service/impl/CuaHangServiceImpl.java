package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.CuaHang;
import fpoly.longth.ph16566.repository.CuaHangRepository;
import fpoly.longth.ph16566.service.CuaHangService;

import java.util.List;

public class CuaHangServiceImpl implements CuaHangService {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.getAll();
    }

    @Override
    public Boolean add(CuaHang cuaHang) {
        return cuaHangRepository.add(cuaHang);
    }

    @Override
    public Boolean remove(CuaHang cuaHang) {
        return cuaHangRepository.remove(cuaHang);
    }


    @Override
    public List<CuaHang> searchName(String ma) {
        return null;
    }

    @Override
    public Boolean update(CuaHang cuaHang) {
        return cuaHangRepository.update(cuaHang);
    }

    @Override
    public CuaHang getOne(String idParam) {
        return cuaHangRepository.getOne(idParam);
    }
}
