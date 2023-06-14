package com.example.ph26840.assigment.service;


import com.example.ph26840.assigment.entity.*;
import com.example.ph26840.lab34.model.MonHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> findAll();
    Page<SanPham> getPage(Pageable pageable);
    void add(SanPham sanPham);
    void update(SanPham sanPham,Integer id);
    void delete(Integer id);
    SanPham finByIdSP(Integer id);

}
