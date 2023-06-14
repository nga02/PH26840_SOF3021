package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.HoaDon;
import com.example.ph26840.assigment.entity.HoaDonChiTiet;
import com.example.ph26840.assigment.repository.IHoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonChiTietService  {

    @Autowired
    private IHoaDonChiTietRepository hoaDonChiTietRepository;


    public List<HoaDonChiTiet> findAll() {
        return null;
    }

    public List<HoaDonChiTiet> findByHD(HoaDon hoaDon) {
        return hoaDonChiTietRepository.findByIdHD(hoaDon);
    }

    public void save(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }


    public void delete(Integer id) {

    }


    public HoaDonChiTiet findById(Integer id) {
        return null;
    }


    public int soLuong(List<HoaDonChiTiet> hoaDonChiTiets) {
        return 0;
    }
}
