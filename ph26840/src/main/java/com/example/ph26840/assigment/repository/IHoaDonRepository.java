package com.example.ph26840.assigment.repository;
import com.example.ph26840.assigment.entity.HoaDon;

import com.example.ph26840.assigment.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHoaDonRepository extends JpaRepository<HoaDon,Integer> {
    Page<HoaDon> findAll(Pageable pageable);
    Page<HoaDon> findByMaContains(String ma, Pageable pageable);
}
