package com.example.ph26840.assigment.controller;

import com.example.ph26840.assigment.entity.*;
import com.example.ph26840.assigment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/khan/order")
public class OrderController {

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private SanPhamService sanPhamService;

    @PostMapping("thanh-cong")
    public String taoHoaDon(Model model, @ModelAttribute("idKH") KhachHang khachHang,
                            @RequestParam("tenNguoiNhan") String tenNguoiNhan,
                            @RequestParam("diaChiNhanHang") String diaChiNhanHang,
                            @RequestParam("sdt") String sdt) {

        HoaDon hoaDon = new HoaDon();
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        String maHoaDon = "HD" + randomNumber;
        hoaDon.setMa(maHoaDon);
        khachHang = khachHangService.finByIdKH(1);
        hoaDon.setIdKH(khachHang);
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        hoaDon.setNgayTao(new Date());
        hoaDon.setTenNguoiNhan(tenNguoiNhan);
        hoaDon.setDiaChiNhanHang(diaChiNhanHang);
        hoaDon.setSdt(sdt);
        hoaDonService.saveHoaDon(hoaDon);

        List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietService.findAll();
        BigDecimal tong = gioHangChiTietService.getTotal(gioHangChiTiets);
        for (GioHangChiTiet gioHangChiTiet : gioHangChiTiets) {
            SanPham sanPham = gioHangChiTiet.getIdSP();
            int soLuongMua = gioHangChiTiet.getSoLuong();
            int soLuongHienCo = sanPham.getSoLuong();
            sanPham.setSoLuong(soLuongHienCo - soLuongMua);
            sanPhamService.add(sanPham);

            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setIdHD(hoaDon);
            hoaDonChiTiet.setIdSP(sanPham);
            hoaDonChiTiet.setSoLuong(soLuongMua);
            hoaDonChiTiet.setDonGia(sanPham.getGiaBan().multiply(BigDecimal.valueOf(soLuongMua)));
            hoaDonChiTietService.save(hoaDonChiTiet);


            model.addAttribute("hoaDon", hoaDon);
            model.addAttribute("khachHang", khachHang);
            model.addAttribute("hoaDonCT", hoaDonChiTiet);
            model.addAttribute("message", "Đặt hàng thành công");
        }
        model.addAttribute("tong", tong);

        gioHangChiTietService.deleteGH();

        return "/assigment/san-pham/order";
    }


}
