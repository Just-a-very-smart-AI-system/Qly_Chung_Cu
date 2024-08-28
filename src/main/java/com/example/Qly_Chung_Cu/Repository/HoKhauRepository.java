package com.example.Qly_Chung_Cu.Repository;

import com.example.Qly_Chung_Cu.Entity.HoKhau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HoKhauRepository extends JpaRepository<HoKhau, Integer> {
    @Query(value = "select * from ho_khau where ma_tdc = :Ma_TDC", nativeQuery = true)
    Iterable<HoKhau> findByToDanCu(@Param("Ma_TDC") Integer Ma_TDC);
    @Query(value = "select * from ho_khau where duong_pho = :x", nativeQuery = true)
    Iterable<HoKhau> findByDuongPho(@Param("x") String x);

    @Query(value = "select * from ho_khau where phuong_xa = :x", nativeQuery = true)
    Iterable<HoKhau> findByPhuongXa(@Param("x") String x);

    @Query(value = "select * from ho_khau where quan_huyen = :x", nativeQuery = true)
    Iterable<HoKhau> findByQuanHuyen(@Param("x") String x);
    @Query(value = "SELECT EXISTS(SELECT 1 FROM ho_khau WHERE chu_ho = :chuHo)", nativeQuery = true)
    Boolean existsByChuHo(String chuHo);
}
