package com.cogent.microPrac.departmentservice.service.impl;

import com.cogent.microPrac.departmentservice.entity.Department;
import com.cogent.microPrac.departmentservice.repository.DeptReoisitory;
import com.cogent.microPrac.departmentservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptReoisitory deptReoisitory;

    @Override
    public List<Department> getAllDepartment() {
        return deptReoisitory.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return deptReoisitory.findById(departmentId).get();
    }

    @Override
    public Department saveDepartment(Department department) {
        return deptReoisitory.save(department);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        deptReoisitory.deleteById(departmentId);
    }
}
