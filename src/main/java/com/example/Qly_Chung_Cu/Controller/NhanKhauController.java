package com.example.Qly_Chung_Cu.Controller;

import com.example.Qly_Chung_Cu.Entity.NhanKhau;
import com.example.Qly_Chung_Cu.Service.NhanKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/nhankhau")

public class NhanKhauController {
    @Autowired
    private NhanKhauService nhanKhauService;
    @GetMapping("/findAll")
    public Iterable<NhanKhau> getALL(){
        return nhanKhauService.getAll();
    }
    @GetMapping("/findById/{id}")
    public NhanKhau getById(Integer Id){
        return nhanKhauService.findById(Id);
    }
}

