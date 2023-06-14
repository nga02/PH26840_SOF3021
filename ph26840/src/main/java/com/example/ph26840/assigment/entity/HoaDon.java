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
@Table(name="hoadon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idkh", referencedColumnName = "id")
    private KhachHang idKH;

    @ManyToOne
    @JoinColumn(name = "idnv", referencedColumnName = "id")
    private NhanVien idNhanVien;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngaytao")
    private Date ngayTao;


    @Column(name = "tennguoinhan")
    private String tenNguoiNhan;

    @Column(name = "diachinhanhang")
    private String diaChiNhanHang;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "tinhtrang")
    private int tinhTrang;
}
