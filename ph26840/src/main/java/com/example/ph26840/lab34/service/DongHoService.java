package com.example.ph26840.lab34.service;

import com.example.ph26840.lab34.model.DongHo;
import com.example.ph26840.lab34.repository.DongHoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class DongHoService implements IDongHoService {

    @Autowired
    private DongHoRepository dongHoRepository = new DongHoRepository();

    @Override
    public ArrayList<DongHo> getAll() {
        return dongHoRepository.getAll();
    }

    @Override
    public void add(DongHo dongHo) {
        dongHoRepository.add(dongHo);
    }

    @Override
    public void update(DongHo dongHo, String ma) {
        dongHoRepository.update(dongHo, ma);
    }

    @Override
    public void delete(String ma) {
        dongHoRepository.delete(ma);
    }

    @Override
    public DongHo findByMa(String ma) {
        return dongHoRepository.findByMa(ma);
    }
}
