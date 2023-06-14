package com.example.ph26840.lab78.controller;

import com.example.ph26840.lab78.entity.GiangVien;
import com.example.ph26840.lab78.repository.IGiangVienRepository;
import com.example.ph26840.lab78.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lab78/giang-vien")
public class GiangVienController {

    @Autowired
    private GiangVienService giangVienService;

    @Autowired
    private IGiangVienRepository giangVienRepository;

    @GetMapping("/trang-chu")
    public String hienthi(Model model,
                          @RequestParam(defaultValue = "1") int page) {
        Page<GiangVien> pageSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 3);
        pageSP = giangVienRepository.findAllByOrderBySoLopDesc(pageable);
        model.addAttribute("lstSPCT", pageSP);
        return "/lab78/hien-thi";
    }

    @GetMapping("/seachTen")
    public String dsGV(Model model,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(required = false) String ten) {
        Page<GiangVien> pageSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 3);
        if (ten == null || ten.isBlank()) {
            pageSP = giangVienRepository.findAll(pageable);
        } else {
            pageSP = giangVienRepository.findByTenContaining(ten, pageable);
        }
        model.addAttribute("lstSPCT", pageSP);
        model.addAttribute("tenSP", ten);
        return "/lab78/hien-thi";
    }

    @GetMapping("/themMoi")
    public String viewAdd(Model model) {
        List<GiangVien> lstSPCT = giangVienService.finAll();
        model.addAttribute("lstSPCT", lstSPCT);


        return "/lab78/add";
    }

    @PostMapping("/add")
    public String addSP(Model model, GiangVien giangVien) {
        giangVienService.add(giangVien);

        return "redirect:/lab78/giang-vien/trang-chu";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        giangVienService.delete(id);
        return "redirect:/lab78/giang-vien/trang-chu";
    }
}
