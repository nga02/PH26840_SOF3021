package com.example.ph26840.lab12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab12")
public class TinhBMI {
    @GetMapping("/bai-2")
    public String viewbai1(Model model
    ) {
        return "/lab12/bai2";
    }

    @PostMapping("/bai-2")
    public String tinhDiem(Model model,
                           @RequestParam Double chieuCao,
                           @RequestParam Double canNang) {
        Double bmi = canNang / (chieuCao * 2);
        if (bmi < 16) {
            model.addAttribute("kq1", "Do gay III");
        } else if (bmi < 17) {
            model.addAttribute("kq1", "Gay do II");
        } else if (bmi < 18.5) {
            model.addAttribute("kq1", "Gay do I");
        } else if (bmi < 25) {
            model.addAttribute("kq1", "Binh thuong");
        } else if (bmi < 30) {
            model.addAttribute("kq1", "Thua can");
        } else if (bmi < 35) {
            model.addAttribute("kq1", "Beo phi do 1");
        } else if (bmi < 40) {
            model.addAttribute("kq1", "Beo phi do II");
        } else {
            model.addAttribute("kq1", "Beo phi do III");
        }
        return "/lab12/hienthi";
    }
}
