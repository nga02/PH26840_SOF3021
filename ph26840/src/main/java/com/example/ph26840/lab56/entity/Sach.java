package com.example.ph26840.lab56.entity;

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
@Table(name="sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "masach")
    private String ma;

    @Column(name = "tensach")
    private String ten;

    @Column(name = "namxb")
    private int namXB;

    @Column(name = "theloai")
    private String theLoai;

    @Column(name = "tacgia")
    private String tacGia;
}
