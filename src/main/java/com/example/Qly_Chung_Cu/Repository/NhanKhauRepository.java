package com.example.Qly_Chung_Cu.Repository;

import com.example.Qly_Chung_Cu.Entity.NhanKhau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface NhanKhauRepository extends JpaRepository<NhanKhau, Integer> {
    @Query(value = "select * from nhan_khau where ho_ten = :x", nativeQuery = true)
    Iterable<NhanKhau> findByHoTen(String x);

    @Query(value = "select * from nhan_khau where ngay_sinh = :y", nativeQuery = true )
    Iterable<NhanKhau> findByNgaySinh(Date y);

    @Query(value = "select * from nhan_khau where gioi_tinh = :z", nativeQuery = true)
    Iterable<NhanKhau> findByGender(Boolean z);

    @Query(value = "select * from nhan_khau where dan_toc = :t" ,nativeQuery = true)
    Iterable<NhanKhau> findByDanToc(String t);

    @Query(value = "select * from nhan_khau where so_cccd = :c" ,nativeQuery = true)
    Iterable<NhanKhau> findByCCCD(String c);

    @Query(value = "select * from nhan_khau where que_quan = :q" ,nativeQuery = true)
    Iterable<NhanKhau> findByQueQuan(String q);

}
