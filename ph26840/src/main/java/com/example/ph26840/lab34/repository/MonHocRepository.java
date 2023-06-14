package com.example.ph26840.lab34.repository;

import com.example.ph26840.lab34.model.MonHoc;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("MonHocRepository")
public class MonHocRepository implements IMonHocRepository {

    private static final ArrayList<MonHoc> dsMonHoc = new ArrayList<>();

    static {
        dsMonHoc.add(new MonHoc("g5", "java", 3, "PTPM", "MinhDQ8,DungNA29", 0));
        dsMonHoc.add(new MonHoc("g1", "web", 3, "Web", "TienNH21,DungNA29,NguyenVV4", 1));
        dsMonHoc.add(new MonHoc("g2", "c++", 4, "PTPM", "MinhDQ8", 0));
        dsMonHoc.add(new MonHoc("g3", "front end", 3, "UDPM", "MinhDQ8,DungNA29,NguyenVV4", 1));
        dsMonHoc.add(new MonHoc("g4", "agile", 5, "Mar", "MinhDQ8,DungNA29,TienNH21", 0));
    }

    @Override
    public ArrayList<MonHoc> getAll() {
        return dsMonHoc;
    }

    @Override
    public void add(MonHoc monHoc) {
        dsMonHoc.add(monHoc);
    }
    @Override
    public void delete(String ma) {
        for (int i = 0; i < dsMonHoc.size(); i++) {
            if(ma.equals(dsMonHoc.get(i).getMaMon())){
                dsMonHoc.remove(i);
            }
        }
    }

    @Override
    public void update(MonHoc monHoc,String ma) {
        for (int i = 0; i < dsMonHoc.size(); i++) {
            if(ma.equals(dsMonHoc.get(i).getMaMon())){
                dsMonHoc.set(i, monHoc);
            }
        }
    }

    @Override
    public MonHoc findByMa(String ma) {
        for (int i = 0; i < dsMonHoc.size(); i++) {
            if(ma.equals(dsMonHoc.get(i).getMaMon())){
                return dsMonHoc.get(i);
            }
        }
        return null;
    }
}
