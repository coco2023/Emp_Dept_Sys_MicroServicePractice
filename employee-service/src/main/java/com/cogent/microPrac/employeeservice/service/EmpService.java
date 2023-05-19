package com.cogent.microPrac.employeeservice.service;

import com.cogent.microPrac.employeeservice.dto.EmployeeDepartmentResponse;
import com.cogent.microPrac.employeeservice.entity.Employee;

import java.util.List;

public interface EmpService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long employeeId);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(Long employeeId);

    EmployeeDepartmentResponse getEmployeeWithDepartment(Long employeeId);

}
