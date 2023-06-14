package com.example.ph26840.assigment.controller;

import com.example.ph26840.assigment.entity.*;
import com.example.ph26840.assigment.repository.ISanPhamRepository;
import com.example.ph26840.assigment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/khan")
public class SanPhamController {
    @Autowired
    private SanPhamService spService;
    @Autowired
    private ChatLieuService chatLieuService;
    @Autowired
    private ThuongHieuService thuongHieuService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private LoaiService loaiService;

    @Autowired
    private ISanPhamRepository repository;

    @GetMapping("/hien-thi")
    public String hienthi(Model model,
                          @RequestParam(defaultValue = "1") int page,
                          @RequestParam(required = false) String tenSP) {
        Page<SanPham> pageSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 3);
        if (tenSP == null || tenSP.isBlank()) {
            pageSP = repository.findAll(pageable);
        } else {
            pageSP = repository.findByTenSPContains(tenSP, pageable);
        }
        model.addAttribute("lstSPCT", pageSP);
        model.addAttribute("tenSP", tenSP);
        return "/assigment/san-pham/hien-thi";
    }

    @GetMapping("/san-pham")
    public String dsSP(Model model,
                          @RequestParam(defaultValue = "1") int page,
                          @RequestParam(required = false) String tenSP) {
        Page<SanPham> pageSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 10);
        if (tenSP == null || tenSP.isBlank()) {
            pageSP = repository.findAll(pageable);
        } else {
            pageSP = repository.findByTenSPContains(tenSP, pageable);
        }
        model.addAttribute("lstSPCT", pageSP);
        model.addAttribute("tenSP", tenSP);
        return "/assigment/san-pham/sanpham";
    }


    @GetMapping("/tim-theo-khoang")
    public String timTheoKhoang(Model model,
                                @RequestParam(defaultValue = "1") int page,
                                @RequestParam(required = false) BigDecimal minPrice,
                                @RequestParam(required = false) BigDecimal maxPrice) {
        Page<SanPham> pageSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 10);
        if (minPrice == null && maxPrice == null) {
            pageSP = repository.findAll(pageable);
        } else {
            if (minPrice == null) minPrice = BigDecimal.ZERO;
            if (maxPrice == null) maxPrice = BigDecimal.valueOf(Double.MAX_VALUE);
            pageSP = repository.findByGiaBanBetween(minPrice, maxPrice, pageable);
        }

        model.addAttribute("lstSPCT", pageSP);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "/assigment/san-pham/hien-thi";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        List<SanPham> lstSPCT = spService.findAll();
        model.addAttribute("lstSPCT", lstSPCT);

        List<ChatLieu> lstCL = chatLieuService.findAll();
        model.addAttribute("lstCL", lstCL);

        List<Loai> lstLoai = loaiService.findAll();
        model.addAttribute("lstLoai", lstLoai);

        List<MauSac> lstMS = mauSacService.findAll();
        model.addAttribute("lstMS", lstMS);

        List<ThuongHieu> lstTH = thuongHieuService.findAll();
        model.addAttribute("lstTH", lstTH);

        return "/assigment/san-pham/add";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        SanPham lstSPCT = spService.finByIdSP(id);
        model.addAttribute("sp", lstSPCT);

        List<ChatLieu> lstCL = chatLieuService.findAll();
        model.addAttribute("lstCL", lstCL);

        List<Loai> lstLoai = loaiService.findAll();
        model.addAttribute("lstLoai", lstLoai);

        List<MauSac> lstMS = mauSacService.findAll();
        model.addAttribute("lstMS", lstMS);

        List<ThuongHieu> lstTH = thuongHieuService.findAll();
        model.addAttribute("lstTH", lstTH);

        return "/assigment/san-pham/update";
    }

    @GetMapping("/detailKhan/{id}")
    public String detailSP(Model model, @PathVariable("id") Integer id) {
        SanPham lstSPCT = spService.finByIdSP(id);
        model.addAttribute("sp", lstSPCT);

        List<ChatLieu> lstCL = chatLieuService.findAll();
        model.addAttribute("lstCL", lstCL);

        List<Loai> lstLoai = loaiService.findAll();
        model.addAttribute("lstLoai", lstLoai);

        List<MauSac> lstMS = mauSacService.findAll();
        model.addAttribute("lstMS", lstMS);

        List<ThuongHieu> lstTH = thuongHieuService.findAll();
        model.addAttribute("lstTH", lstTH);

        return "/assigment/san-pham/detailsp";
    }

    @PostMapping("/add")
    public String addSP(Model model, SanPham sanPham) {
        sanPham.setNgayNhap(LocalDate.now());
        spService.add(sanPham);
        return "redirect:/admin/khan/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String updateSP(@PathVariable("id") Integer id, @ModelAttribute("sp") SanPham sanPham) {
        sanPham.setNgayNhap(LocalDate.now());
        spService.update(sanPham, id);
        return "redirect:/admin/khan/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        spService.delete(id);
        return "redirect:/admin/khan/hien-thi";
    }
}
