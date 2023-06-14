package com.example.ph26840.assigment.repository;

import com.example.ph26840.assigment.entity.GioHang;
import com.example.ph26840.assigment.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGioHangRepository extends JpaRepository<GioHang,Integer> {

    GioHang findByIdKH(KhachHang khachHang);

    void deleteById(GioHang gioHang);
}
