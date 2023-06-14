package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.HoaDon;
import com.example.ph26840.assigment.repository.IHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonService  {
    @Autowired
    private IHoaDonRepository hoaDonRepository;


    public List<HoaDon> findAll() {
        return hoaDonRepository.findAll();
    }


    public void saveHoaDon(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }


    public void delete(Integer id) {

    }


    public HoaDon findById(Integer id) {
        return hoaDonRepository.findById(id).get();
    }


    public int soLuong(List<HoaDon> hoaDons) {
        return 0;
    }


    public String generateInvoiceCode() {
        // Lấy thời gian hiện tại
        long timestamp = System.currentTimeMillis();

        // Tạo mã hoá đơn từ timestamp
        String code = "HD" + timestamp;

        return code;
    }
}
