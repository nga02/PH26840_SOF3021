package com.example.ph26840.lab34.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DongHo {
    private String maDongHo;
    private String tenDongHo;
    private String xuatXu;
    private int namSanXuat;
    private BigDecimal giaTien;
}
