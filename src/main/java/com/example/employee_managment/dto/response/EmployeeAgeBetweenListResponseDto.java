package com.example.employee_managment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeAgeBetweenListResponseDto {

    private String firstname;
    private String lastname;
    private Integer age;

}
