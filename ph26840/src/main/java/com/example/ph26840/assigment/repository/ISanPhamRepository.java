package com.example.ph26840.assigment.repository;

import com.example.ph26840.assigment.entity.SanPham;
import com.example.ph26840.assigment.viewmodel.IThongKe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {
    Page<SanPham> findByTenSPContains(String tenSP, Pageable pageable);

    Page<SanPham> findByGiaBanBetween(BigDecimal min, BigDecimal max, Pageable pageable);


    @Query(value = """
            select  TOP(10) * from SanPham 
            order by NgayNhap asc
            """, nativeQuery = true)
    List<SanPham> findTop10SanPhamTonLauNhat();


    @Query(value = "SELECT TOP( 10 ) sp.Id as Id, sp.TenSP as Ten,sp.GiaBan as GiaBan, SUM(hdct.SoLuong) AS SoLuongBan\n" +
            "FROM SanPham sp\n" +
            "JOIN HoaDonChiTiet hdct ON sp.Id = hdct.IdSP\n" +
            "JOIN HoaDon hd ON hd.Id = hdct.IdHD\n" +
            "WHERE hd.NgayTao >= ?1 AND hd.NgayTao <= ?2\n" +
            "GROUP BY sp.Id, sp.TenSP,sp.GiaBan\n" +
            "ORDER BY SoLuongBan DESC",nativeQuery = true)
    List<IThongKe> getTop10SanPhamBanChayTheoNgay(Date startDate, Date endDate);

//    @Query("SELECT sp FROM SanPham sp JOIN sp.hoaDonChiTiets hdct " +
//            "WHERE hdct.thoiGianBan >= :startDate AND hdct.thoiGianBan <= :endDate " +
//            "GROUP BY sp.id " +
//            "ORDER BY SUM(hdct.soLuong) DESC")
//    List<SanPham> getTop10SanPhamBanChayTheoTuan(Date startDate,  Date endDate);
//
//    @Query("SELECT sp FROM SanPham sp JOIN sp.hoaDonChiTiets hdct " +
//            "WHERE hdct.thoiGianBan >= :startDate AND hdct.thoiGianBan <= :endDate " +
//            "GROUP BY sp.id " +
//            "ORDER BY SUM(hdct.soLuong) DESC")
//    List<SanPham> getTop10SanPhamBanChayTheoThang( Date startDate,  Date endDate);

}
