package com.example.ph26840.lab12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab12")
public class TinhDiemController {

    @RequestMapping()
    public String welcome(){
        return "index";
    }

    @GetMapping("/bai-1")
    public String viewBai1(Model model){
        return "/lab12/bai1";
    }
    @PostMapping("/bai-1")
    public String tinhDiem(Model model,
                           @RequestParam Double diemLab,
                           @RequestParam Double diemQuiz,
                           @RequestParam  Double diemAss,
                           @RequestParam  Double diemFinal){
        Double diemTB = diemLab * 0.28+ diemQuiz * 0.12 + diemAss * 0.2 + diemFinal * 0.4;
        if(diemTB<5 && diemFinal<5){
            model.addAttribute("kq","Không pass");
        }else{
            model.addAttribute("kq","Pass");
        }
        return "/lab12/diem";
    }

}
