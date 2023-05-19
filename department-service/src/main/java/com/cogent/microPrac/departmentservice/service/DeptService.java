package com.cogent.microPrac.departmentservice.service;

import com.cogent.microPrac.departmentservice.entity.Department;

import java.util.List;

public interface DeptService {
    List<Department> getAllDepartment();
    Department getDepartmentById(Long departmentId);
    Department saveDepartment(Department department);
    void deleteDepartmentById(Long departmentId);
}
