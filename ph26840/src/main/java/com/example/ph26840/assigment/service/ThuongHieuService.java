package com.example.ph26840.assigment.service;


import com.example.ph26840.assigment.entity.ThuongHieu;

import com.example.ph26840.assigment.repository.IThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThuongHieuService implements IThuongHieuService{
    @Autowired
    private IThuongHieuRepository repository;
    @Override
    public List<ThuongHieu> findAll() {
        return repository.findAll();
    }

    @Override
    public ThuongHieu finByIdTH(Integer id) {
        return repository.findById(id).get();
    }
}
