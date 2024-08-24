package com.example.Qly_Chung_Cu.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanKhauRequest {
    private Integer maNhanKhau;

    private String hoTen;

    private Boolean gioiTinh;

    private String ngaySinh;

    private String noiSinh;

    private String queQuan;

    private String danToc;

    private Integer soCccd;

    private String ngayCapCccd;

    private String ngayHetHanCccd;

    private String quanHeChuHo;

    private Integer hoKhauId;
}
