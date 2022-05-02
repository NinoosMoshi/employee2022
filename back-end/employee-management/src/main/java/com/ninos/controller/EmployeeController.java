package com.ninos.controller;


import com.ninos.model.Employee;
import com.ninos.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    // http://localhost:8080/api/v1/all
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }


    // http://localhost:8080/api/v1/add
    @PostMapping("/add")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }




    // http://localhost:8080/api/v1/update
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
    }


    // http://localhost:8080/api/v1/find/{value}
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long id){
        Employee findEmployee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Employee>(findEmployee,HttpStatus.OK);
    }


    // http://localhost:8080/api/v1/delete/{value}
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }




}
