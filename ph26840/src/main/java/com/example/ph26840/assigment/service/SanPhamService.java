package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.*;
import com.example.ph26840.assigment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService{
    @Autowired
    private ISanPhamRepository repository;

    @Override
    public List<SanPham> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<SanPham> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public void update(SanPham sanPham, Integer id) {
        SanPham sp = repository.findById(id).get();
        sp.setMoTa(sanPham.getMoTa());
        sp.setTrangThai(sanPham.getTrangThai());
        sp.setGiaBan(sanPham.getGiaBan());
        sp.setGiaNhap(sanPham.getGiaNhap());
        sp.setSoLuong(sanPham.getSoLuong());
        sp.setIdLoai(sanPham.getIdLoai());
        sp.setIdChatLieu(sanPham.getIdChatLieu());
        sp.setIdMauSac(sanPham.getIdMauSac());
        sp.setIdThuongHieu(sanPham.getIdThuongHieu());
        repository.save(sp);
    }

    @Override
    public void delete(Integer id) {
        SanPham sp = repository.findById(id).get();
        repository.delete(sp);
    }

    @Override
    public SanPham finByIdSP(Integer id) {
        return repository.findById(id).get();
    }

}
