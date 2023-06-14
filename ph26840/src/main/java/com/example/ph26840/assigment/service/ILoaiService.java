package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.*;

import java.util.List;

public interface ILoaiService {
    List<Loai> findAll();

    Loai finByIdLoai(Integer id);

}
