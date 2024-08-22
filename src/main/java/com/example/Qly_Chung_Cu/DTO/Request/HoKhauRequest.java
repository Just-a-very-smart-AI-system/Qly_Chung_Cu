package com.example.Qly_Chung_Cu.DTO.Request;

import com.example.Qly_Chung_Cu.Entity.ToDanCu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoKhauRequest {

    private Integer maHoKhau;

    private Integer soHoKhau;

    private String chuHo;

    private Integer soNha;

    private String duongPho;

    private String phuongXa;

    private String quanHuyen;

    private Integer idToDanCu;
}
