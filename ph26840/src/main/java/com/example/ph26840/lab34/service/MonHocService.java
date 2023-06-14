package com.example.ph26840.lab34.service;

import com.example.ph26840.lab34.model.MonHoc;
import com.example.ph26840.lab34.repository.MonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MonHocService implements IMonHocService {

    @Autowired
    private MonHocRepository repository = new MonHocRepository();

    @Override
    public ArrayList<MonHoc> getAll() {
        return repository.getAll();
    }

    @Override
    public void add(MonHoc monHoc) {
        repository.add(monHoc);
    }

    @Override
    public void update(MonHoc monHoc, String ma) {
        repository.update(monHoc, ma);
    }

    @Override
    public void delete(String ma) {
        repository.delete(ma);
    }

    @Override
    public MonHoc findByMa(String ma) {
        return repository.findByMa(ma);
    }
}
