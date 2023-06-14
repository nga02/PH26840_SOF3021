package com.example.ph26840.lab34.repository;

import com.example.ph26840.lab34.model.DongHo;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;

@Repository("DongHoRepository")
public class DongHoRepository implements IDongHoRepository{
   private static final ArrayList<DongHo> lstDH = new ArrayList<>();
   static {
       lstDH.add(new DongHo("D1","Dong ho 1","Viet Nam",2020, BigDecimal.valueOf(100)));
       lstDH.add(new DongHo("D12","Dong ho 11","Han Quoc",2021, BigDecimal.valueOf(300)));
       lstDH.add(new DongHo("D13","Dong ho 12","Thai Lan",2022, BigDecimal.valueOf(500)));
       lstDH.add(new DongHo("D14","Dong ho 13","Viet Nam",2023, BigDecimal.valueOf(200)));
       lstDH.add(new DongHo("D15","Dong ho 14","Phap",2022, BigDecimal.valueOf(400)));
   }
    @Override
    public ArrayList<DongHo> getAll() {
        return lstDH;
    }

    @Override
    public void add(DongHo dongHo) {
       lstDH.add(dongHo);
    }

    @Override
    public void update(DongHo dongHo, String ma) {
        for (int i = 0; i < lstDH.size(); i++) {
            if(ma.equals(lstDH.get(i).getMaDongHo())){
                lstDH.set(i,dongHo);
            }
        }
    }

    @Override
    public void delete(String ma) {
        for (int i = 0; i < lstDH.size(); i++) {
            if(ma.equals(lstDH.get(i).getMaDongHo())){
                lstDH.remove(i);
            }
        }
    }

    @Override
    public DongHo findByMa(String ma) {
        for (int i = 0; i < lstDH.size(); i++) {
            if(ma.equals(lstDH.get(i).getMaDongHo())){
                return lstDH.get(i);
            }
        }
        return null;
    }
}
