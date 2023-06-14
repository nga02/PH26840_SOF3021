package com.example.ph26840.assigment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "matkhau")
    private String matKhau;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "idKH")
    private GioHang gioHang;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idKH")
    private List<HoaDon> hoaDon;
}
