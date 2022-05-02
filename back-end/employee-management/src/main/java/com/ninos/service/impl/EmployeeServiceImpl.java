package com.ninos.service.impl;

import com.ninos.model.Employee;
import com.ninos.repository.EmployeeRepository;
import com.ninos.service.EmployeeService;
import com.ninos.util.RandomCode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(RandomCode.generateCode());
        return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

