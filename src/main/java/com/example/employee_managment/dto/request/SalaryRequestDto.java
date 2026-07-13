package com.example.employee_managment.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryRequestDto {

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be greater than zero")
    private Double salary;
}