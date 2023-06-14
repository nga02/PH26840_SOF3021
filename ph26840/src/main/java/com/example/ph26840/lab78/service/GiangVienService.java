package com.example.ph26840.lab78.service;


import com.example.ph26840.lab78.entity.GiangVien;
import com.example.ph26840.lab78.repository.IGiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiangVienService implements IGiangVienService {

    @Autowired
    private IGiangVienRepository repository;

    @Override
    public List<GiangVien> finAll() {
        return repository.findAll();
    }

    @Override
    public Page<GiangVien> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(GiangVien giangVien) {
        repository.save(giangVien);
    }

    @Override
    public void update(GiangVien giangVien, Integer id) {
        GiangVien s = repository.findById(id).get();
        giangVien.setTen(s.getTen());
        giangVien.setBacLuong(s.getBacLuong());
        giangVien.setSoLop(s.getSoLop());
        giangVien.setBoMon(s.getBoMon());
        repository.save(s);
    }

    @Override
    public void delete(Integer id) {
        GiangVien s = repository.findById(id).get();
        repository.delete(s);
    }

    @Override
    public GiangVien findById(Integer id) {
        return repository.findById(id).get();
    }
}
