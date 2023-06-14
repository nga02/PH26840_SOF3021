package com.example.ph26840.assigment.repository;

import com.example.ph26840.assigment.entity.GioHang;
import com.example.ph26840.assigment.entity.GioHangChiTiet;

import com.example.ph26840.assigment.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IGioHangChiTietRepository extends JpaRepository<GioHangChiTiet, Integer> {

    GioHangChiTiet findByIdGHAndIdSP(GioHang gioHang, SanPham sanPham);

    List<GioHangChiTiet> findByIdGH(Integer idGH);

    @Query("SELECT SUM(donGia) FROM GioHangChiTiet")
    BigDecimal getTotal(List<GioHangChiTiet> list);


}
