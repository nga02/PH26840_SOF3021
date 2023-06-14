package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.GioHang;
import com.example.ph26840.assigment.entity.GioHangChiTiet;
import com.example.ph26840.assigment.entity.SanPham;
import com.example.ph26840.assigment.repository.IGioHangChiTietRepository;
import com.example.ph26840.assigment.repository.ISanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class GioHangChiTietService {

    @Autowired
    IGioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    ISanPhamRepository spRepository;


    public List<GioHangChiTiet> findAll() {
        return gioHangChiTietRepository.findAll();
    }

    public GioHangChiTiet finById(Integer id) {
        return gioHangChiTietRepository.findById(id).get();
    }

    public GioHangChiTiet findByIdGHAndIdSP(GioHang gioHang, SanPham sanPham) {
        return gioHangChiTietRepository.findByIdGHAndIdSP(gioHang, sanPham);
    }

    public void themSPVaoGio(GioHangChiTiet gioHangChiTiet) {
        gioHangChiTietRepository.save(gioHangChiTiet);
    }

    public void delete(Integer id) {
        gioHangChiTietRepository.deleteById(id);
    }

    public void deleteGH() {
        gioHangChiTietRepository.deleteAll();
    }

    public BigDecimal getTotal(List<GioHangChiTiet> list) {
        return gioHangChiTietRepository.getTotal(list);
    }

}

//    public int soLuongSP(List<GioHangChiTiet> gioHangChiTiets) {
//        int totalItems = 0;
//        for (GioHangChiTiet item : gioHangChiTiets) {
//            totalItems += item.getSoLuong();
//        }
//        return totalItems;
//    }

//    public BigDecimal donGia(List<GioHangChiTiet> gioHangChiTiets) {
//        BigDecimal totalPrice = BigDecimal.ZERO;
//
//        for (GioHangChiTiet item : gioHangChiTiets) {
//            totalPrice = totalPrice.add(item.getDonGia());
//        }
//        return totalPrice;
//    }

//    public GioHangChiTiet findCartItem(List<GioHangChiTiet> listGioHangChiTiet, Integer idSP) {
//        if (listGioHangChiTiet == null) {
//            return null;
//        }
//        GioHangChiTiet gioHangChiTiet = null;
//
//        for (GioHangChiTiet item : listGioHangChiTiet) {
//            if (item.getIdSP().equals(idSP)) {
//                gioHangChiTiet = item;
//            }
//        }
//        return gioHangChiTiet;
//    }
