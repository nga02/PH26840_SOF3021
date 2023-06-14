package com.example.ph26840.assigment.repository;

import com.example.ph26840.assigment.entity.HoaDon;
import com.example.ph26840.assigment.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
    List<HoaDonChiTiet> findByIdHD(HoaDon hoaDon);
}
