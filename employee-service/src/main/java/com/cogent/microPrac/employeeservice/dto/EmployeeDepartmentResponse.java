package com.cogent.microPrac.employeeservice.dto;

import com.cogent.microPrac.employeeservice.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDepartmentResponse {
    private Employee employee;
    private Department department;
}
