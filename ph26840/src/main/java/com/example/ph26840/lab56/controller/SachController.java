package com.example.ph26840.lab56.controller;

import com.example.ph26840.assigment.entity.SanPham;
import com.example.ph26840.lab56.entity.Sach;
import com.example.ph26840.lab56.repository.ISachRepository;
import com.example.ph26840.lab56.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lab56/sach")
public class SachController {
    @Autowired
    private SachService sachService;
    @Autowired
    private ISachRepository repository;

    @GetMapping("/hien-thi")
    public String hienthi(Model model,
                          @RequestParam(defaultValue = "1") int page) {
        Page<Sach> pageSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);
        pageSP = repository.findAllByOrderByNamXBDesc(pageable);
        model.addAttribute("lstSPCT", pageSP);
        return "/lab56/sach";
    }

    @GetMapping("/seachTen")
    public String dsSP(Model model,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(required = false) String ten) {
        Page<Sach> pageSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);
        if (ten == null || ten.isBlank()) {
            pageSP = repository.findAll(pageable);
        } else {
            pageSP = repository.findByTenContaining(ten, pageable);
        }
        model.addAttribute("lstSPCT", pageSP);
        model.addAttribute("tenSP", ten);
        return "/lab56/sach";
    }

    @PostMapping("/add")
    public String addSP(Model model, Sach sach) {
        sachService.add(sach);

        return "redirect:/lab56/sach/hien-thi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        sachService.delete(id);
        return "redirect:/lab56/sach/hien-thi";
    }
    @GetMapping("/detail/{id}")
    public String detailSP(Model model, @PathVariable("id") Integer id) {
        Sach lstSPCT = sachService.findById(id);
        model.addAttribute("sp", lstSPCT);

        return "/lab56/add";
    }

    @PostMapping("/update/{id}")
    public String updateSP(@PathVariable("id") Integer id, @ModelAttribute("sp") Sach sach) {
        sachService.update(sach, id);
        return "redirect:/lab56/sach/hien-thi";
    }
}
