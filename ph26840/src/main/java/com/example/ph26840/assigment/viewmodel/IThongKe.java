package com.example.ph26840.assigment.viewmodel;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(types = {ThongKe.class})
public interface IThongKe {
    @Value("#{target.Id}")
    Integer getId();

    @Value("#{target.Ten}")
    String getTenSP();

    @Value("#{target.SoLuongBan}")
    Integer getSoLuongBan();

    @Value("#{target.GiaBan}")
    BigDecimal getGiaBan();

}
