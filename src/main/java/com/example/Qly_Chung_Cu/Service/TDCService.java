package com.example.Qly_Chung_Cu.Service;

import com.example.Qly_Chung_Cu.Entity.ToDanCu;
import com.example.Qly_Chung_Cu.Repository.ToDanCuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDCService {
    @Autowired
    private ToDanCuRepository toDanCuRepository;

    public Iterable<ToDanCu> findAll(){
        return toDanCuRepository.findAll();
    }
    public ToDanCu findById(Integer Id){
        return toDanCuRepository.findById(Id).orElseThrow(()-> new RuntimeException("Không có tổ dân cư với Id này!"));
    }

    public Iterable<ToDanCu> findByToTruong(String to_truong){
        return toDanCuRepository.findAllByToTruong(to_truong);
    }
    public Iterable<ToDanCu> findByToPho(String to_pho){
        return toDanCuRepository.findAllByToPho(to_pho);
    }
}
