package com.example.ph26840.lab34.repository;

import com.example.ph26840.lab34.model.DongHo;

import java.util.ArrayList;

public interface IDongHoRepository {
    ArrayList<DongHo> getAll();
    void add(DongHo dongHo);
    void update(DongHo dongHo,String ma);
    void delete(String ma);
    DongHo findByMa(String ma);
}
