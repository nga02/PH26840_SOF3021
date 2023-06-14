package com.example.ph26840.lab78.repository;


import com.example.ph26840.lab78.entity.GiangVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGiangVienRepository extends JpaRepository<GiangVien,Integer> {
   Page<GiangVien> findAllByOrderBySoLopDesc(Pageable pageable);
   Page<GiangVien> findByTenContaining(String ten,Pageable pageable);

}
