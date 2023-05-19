package com.cogent.microPrac.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// note use @Entity !!!! otherwise it will create a department table in the service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {

    private long departmentId;
    private String departmentName;

    private String departmentAddress;

}
