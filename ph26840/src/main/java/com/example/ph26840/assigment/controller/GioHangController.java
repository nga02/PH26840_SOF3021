package com.example.ph26840.assigment.controller;

import com.example.ph26840.assigment.entity.GioHang;
import com.example.ph26840.assigment.entity.GioHangChiTiet;
import com.example.ph26840.assigment.entity.KhachHang;
import com.example.ph26840.assigment.entity.SanPham;
import com.example.ph26840.assigment.repository.IGioHangChiTietRepository;
import com.example.ph26840.assigment.repository.IKhachHangRepository;
import com.example.ph26840.assigment.repository.ISanPhamRepository;
import com.example.ph26840.assigment.service.GioHangChiTietService;
import com.example.ph26840.assigment.service.GioHangService;

import com.example.ph26840.assigment.service.ISanPhamService;
import com.example.ph26840.assigment.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/khan/cart")
public class GioHangController {

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private GioHangService gioHangService;


    @Autowired
    private ISanPhamRepository sanPhamRepository;


    @GetMapping("/view")
    public String view(Model model) {

        List<GioHangChiTiet> list = gioHangChiTietService.findAll();
        BigDecimal tongTien = gioHangChiTietService.getTotal(list);
        model.addAttribute("tongTien", tongTien);
        model.addAttribute("gh", list);
        return "/assigment/san-pham/cart";
    }



    @RequestMapping("/add-to-cart/{id}")
    public String themSPVaoGio(Model model, @PathVariable("id") Integer idSP, @RequestParam("soLuong") Integer soLuong) {
        KhachHang khachHang = khachHangService.finByIdKH(1);
        GioHang gioHang = gioHangService.finByIdKH(khachHang);
        if (gioHang == null){
            Random random = new Random();
            int randomNumber = random.nextInt(9000) + 1000;
            gioHang.setIdKH(khachHang);
            gioHang.setMa("GH"+randomNumber);
            gioHang.setNgayTao(new Date());
            gioHang.setTenNguoiNhan(khachHang.getTen());
            gioHang.setDiaChi(khachHang.getDiaChi());
            gioHang.setSdt(khachHang.getSdt());
            gioHangService.addGioHang(gioHang);
            gioHang = gioHangService.finByIdKH(khachHang);
        }

        SanPham sanPham = sanPhamRepository.findById(idSP).orElse(null);

        if (sanPham != null) {
            GioHangChiTiet gioHangChiTiet = gioHangChiTietService.findByIdGHAndIdSP(gioHang, sanPham);

            if (gioHangChiTiet != null) {
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + soLuong);
                gioHangChiTietService.themSPVaoGio(gioHangChiTiet);
            } else {
                gioHangChiTiet = new GioHangChiTiet();
                gioHangChiTiet.setIdGH(gioHang);
                gioHangChiTiet.setIdSP(sanPham);
                gioHangChiTiet.setSoLuong(soLuong);
                gioHangChiTiet.setDonGia(sanPham.getGiaBan().multiply(BigDecimal.valueOf(soLuong)));
                gioHangChiTietService.themSPVaoGio(gioHangChiTiet);

            }
        }
        return "redirect:/khan/cart/view";
    }


    @RequestMapping("/update-quantity/{id}")
    public String capNhatSoLuong(Model model, @PathVariable("id") Integer id, @RequestParam("actions") String actions, @RequestParam("soLuong") Integer soLuong) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietService.finById(id);
        if (gioHangChiTiet != null) {
            if ("tang".equals(actions)) {
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
            } else if ("giam".equals(actions)) {
                gioHangChiTiet.setSoLuong(Math.max(gioHangChiTiet.getSoLuong() - 1, 1));
            }
            BigDecimal donGia = gioHangChiTiet.getIdSP().getGiaBan().multiply(BigDecimal.valueOf(gioHangChiTiet.getSoLuong()));
            gioHangChiTiet.setDonGia(donGia);
            gioHangChiTietService.themSPVaoGio(gioHangChiTiet);
        }
        return "redirect:/khan/cart/view";
    }

    @GetMapping("/remove-cart/{id}")
    public String delete(Model model, @PathVariable("id") Integer id, RedirectAttributes re) {
        gioHangChiTietService.delete(id);
        System.out.println("sacdc sdz");
        re.addFlashAttribute("messess1", "Xoá thành công!");
        return "redirect:/khan/cart/view";
    }

    @GetMapping("/check-out")
    public String thongTinKH(Model model) {
        KhachHang khachHang = khachHangService.finByIdKH(1);
        List<GioHangChiTiet> list = gioHangChiTietService.findAll();
        BigDecimal tong = gioHangChiTietService.getTotal(list);

        model.addAttribute("kh", khachHang);
        model.addAttribute("tong", tong);
        model.addAttribute("listGHCT", list);

        return "/assigment/san-pham/checkout";
    }
}




