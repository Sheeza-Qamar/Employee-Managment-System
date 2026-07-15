package com.example.employee_managment.mapper;

import com.example.employee_managment.dto.response.EmployeeAgeBetweenListResponseDto;
import com.example.employee_managment.dto.response.EmployeeIdentityResponseDto;
import com.example.employee_managment.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAgeBetweenResponseMapper {

    public EmployeeAgeBetweenListResponseDto toResponse(Employee employee){

        return new EmployeeAgeBetweenListResponseDto(

        employee.getFirstname(),
        employee.getLastname(),
        employee.getAge()

        );
    }
}
