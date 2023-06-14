package com.example.ph26840.lab78.service;

import com.example.ph26840.lab78.entity.GiangVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGiangVienService {
    List<GiangVien> finAll();
    Page<GiangVien> getPage(Pageable pageable) ;
    void add(GiangVien giangVien);
    void update(GiangVien giangVien,Integer id);
    void delete(Integer id);
    GiangVien findById(Integer id);
}
