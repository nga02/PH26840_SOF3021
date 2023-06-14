package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.ChatLieu;
import com.example.ph26840.assigment.entity.Loai;
import com.example.ph26840.assigment.repository.IChatLieuRepository;
import com.example.ph26840.assigment.repository.ILoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoaiService implements ILoaiService{
    @Autowired
    private ILoaiRepository repository;
    @Override
    public List<Loai> findAll() {
        return repository.findAll();
    }

    @Override
    public Loai finByIdLoai(Integer id) {
        return repository.findById(id).get();
    }
}
