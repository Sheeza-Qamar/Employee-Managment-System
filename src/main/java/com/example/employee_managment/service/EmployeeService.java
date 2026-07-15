package com.example.employee_managment.service;

import com.example.employee_managment.exception.EmployeeNotFoundException;
import com.example.employee_managment.model.Employee;
import com.example.employee_managment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Service
public class EmployeeService {


    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    public EmployeeRepository employeeRepository;

    //------------       GET ALL EMPLOYEES -------------

    public List<Employee> getAllEmployee(){

       return employeeRepository.findAll();
    }

    //---------------   ADD EMPLOYEES ----------------

    public Employee addEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    //---------------- update salary -----------

    public Employee updateSalary(Long id, Double newSalary) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        logger.info("Updated salary for employee id={} to new value={}", id, newSalary);

        employee.setSalary(newSalary);
        return employeeRepository.save(employee);
    }



    //------------- update identity -----------

    public Employee updateIdentity(Long id, String newIdentity){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        logger.info("Indentity of employee id = {} has been updated to = {} : ", id, newIdentity);

        employee.setIdentity(newIdentity);
        return employeeRepository.save(employee);
    }


    //---------- delete employee ---------------

    public void deleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        employeeRepository.delete(employee);

        logger.info("Employee with id = {} has been deleted..", id);
    }


    //---------  increase salary -----------

    public void updateSalary(Double percentage) {

        employeeRepository.increaseSalary(percentage);

        logger.info("Increased employees salaries by {} %.", percentage);
    }


    // ----------------------

    public List<Employee> findByageBetween (Integer minAge, Integer maxAge){
        return employeeRepository.findByAgeBetween(minAge, maxAge);
    }



}
