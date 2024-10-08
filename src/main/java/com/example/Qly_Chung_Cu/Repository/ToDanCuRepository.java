package com.example.Qly_Chung_Cu.Repository;

import com.example.Qly_Chung_Cu.Entity.ToDanCu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDanCuRepository extends JpaRepository<ToDanCu, Integer> {
    Iterable<ToDanCu> findAllByToTruong(String to_Truong);
    Iterable<ToDanCu> findAllByToPho(String to_Pho);
}