package com.example.ph26840.assigment.controller;

import com.example.ph26840.assigment.entity.SanPham;
import com.example.ph26840.assigment.repository.ISanPhamRepository;
import com.example.ph26840.assigment.service.*;
import com.example.ph26840.assigment.viewmodel.IThongKe;
import com.example.ph26840.lab56.entity.Sach;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/khan/thong-ke")

public class ThongKeController {

    @Autowired
    private SanPhamService spService;

    @Autowired
    private ISanPhamRepository sanPhamRepository;
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

    @GetMapping("/top10-sp-ton")
    public String hienthi(Model model) {
        List<SanPham> pageSP = repository.findTop10SanPhamTonLauNhat();
        model.addAttribute("lst1", pageSP);
        return "/assigment/san-pham/thongke";
    }

    @GetMapping("/top10-sp-theo-ngay")
    public String thongkeTheoNgay(Model model, @RequestParam(required = false) String start,
                                  @RequestParam(required = false) String end) {

        List<IThongKe> top10SanPhamNgay = new ArrayList<>();
        if (start == null || end == null) {
            top10SanPhamNgay = new ArrayList<>();
        } else {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = dateFormat.parse(start);
                Date endDate = dateFormat.parse(end);
                top10SanPhamNgay = sanPhamRepository.getTop10SanPhamBanChayTheoNgay(startDate, endDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        model.addAttribute("top10SanPhamNgay", top10SanPhamNgay);
        return "/assigment/san-pham/thongkeTheoTime";
    }


}
