package com.example.employee_managment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeSalaryResponseDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Double salary;
}