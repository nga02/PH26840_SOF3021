package com.example.ph26840.lab56.service;

import com.example.ph26840.lab56.entity.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISachService {
    List<Sach> finAll();
    Page<Sach>  getPage(Pageable pageable) ;
    void add(Sach sach);
    void update(Sach sach,Integer id);
    void delete(Integer id);
    Sach findById(Integer id);
}
