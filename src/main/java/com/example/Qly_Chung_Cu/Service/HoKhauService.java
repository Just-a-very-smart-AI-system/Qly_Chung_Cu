package com.example.Qly_Chung_Cu.Service;

import com.example.Qly_Chung_Cu.DTO.Request.HoKhauRequest;
import com.example.Qly_Chung_Cu.Entity.HoKhau;
import com.example.Qly_Chung_Cu.Entity.ToDanCu;
import com.example.Qly_Chung_Cu.Mapper.HoKhauMapper;
import com.example.Qly_Chung_Cu.Repository.HoKhauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoKhauService {
    @Autowired
    private HoKhauRepository hoKhauRepository;
    @Autowired
    private HoKhauMapper hoKhauMapper;
    @Autowired
    private TDCService tdcService;
    public Iterable<HoKhau> getAll(){
        return hoKhauRepository.findAll();
    }
    public HoKhau findById(Integer Id){
        return hoKhauRepository.findById(Id).orElseThrow(() -> new RuntimeException("Không tìm thấy hộ khẩu với Id:" + Id));
    }
    public Iterable<HoKhau> findByTDC(Integer ma_tdc){
        return hoKhauRepository.findByToDanCu(ma_tdc);
    }
    public Iterable<HoKhau> findByDuongPho(String DuongPho){
        return hoKhauRepository.findByDuongPho(DuongPho);
    }
    public Iterable<HoKhau> findByPhuong(String Phuong){
        return hoKhauRepository.findByPhuongXa(Phuong);
    }
    public Iterable<HoKhau> findByQuan(String Quan){
        return hoKhauRepository.findByQuanHuyen(Quan);
    }
    public HoKhau Create(HoKhauRequest request){
        HoKhau hoKhau = hoKhauMapper.toHoKhau(request);
        if(hoKhauRepository.existsById(request.getIdToDanCu())){
            throw new RuntimeException("Đã tồn tại hộ khẩu vơi Id này rồi!");
        }
        ToDanCu toDanCu = tdcService.findById(request.getIdToDanCu());
        hoKhau.setToDanCu(toDanCu);
        return hoKhauRepository.save(hoKhau);
    }
    public void Delete(Integer id){
        hoKhauRepository.deleteById(id);
    }

}
