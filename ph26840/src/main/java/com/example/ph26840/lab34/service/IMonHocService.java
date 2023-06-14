package com.example.ph26840.lab34.service;

import com.example.ph26840.lab34.model.MonHoc;

import java.util.ArrayList;

public interface IMonHocService {
    ArrayList<MonHoc> getAll();
    void add(MonHoc monHoc);
    void update(MonHoc monHoc,String ma);
    void delete(String ma);
    MonHoc findByMa(String ma);
}
