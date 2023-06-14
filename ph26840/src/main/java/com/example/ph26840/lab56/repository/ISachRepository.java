package com.example.ph26840.lab56.repository;

import com.example.ph26840.assigment.entity.SanPham;
import com.example.ph26840.lab56.entity.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISachRepository extends JpaRepository<Sach,Integer> {
    Page<Sach> findAll(Pageable pageable);

    Page<Sach> findAllByOrderByNamXBDesc(Pageable pageable);
    Page<Sach> findByTenContaining(String ten, Pageable pageable);

    @Query("SELECT s FROM Sach s ORDER BY s.namXB ASC")
    List<Sach> findAllOrderByNamXB();
}
