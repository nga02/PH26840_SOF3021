package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.ChatLieu;
import com.example.ph26840.assigment.entity.SanPham;

import java.util.List;

public interface IChatLieuService {
    List<ChatLieu> findAll();
    ChatLieu finByIdCL(Integer id);
}
