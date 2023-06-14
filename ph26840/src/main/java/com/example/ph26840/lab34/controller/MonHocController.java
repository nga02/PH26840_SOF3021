package com.example.ph26840.lab34.controller;


import com.example.ph26840.lab34.model.MonHoc;
import com.example.ph26840.lab34.service.IMonHocService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lab34/bai-1")
public class MonHocController {
    @Autowired
    private IMonHocService service;

    @GetMapping
    public String viewBai1(Model model) {
        List<MonHoc> lstMH = service.getAll();
        model.addAttribute("ds", lstMH);
        return "/lab34/p1";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @RequestParam("maMon") String maMon,
                      @RequestParam("tenMon") String tenMon,
                      @RequestParam("soTin") int soTin,
                      @RequestParam("chuyenNganh") String chuyenNganh,
                      @RequestParam("giangVien") String giangVien,
                      @RequestParam("batBuoc") int batBuoc) {
        MonHoc monHoc = new MonHoc(maMon,tenMon,soTin,chuyenNganh,giangVien,batBuoc);
        service.add(monHoc);
        return "redirect:/lab34/bai-1";
    }

    @GetMapping("/delete/{maMon}")
    public String delete(@PathVariable("maMon") String maMon) {
        service.delete(maMon);
        return "redirect:/lab34/bai-1";
    }

    @GetMapping("/detail/{maMon}")
    public String update(Model model,@PathVariable("maMon") String maMon) {
        MonHoc mh = service.findByMa(maMon);
        model.addAttribute("mh",mh);
        return "redirect:/lab34/bai-1";
    }
}


//    @GetMapping("/sinh-vien/view-add")
//    public String viewAdd(Model model) {
//        model.addAttribute("sv", new SinhVien());
//        return "/buoi5/add-sinh-vien";
//    }