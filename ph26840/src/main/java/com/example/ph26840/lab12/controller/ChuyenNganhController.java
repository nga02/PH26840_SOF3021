package com.example.ph26840.lab12.controller;

import com.example.ph26840.lab12.entity.ChuyenNganh;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lab12")
public class ChuyenNganhController {

    private List<ChuyenNganh> lstCN = new ArrayList<>();

    @GetMapping("/bai-3")
    public String viewDS(Model model) {
        lstCN.add(new ChuyenNganh("11", "CNTT", "Dai Hoc", 8, "web"));
        lstCN.add(new ChuyenNganh("12", "CNTT", "Cao dang", 7, "web"));
        lstCN.add(new ChuyenNganh("13", "CNTT", "Dai Hoc", 8, "web"));
        lstCN.add(new ChuyenNganh("14", "CNTT", "Cao dang", 7, "web"));
        lstCN.add(new ChuyenNganh("15", "CNTT", "Dai Hoc", 8, "web"));
        model.addAttribute("lstCN", lstCN);
        return "/lab12/bai3";// tra ve view
    }

    @PostMapping("/bai-3")
    public String addCN(Model model,
                        @RequestParam("maNganh") String maNganh,
                        @RequestParam("tenNganh") String tenNganh,
                        @RequestParam("heDaoTao") String heDaoTao,
                        @RequestParam("soKy") int soKy,
                        @RequestParam("dsMon") String dsMon) {
        ChuyenNganh chuyenNganh = new ChuyenNganh(maNganh, tenNganh, heDaoTao, soKy, dsMon);
        lstCN.add(chuyenNganh);
        model.addAttribute("lstCN", lstCN);
        return "/lab12/bai3";// tra ve view
    }
}
