package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.*;

import java.util.List;

public interface IThuongHieuService {
    List<ThuongHieu> findAll();

    ThuongHieu finByIdTH(Integer id);
}
