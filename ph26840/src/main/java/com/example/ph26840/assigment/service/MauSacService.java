package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.ChatLieu;
import com.example.ph26840.assigment.entity.MauSac;
import com.example.ph26840.assigment.repository.IChatLieuRepository;
import com.example.ph26840.assigment.repository.IMauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MauSacService implements IMauSacService{
    @Autowired
    private IMauSacRepository repository;
    @Override
    public List<MauSac> findAll() {
        return repository.findAll();
    }

    @Override
    public MauSac finByIdMS(Integer id) {
        return repository.findById(id).get();
    }
}
