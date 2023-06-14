package com.example.ph26840.assigment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="giohangchitiet")
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "idgh", nullable = false)
    private GioHang idGH;


    @ManyToOne
    @JoinColumn(name = "idsp", nullable = false)
    private SanPham idSP;

    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "dongia")
    private BigDecimal donGia;

    @Column(name = "dongiakhigiam")
    private BigDecimal donGiaKhiGiam;

}
