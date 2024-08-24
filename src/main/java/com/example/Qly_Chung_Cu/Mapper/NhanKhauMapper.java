package com.example.Qly_Chung_Cu.Mapper;

import com.example.Qly_Chung_Cu.DTO.Request.NhanKhauRequest;
import com.example.Qly_Chung_Cu.Entity.NhanKhau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NhanKhauMapper {
    @Mapping(target = "hoKhau", ignore = true)
    NhanKhau toNhanKhau(NhanKhauRequest request);
}
