package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.GioHang;
import com.example.ph26840.assigment.entity.GioHangChiTiet;
import com.example.ph26840.assigment.entity.KhachHang;
import com.example.ph26840.assigment.repository.IGioHangChiTietRepository;
import com.example.ph26840.assigment.repository.IGioHangRepository;
import com.example.ph26840.assigment.repository.IKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangService {

    @Autowired
    private IGioHangRepository gioHangRepository;
    @Autowired
    private IGioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    private IKhachHangRepository khRepository;

    public List<GioHang> getAll() {
        return gioHangRepository.findAll();
    }

    public GioHang finByIdKH(KhachHang khachHang) {
        return gioHangRepository.findByIdKH(khachHang);
    }

    public void addGioHang(GioHang gioHang) {
        gioHangRepository.save(gioHang);
    }

    public void deleteAllGioHang() {
        gioHangChiTietRepository.deleteAll();
        gioHangRepository.deleteAll();
    }

//    public void deleteGH(GioHang gioHang) {
//        gioHangRepository.deleteById(gioHang);
//        gioHangChiTietRepository.deleteByIdGH(gioHang);
//    }

}



