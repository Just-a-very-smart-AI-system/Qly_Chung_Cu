package com.example.Qly_Chung_Cu.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nhan_khau")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanKhau {

    @Id
    @Column(name = "ma_nhan_khau", nullable = false)
    private Integer maNhanKhau;

    @Column(name = "ho_ten", length = 50)
    private String hoTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "noi_sinh", length = 50)
    private String noiSinh;

    @Column(name = "que_quan", length = 50)
    private String queQuan;

    @Column(name = "dan_toc", length = 50)
    private String danToc;

    @Column(name = "so_cccd")
    private Integer soCccd;

    @Column(name = "ngay_cap_cccd")
    private String ngayCapCccd;

    @Column(name = "ngay_het_han_cccd")
    private String ngayHetHanCccd;

    @Column(name = "quan_he_chu_ho", length = 50)
    private String quanHeChuHo;

    @ManyToOne
    @JoinColumn(name = "ma_ho_khau", referencedColumnName = "ma_ho_khau")
    private HoKhau hoKhau;
}

