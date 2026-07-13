package com.example.employee_managment.mapper;

import com.example.employee_managment.dto.response.EmployeeIdentityResponseDto;
import com.example.employee_managment.dto.response.EmployeeSalaryResponseDto;
import com.example.employee_managment.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeIdentityMapper {
    public EmployeeIdentityResponseDto toResponse(Employee employee) {
        return new EmployeeIdentityResponseDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getIdentity()
        );
    }
}
