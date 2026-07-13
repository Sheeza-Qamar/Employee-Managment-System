package com.example.employee_managment.mapper;

import com.example.employee_managment.dto.response.EmployeeSalaryResponseDto;
import com.example.employee_managment.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSalaryMapper {

    //  constructor

    public EmployeeSalaryResponseDto toResponse(Employee employee) {
        return new EmployeeSalaryResponseDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getSalary()
        );
    }
}