package com.example.Qly_Chung_Cu.Service;

import com.example.Qly_Chung_Cu.DTO.Request.HoKhauRequest;
import com.example.Qly_Chung_Cu.DTO.Request.NhanKhauRequest;
import com.example.Qly_Chung_Cu.Entity.BienDongNhanKhau;
import com.example.Qly_Chung_Cu.Entity.HoKhau;
import com.example.Qly_Chung_Cu.Entity.NhanKhau;
import com.example.Qly_Chung_Cu.Repository.BienDongNhanKhauRepository;
import com.example.Qly_Chung_Cu.Repository.HoKhauRepository;
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
    @Autowired
    private HoKhauRepository hoKhauRepository;

    public Iterable<BienDongNhanKhau> findAll(){
        return bienDongNhanKhauRepository.findAll();
    }
    public BienDongNhanKhau findById(int id){
        return bienDongNhanKhauRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy biến động này!"));
    }
    public Iterable<BienDongNhanKhau> findByDate(Date date){
        return bienDongNhanKhauRepository.findAllByNgayBienDong(date);
    }

    public BienDongNhanKhau addNhanKhau(NhanKhauRequest nhanKhauRequest, String ChiTietDB){
        NhanKhau newNK = nhanKhauService.create(nhanKhauRequest);

        BienDongNhanKhau newBD = new BienDongNhanKhau();

        newBD.setNhanKhau(newNK);
        newBD.setHoKhau(newNK.getHoKhau());
        newBD.setChiTietBienDong(ChiTietDB);
        newBD.setLoaiBienDong("Thêm nhân khẩu mới");
        newBD.setNgayBienDong(LocalDate.now().toString());

        return bienDongNhanKhauRepository.save(newBD);
    }
    public BienDongNhanKhau deleteNhanKhau(NhanKhauRequest nhanKhauRequest, String ChiTietDB){
        nhanKhauService.delete(nhanKhauRequest.getMaNhanKhau());
        NhanKhau newNK = nhanKhauService.findById(nhanKhauRequest.getMaNhanKhau());
        HoKhau HK = newNK.getHoKhau();
        BienDongNhanKhau newBD = new BienDongNhanKhau();

        if(nhanKhauService.isChoHo(nhanKhauRequest.getMaNhanKhau())){
            updateChuHo(HK.getMaHoKhau(), "Chưa xét!");
        }
        else{
            newBD.setNhanKhau(newNK);
            newBD.setHoKhau(newNK.getHoKhau());
            newBD.setLoaiBienDong("Xóa nhân khẩu");
            newBD.setChiTietBienDong(ChiTietDB);
            newBD.setNgayBienDong(LocalDate.now().toString());

        }
        return bienDongNhanKhauRepository.save(newBD);
    }

    public void updateChuHo(int idHK, String ChuHo){
        HoKhau HK = hoKhauService.findById(idHK);
        BienDongNhanKhau newBD = new BienDongNhanKhau();

        HK.setChuHo(ChuHo);
        hoKhauRepository.save(HK);
    }
}
