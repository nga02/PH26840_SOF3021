package com.example.ph26840.assigment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "matkhau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcv")
    private ChucVu idCV;

    @Column(name = "trangthai")
    private int trangThai;
}
