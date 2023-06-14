package com.example.ph26840.lab34.repository;

import com.example.ph26840.lab34.model.MonHoc;

import java.util.ArrayList;

public interface IMonHocRepository {
    ArrayList<MonHoc> getAll();
    void add(MonHoc monHoc);
    void update(MonHoc monHoc,String ma);
    void delete(String ma);
    MonHoc findByMa(String ma);
}
