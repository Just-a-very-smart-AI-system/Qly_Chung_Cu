package com.example.Qly_Chung_Cu.Service;
import com.example.Qly_Chung_Cu.DTO.Request.CCCD;
import com.example.Qly_Chung_Cu.DTO.Request.NhanKhauRequest;
import com.example.Qly_Chung_Cu.Entity.HoKhau;
import com.example.Qly_Chung_Cu.Entity.NhanKhau;
import com.example.Qly_Chung_Cu.Mapper.NhanKhauMapper;
import com.example.Qly_Chung_Cu.Repository.NhanKhauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class NhanKhauService {
    @Autowired
    private NhanKhauRepository nhanKhauRepository;
    @Autowired
    private NhanKhauMapper nhanKhauMapper;
    @Autowired
    private HoKhauService hoKhauService;
    public Iterable<NhanKhau> getAll() {
        return nhanKhauRepository.findAll();
    }

    public NhanKhau findById(Integer Id) {
        return nhanKhauRepository.findById(Id).orElseThrow(() -> new RuntimeException("Không tìm thấy nhân khẩu với Id:" + Id));
    }

    public Iterable<NhanKhau> findByName(String ho_ten) {
        return nhanKhauRepository.findByHoTen(ho_ten);
    }

    public Iterable<NhanKhau> findByDOB(Date ngay_sinh) {
        return nhanKhauRepository.findByNgaySinh(ngay_sinh);
    }

    public Iterable<NhanKhau> findByGender(Boolean gioi_tinh) {
        return nhanKhauRepository.findByGender(gioi_tinh);
    }

    public Iterable<NhanKhau> findByCCCD(String so_cccd) {
        return nhanKhauRepository.findByCCCD(so_cccd);
    }

    public Iterable<NhanKhau> findByDanToc(String dan_toc) {
        return nhanKhauRepository.findByDanToc(dan_toc);
    }

    public Iterable<NhanKhau> findByQueQuan(String que_quan) {
        return nhanKhauRepository.findByQueQuan(que_quan);
    }
    public NhanKhau create(NhanKhauRequest request){
        NhanKhau newNhanKhau = nhanKhauMapper.toNhanKhau(request);

        HoKhau hoKhau = hoKhauService.findById(request.getHoKhauId());
        newNhanKhau.setHoKhau(hoKhau);

        return nhanKhauRepository.save(newNhanKhau);
    }

    public void delete(int id){
        nhanKhauRepository.deleteById(id);
    }
    public NhanKhau updateHoten(int id, String x){
        NhanKhau nhanKhau = findById(id);

        nhanKhau.setHoTen(x);
        return nhanKhauRepository.save(nhanKhau);
    }
    public NhanKhau updateSo_cccd(int id, CCCD cccd){
        NhanKhau nhanKhau = findById(id);

        nhanKhau.setSoCccd(cccd.getSoCccd());
        nhanKhau.setQueQuan(cccd.getQueQuan());
        nhanKhau.setNgayCapCccd(cccd.getNgayCapCccd());
        nhanKhau.setNgayHetHanCccd(cccd.getNgayHetHanCccd());
        nhanKhau.setDanToc(cccd.getDanToc());

        return nhanKhauRepository.save(nhanKhau);
    }
    public Boolean isChoHo(int id){
        NhanKhau nhanKhau = findById(id);
        HoKhau hoKhau = nhanKhau.getHoKhau();

        return hoKhau.getChuHo() == nhanKhau.getHoTen();
    }
}
