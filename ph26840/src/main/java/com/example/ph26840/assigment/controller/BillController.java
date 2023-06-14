package com.example.ph26840.assigment.controller;

import com.example.ph26840.assigment.entity.*;
import com.example.ph26840.assigment.repository.IHoaDonRepository;
import com.example.ph26840.assigment.service.HoaDonChiTietService;
import com.example.ph26840.assigment.service.HoaDonService;
import com.example.ph26840.assigment.service.SanPhamService;
import com.example.ph26840.lab56.entity.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/khan/bill")
public class BillController {
    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private IHoaDonRepository hoaDonRepository;

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/view-bill")
    public String index(Model model, @RequestParam(defaultValue = "1") int page) {
        Page<HoaDon> pageHD;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 10);
        pageHD = hoaDonRepository.findAll(pageable);
        model.addAttribute("listHD", pageHD);
        return "/assigment/san-pham/hoadon";
    }

    @GetMapping("/detail-bill/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        HoaDon hoaDon = hoaDonService.findById(id);
        List<HoaDonChiTiet> hoaDonChiTiet = hoaDonChiTietService.findByHD(hoaDon);
        System.out.println(hoaDonChiTiet);
        model.addAttribute("hd",hoaDonChiTiet);
        return "/assigment/san-pham/detailHoaDon";
    }

    @GetMapping("/tim-HD-theo-ma")
    public String seachHD(Model model, @RequestParam(defaultValue = "1") int page,@RequestParam(required = false) String ma) {
        Page<HoaDon> pageHD;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 10);
        if (ma == null || ma.isBlank()) {
            pageHD = hoaDonRepository.findAll(pageable);
        } else {
            pageHD = hoaDonRepository.findByMaContains(ma, pageable);
        }
        model.addAttribute("listHD", pageHD);
        model.addAttribute("ma", ma);
        return "/assigment/san-pham/hoadon";
    }

}
