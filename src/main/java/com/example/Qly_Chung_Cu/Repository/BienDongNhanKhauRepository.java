package com.example.Qly_Chung_Cu.Repository;

import com.example.Qly_Chung_Cu.Entity.BienDongNhanKhau;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienDongNhanKhauRepository extends JpaRepository<BienDongNhanKhau, Integer> {
}
