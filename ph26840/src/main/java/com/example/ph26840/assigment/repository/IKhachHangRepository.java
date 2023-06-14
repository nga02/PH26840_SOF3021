package com.example.ph26840.assigment.repository;

import com.example.ph26840.assigment.entity.KhachHang;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKhachHangRepository extends JpaRepository<KhachHang,Integer> {

}
