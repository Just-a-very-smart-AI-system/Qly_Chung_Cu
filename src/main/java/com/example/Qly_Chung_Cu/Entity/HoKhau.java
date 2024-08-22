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
@Table(name = "ho_khau")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoKhau {

    @Id
    @Column(name = "ma_ho_khau", nullable = false)
    private Integer maHoKhau;

    @Column(name = "so_ho_khau")
    private Integer soHoKhau;

    @Column(name = "chu_ho", length = 50)
    private String chuHo;

    @Column(name = "so_nha")
    private Integer soNha;

    @Column(name = "duong_pho", length = 50)
    private String duongPho;

    @Column(name = "phuong_xa", length = 50)
    private String phuongXa;

    @Column(name = "quan_huyen", length = 50)
    private String quanHuyen;

    @ManyToOne
    @JoinColumn(name = "ma_tdc", referencedColumnName = "ma_tdc")
    private ToDanCu toDanCu;
}
