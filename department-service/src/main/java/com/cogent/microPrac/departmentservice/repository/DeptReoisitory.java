package com.cogent.microPrac.departmentservice.repository;

import com.cogent.microPrac.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptReoisitory extends JpaRepository<Department, Long> {
}
