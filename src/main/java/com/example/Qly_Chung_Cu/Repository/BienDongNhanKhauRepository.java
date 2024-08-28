package com.example.Qly_Chung_Cu.Repository;

import com.example.Qly_Chung_Cu.Entity.BienDongNhanKhau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface BienDongNhanKhauRepository extends JpaRepository<BienDongNhanKhau, Integer> {
    @Query(value = "select * from bien_dong_nhan_khau where ngay_bien_dong = :date", nativeQuery = true)
    Iterable<BienDongNhanKhau> findAllByNgayBienDong(@Param("date") Date date);
}
