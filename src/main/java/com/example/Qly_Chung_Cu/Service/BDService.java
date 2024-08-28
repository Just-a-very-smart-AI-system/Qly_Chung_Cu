package com.example.Qly_Chung_Cu.Service;

import com.example.Qly_Chung_Cu.DTO.Request.NhanKhauRequest;
import com.example.Qly_Chung_Cu.Entity.BienDongNhanKhau;
import com.example.Qly_Chung_Cu.Entity.NhanKhau;
import com.example.Qly_Chung_Cu.Repository.BienDongNhanKhauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class BDService {
    @Autowired
    private BienDongNhanKhauRepository bienDongNhanKhauRepository;
    @Autowired
    private NhanKhauService nhanKhauService;
    @Autowired
    private HoKhauService hoKhauService;

    public Iterable<BienDongNhanKhau> findAll(){
        return bienDongNhanKhauRepository.findAll();
    }
    public BienDongNhanKhau findById(int id){
        return bienDongNhanKhauRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy biến động này!"));
    }
    public Iterable<BienDongNhanKhau> findByDate(Date date){
        return bienDongNhanKhauRepository.findAllByNgayBienDong(date);
    }

    public BienDongNhanKhau addNhanKhau(NhanKhauRequest nhanKhauRequest){
        NhanKhau newNK = nhanKhauService.create(nhanKhauRequest);

        BienDongNhanKhau newBD = new BienDongNhanKhau();
        newBD.setNhanKhau(newNK);
        newBD.setHoKhau(newNK.getHoKhau());
        newBD.setChiTietBienDong("Thêm nhân khẩu mới");
        newBD.setChiTietBienDong("Thêm nhân khẩu mới");
        newBD.setNgayBienDong(LocalDate.now().toString());

        return bienDongNhanKhauRepository.save(newBD);
    }
    public BienDongNhanKhau deleteNhanKhau(NhanKhauRequest nhanKhauRequest){
        nhanKhauService.delete(nhanKhauRequest.getMaNhanKhau());
        NhanKhau newNK = nhanKhauService.findById(nhanKhauRequest.getHoKhauId());

        BienDongNhanKhau newBD = new BienDongNhanKhau();
        newBD.setNhanKhau(newNK);
        newBD.setHoKhau(newNK.getHoKhau());
        newBD.setChiTietBienDong("Xóa nhân khẩu");
        newBD.setChiTietBienDong("Xóa nhân khẩu");
        newBD.setNgayBienDong(LocalDate.now().toString());

        return bienDongNhanKhauRepository.save(newBD);
    }
}
