package com.example.employee_managment;

import com.example.employee_managment.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagmentApplication {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeManagmentApplication.class);

	public static void main(String[] args) {



		SpringApplication.run(EmployeeManagmentApplication.class, args);


	}

}
