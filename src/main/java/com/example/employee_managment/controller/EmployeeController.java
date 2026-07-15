package com.example.employee_managment.controller;


import com.example.employee_managment.dto.request.IdentityRequestDto;
import com.example.employee_managment.dto.request.SalaryRequestDto;
import com.example.employee_managment.dto.response.EmployeeAgeBetweenListResponseDto;
import com.example.employee_managment.dto.response.EmployeeIdentityResponseDto;
import com.example.employee_managment.dto.response.EmployeeSalaryResponseDto;
import com.example.employee_managment.mapper.EmployeeAgeBetweenResponseMapper;
import com.example.employee_managment.mapper.EmployeeIdentityMapper;
import com.example.employee_managment.mapper.EmployeeSalaryMapper;
import com.example.employee_managment.model.Employee;
import com.example.employee_managment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    private EmployeeSalaryMapper employeeSalaryMapper;

    @Autowired
    private EmployeeIdentityMapper employeeIdentityMapper;

    @Autowired
    private EmployeeAgeBetweenResponseMapper employeeAgeBetweenResponseMapper;

    @GetMapping("/allemp")
    public List<Employee> GetallEmployees(){
        return employeeService.getAllEmployee();
    }


    @PostMapping("/addemp")
    public Employee AddEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }


    @PatchMapping("/updateSalary/{id}")
    public EmployeeSalaryResponseDto updateSalary(@PathVariable Long id,
                                                  @Valid @RequestBody SalaryRequestDto salaryRequestDto) {

        Employee updated = employeeService.updateSalary(id, salaryRequestDto.getSalary());
        return employeeSalaryMapper.toResponse(updated);
    }


    @PatchMapping("/updateIdentity/{id}")
    public EmployeeIdentityResponseDto updateIdentity (@PathVariable Long id,
                                                       @Valid @RequestBody IdentityRequestDto identityRequestDto){

        Employee updated = employeeService.updateIdentity(id, identityRequestDto.getIdentity());

        return employeeIdentityMapper.toResponse(updated);

    }


    //------------- delete employee ---------------


    @DeleteMapping("/deleteEmployee/{id}")

    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee with id " + id + " deleted successfully");
    }



    @PatchMapping("/emp/raise")
    public ResponseEntity<String> increaseSalaryForAllEmployees(@RequestParam Double percentage) {

        employeeService.updateSalary(percentage);

        return ResponseEntity.ok(percentage + "% raise applied to all employees successfully");
    }



    //--------------------------------------------------

    @GetMapping("/GetEmpofAge")
    public List<EmployeeAgeBetweenListResponseDto> getAllEmpofAge(
            @RequestParam Integer minAge,
            @RequestParam Integer maxAge) {

        return employeeService.findByageBetween(minAge, maxAge)
                .stream()
                .map(employeeAgeBetweenResponseMapper::toResponse)
                .collect(Collectors.toList());
    }






}
