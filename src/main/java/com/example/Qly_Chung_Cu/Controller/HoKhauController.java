package com.example.Qly_Chung_Cu.Controller;

import com.example.Qly_Chung_Cu.DTO.Request.HoKhauRequest;
import com.example.Qly_Chung_Cu.Entity.HoKhau;
import com.example.Qly_Chung_Cu.Service.HoKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hoKhau")
public class HoKhauController {
    @Autowired
    private HoKhauService hoKhauService;
    @GetMapping("/findAll")
    public Iterable<HoKhau> getAll(){
        return hoKhauService.getAll();
    }

    @GetMapping("/findbyId/{id}")
    public HoKhau getbyId(@PathVariable("id") Integer Id){
        return hoKhauService.findById(Id);
    }

    @GetMapping("/findbyTdc/{ma_tdc}")
    public Iterable<HoKhau> findByTDC(@PathVariable("ma_tdc") Integer ma_tdc){
        return hoKhauService.findByTDC(ma_tdc);
    }
    @GetMapping("/findbyPhuong/{phuong}")
    public Iterable<HoKhau> findByPhuong(@PathVariable("phuong") String phuong){
        return hoKhauService.findByPhuong(phuong);
    }
    @GetMapping("/findbyDuong/{duong}")
    public Iterable<HoKhau> findByDuong(@PathVariable("duong") String duong){
        return hoKhauService.findByDuongPho(duong);
    }
    @GetMapping("/findbyQuan/{Quan}")
    public Iterable<HoKhau> findByQuan(@PathVariable("Quan") String Quan){
        return hoKhauService.findByQuan(Quan);
    }
    @PutMapping("/create")
    public HoKhau Create(@RequestBody HoKhauRequest request){
        return hoKhauService.Create(request);
    }
}
