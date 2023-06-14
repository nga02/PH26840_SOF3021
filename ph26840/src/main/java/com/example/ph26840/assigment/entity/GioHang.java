package com.example.ph26840.assigment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="giohang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idkh",nullable = false)
    private KhachHang idKH;

    @ManyToOne
    @JoinColumn(name = "idnv",nullable = false)
    private NhanVien idNV;


    @Column(name = "ma")
    private String ma;

    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "ngaythanhtoan")
    private Date ngayThanhToan;

    @Column(name = "tennguoinhan")
    private String tenNguoiNhan;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "tinhtrang")
    private int tinhTrang;

}
