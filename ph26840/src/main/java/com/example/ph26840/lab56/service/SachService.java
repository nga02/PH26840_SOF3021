package com.example.ph26840.lab56.service;


import com.example.ph26840.lab56.entity.Sach;
import com.example.ph26840.lab56.repository.ISachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SachService implements ISachService {
    @Autowired
    private ISachRepository repository;

    @Override
    public List<Sach> finAll() {
        return repository.findAll();
    }

    @Override
    public Page<Sach> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Sach sach) {
        repository.save(sach);
    }

    @Override
    public void update(Sach sach, Integer id) {
        Sach s = repository.findById(id).get();
        sach.setTen(s.getTen());
        sach.setNamXB(s.getNamXB());
        repository.save(s);
    }

    @Override
    public void delete(Integer id) {
        Sach s = repository.findById(id).get();
        repository.delete(s);
    }

    @Override
    public Sach findById(Integer id) {
        return repository.findById(id).get();
    }
}
