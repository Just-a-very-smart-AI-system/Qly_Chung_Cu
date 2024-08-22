package com.example.Qly_Chung_Cu.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "to_dan_cu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDanCu {
    @Id
    @Column(name = "ma_tdc", nullable = false)
    private Integer maTdc;

    @Column(name = "so_tang")
    private Integer soTang;

    @Column(name = "to_truong", length = 50)
    private String toTruong;

    @Column(name = "to_pho", length = 50)
    private String toPho;
}
