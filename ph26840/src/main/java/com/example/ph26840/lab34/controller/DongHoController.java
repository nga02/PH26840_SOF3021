package com.example.ph26840.lab34.controller;


import com.example.ph26840.lab34.model.DongHo;
import com.example.ph26840.lab34.service.IDongHoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/lab34/bai-2")
public class DongHoController {
    @Autowired
    private IDongHoService dhSer;

    @GetMapping
    public String viewBai2(Model model) {
        List<DongHo> lstDH = dhSer.getAll();
        model.addAttribute("dsDH", lstDH);
        return "/lab34/p2";
    }

    @PostMapping("/add")
    public String addDH(Model model,
                        @RequestParam("maDongHo") String maDongHo,
                        @RequestParam("tenDongHo") String tenDongHo,
                        @RequestParam("xuatXu") String xuatXu,
                        @RequestParam("namSanXuat") int namSanXuat,
                        @RequestParam("giaTien") BigDecimal giaTien) {
        DongHo dongHo = new DongHo(maDongHo, tenDongHo, xuatXu, namSanXuat, giaTien);
        dhSer.add(dongHo);
        return "redirect:/lab34/bai-2";
    }
    @GetMapping("/delete/{maDongHo}")
    public String delete(@PathVariable("maDongHo") String maDongHo) {
        dhSer.delete(maDongHo);
        return "redirect:/lab34/bai-2";
    }



}

