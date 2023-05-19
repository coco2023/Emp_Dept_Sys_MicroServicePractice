package com.cogent.microPrac.departmentservice.controller;

import com.cogent.microPrac.departmentservice.entity.Department;
import com.cogent.microPrac.departmentservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/departments")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping()
    public List<Department> getAllDept(){
        return deptService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById( @PathVariable("id") Long id ){
        return deptService.getDepartmentById(id);
    }

    @PostMapping("")
    public Department saveDepartment(@RequestBody Department department ) {
        return deptService.saveDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment( @PathVariable("id") Long id ) {
        deptService.deleteDepartmentById(id);
    }

}
