package com.example.Qly_Chung_Cu.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bien_dong_nhan_khau")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BienDongNhanKhau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bien_dong", nullable = false)
    private Integer maBienDong;

    @Column(name = "loai_bien_dong", length = 50)
    private String loaiBienDong;

    @Column(name = "chi_tiet_bien_dong", length = 50)
    private String chiTietBienDong;

    @Column(name = "ngay_bien_dong")
    private String ngayBienDong;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_khau", referencedColumnName = "ma_nhan_khau")
    private NhanKhau nhanKhau;

    @ManyToOne
    @JoinColumn(name = "ma_ho_khau", referencedColumnName = "ma_ho_khau")
    private HoKhau hoKhau;
}

