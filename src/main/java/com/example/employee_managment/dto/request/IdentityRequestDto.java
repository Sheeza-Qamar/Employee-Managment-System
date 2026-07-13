package com.example.employee_managment.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IdentityRequestDto {
    @Column(nullable = false)
    private String identity;

}
