package com.example.Qly_Chung_Cu.Controller;

import com.example.Qly_Chung_Cu.DTO.Request.NhanKhauRequest;
import com.example.Qly_Chung_Cu.Entity.NhanKhau;
import com.example.Qly_Chung_Cu.Service.NhanKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public NhanKhau getById(@PathVariable("id") Integer Id){
        return nhanKhauService.findById(Id);
    }
    @GetMapping("/findByName/{ho_ten}")
    public Iterable<NhanKhau> getByName(@PathVariable("ho_ten") String ho_ten){
        return  nhanKhauService.findByName(ho_ten);
    }
    @GetMapping("/findByDOB/{DOB}")
    public Iterable<NhanKhau> getByDOB(@PathVariable("DOB")Date DOB){
        return nhanKhauService.findByDOB(DOB);
    }

    @GetMapping("/findByGender/{gioi_tinh}")
    public Iterable<NhanKhau> getByGender(@PathVariable("gioi_tinh") Boolean gioi_tinh){
        return nhanKhauService.findByGender(gioi_tinh);
    }

    @GetMapping("/findByCCCD/{so_cccd}")
    public Iterable<NhanKhau> getByCCCD(@PathVariable("so_cccd") String so_cccd){
        return nhanKhauService.findByCCCD(so_cccd);
    }


    @GetMapping("/findByDanToc/{dan_toc}")
    public Iterable<NhanKhau> getByDanToc(@PathVariable("dan_toc") String dan_toc){
        return nhanKhauService.findByDanToc(dan_toc);
    }

    @GetMapping("/findByQueQuan/{que_quan}")
    public Iterable<NhanKhau> getByQueQuan(@PathVariable("que_quan") String que_quan){
        return nhanKhauService.findByQueQuan(que_quan);
    }
    @PutMapping("/create")
    public NhanKhau create(NhanKhauRequest request){
        return nhanKhauService.create(request);
    }
}
