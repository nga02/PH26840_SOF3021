package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.ChatLieu;

import com.example.ph26840.assigment.repository.IChatLieuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChatLieuService implements IChatLieuService{
    @Autowired
    private IChatLieuRepository repository;
    @Override
    public List<ChatLieu> findAll() {
        return repository.findAll();
    }

    @Override
    public ChatLieu finByIdCL(Integer id) {
        return repository.findById(id).get();
    }


}
