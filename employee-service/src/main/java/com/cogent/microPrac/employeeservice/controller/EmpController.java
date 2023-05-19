package com.cogent.microPrac.employeeservice.controller;

import com.cogent.microPrac.employeeservice.dto.EmployeeDepartmentResponse;
import com.cogent.microPrac.employeeservice.entity.Employee;
import com.cogent.microPrac.employeeservice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return empService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return empService.getEmployeeById(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return empService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long employeeId) {
        empService.deleteEmployeeById(employeeId);
    }

    @GetMapping("/department/{id}")
    public EmployeeDepartmentResponse getEmployeeWithDepartment( @PathVariable("id") Long employeeId) {
        return empService.getEmployeeWithDepartment(employeeId);
    }

}
