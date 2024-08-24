package com.example.Qly_Chung_Cu.Controller;

import com.example.Qly_Chung_Cu.Entity.ToDanCu;
import com.example.Qly_Chung_Cu.Service.TDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tdc")
public class TDCControler {
    @Autowired
    private TDCService tdcService;

    @GetMapping("/findAll")
    public Iterable<ToDanCu> findAll(){
        return tdcService.findAll();
    }
    @GetMapping("/findById/{id}")
    public ToDanCu findById(@PathVariable("id") Integer id){
        return tdcService.findById(id);
    }
    @GetMapping("/findByToTruong/{to_truong}")
    public Iterable<ToDanCu> findByToTruong(@PathVariable("to_truong") String to_truong){
        return tdcService.findByToTruong(to_truong);
    }
    @GetMapping("/findByToPho/{to_pho}")
    public Iterable<ToDanCu> findByToPho(@PathVariable("to_pho") String to_pho){
        return tdcService.findByToPho(to_pho);
    }
}
