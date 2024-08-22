package com.example.Qly_Chung_Cu.Mapper;

import com.example.Qly_Chung_Cu.DTO.Request.HoKhauRequest;
import com.example.Qly_Chung_Cu.Entity.HoKhau;
import com.example.Qly_Chung_Cu.Entity.ToDanCu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface HoKhauMapper {
    @Mapping(target = "toDanCu", ignore = true)
    HoKhau toHoKhau(HoKhauRequest hoKhauRequest);
}
