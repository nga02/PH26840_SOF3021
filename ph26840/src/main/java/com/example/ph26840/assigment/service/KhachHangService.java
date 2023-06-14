package com.example.ph26840.assigment.service;
import com.example.ph26840.assigment.entity.KhachHang;
import com.example.ph26840.assigment.repository.IKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KhachHangService {
    @Autowired
    private IKhachHangRepository repository;


    public List<KhachHang> findAll() {
        return repository.findAll();
    }

    public void add(KhachHang khachHang) {
        repository.save(khachHang);
    }

    public void update(KhachHang sp, Integer id) {
        KhachHang khachHang = repository.findById(id).get();
        sp.setTen(khachHang.getTen());
        sp.setDiaChi(khachHang.getDiaChi());
        sp.setSdt(khachHang.getSdt());
        sp.setMatKhau(khachHang.getMatKhau());
        repository.save(sp);
    }

    public void delete(Integer id) {
        KhachHang sp = repository.findById(id).get();
        repository.delete(sp);
    }

    public KhachHang finByIdKH(Integer id) {
        return repository.findById(id).get();
    }
}
