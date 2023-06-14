package com.example.ph26840.assigment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "masp")
    private String maSP;

    @Column(name = "tensp")
    private String tenSP;

    @ManyToOne
    @JoinColumn(name = "idthuonghieu", nullable = false)
    private ThuongHieu idThuongHieu;

    @ManyToOne
    @JoinColumn(name = "idmausac", nullable = false)
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "idchatlieu", nullable = false)
    private ChatLieu idChatLieu;

    @ManyToOne
    @JoinColumn(name = "idloai", nullable = false)
    private Loai idLoai;

    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "gianhap")
    private BigDecimal giaNhap;

    @Column(name = "giaban")
    private BigDecimal giaBan;

    @Column(name = "trangthai")
    private int trangThai;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "ngaynhap",columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate ngayNhap;
}
