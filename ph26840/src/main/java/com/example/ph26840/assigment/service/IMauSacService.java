package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.ChatLieu;
import com.example.ph26840.assigment.entity.Loai;
import com.example.ph26840.assigment.entity.MauSac;
import com.example.ph26840.assigment.entity.ThuongHieu;


import java.util.List;

public interface IMauSacService {
    List<MauSac> findAll();

    MauSac finByIdMS(Integer id);

}
