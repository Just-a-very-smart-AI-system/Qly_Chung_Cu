package com.example.Qly_Chung_Cu.Service;

import com.example.Qly_Chung_Cu.Entity.HoKhau;
import com.example.Qly_Chung_Cu.Entity.NhanKhau;
import com.example.Qly_Chung_Cu.Repository.HoKhauRepository;
import com.example.Qly_Chung_Cu.Repository.NhanKhauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhanKhauService {
       @Autowired
        private NhanKhauRepository nhanKhauRepository;

        public Iterable<NhanKhau> getAll(){
            return nhanKhauRepository.findAll();
        }

        public NhanKhau findById(Integer Id){
            return nhanKhauRepository.findById(Id).orElseThrow(() -> new RuntimeException("Không tìm thấy nhân khẩu với Id:" + Id));
        }

}
