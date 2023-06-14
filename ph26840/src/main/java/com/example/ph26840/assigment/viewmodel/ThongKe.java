package com.example.ph26840.assigment.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ThongKe {
    private Integer id;
    private String tenSP;
    private String soLuongBan;
    private BigDecimal giaBan;


}
