package com.cogent.microPrac.employeeservice.repository;

import com.cogent.microPrac.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepositroy extends JpaRepository<Employee, Long> {
}
