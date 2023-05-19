package com.cogent.microPrac.employeeservice.service.impl;

import com.cogent.microPrac.employeeservice.dto.Department;
import com.cogent.microPrac.employeeservice.dto.EmployeeDepartmentResponse;
import com.cogent.microPrac.employeeservice.entity.Employee;
import com.cogent.microPrac.employeeservice.repository.EmpRepositroy;
import com.cogent.microPrac.employeeservice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmpRepositroy empRepositroy;

    @Override
    public List<Employee> getAllEmployees() {
        return empRepositroy.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return empRepositroy.findById(employeeId).get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepositroy.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        empRepositroy.deleteById(employeeId);
    }

    @Override
    public EmployeeDepartmentResponse getEmployeeWithDepartment(Long employeeId) {
        // get employee
        Employee employee = empRepositroy.findById(employeeId).get();

        //
        Department department = restTemplate
                .getForObject("http://DEPARTMENT-SERVICE/departments/" + employee.getDepartmentId(),
                        Department.class);

        // return merged response
        EmployeeDepartmentResponse responseDto = new EmployeeDepartmentResponse();
        responseDto.setEmployee(employee);
        responseDto.setDepartment(department);

        return responseDto;
    }
}
