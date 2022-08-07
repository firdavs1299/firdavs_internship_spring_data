package com.example.mf2.services;

import com.example.mf2.entities.Employee;
import com.example.mf2.repositories.EmployeeRepository;
import com.example.mf2.rest.EmployeeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void delete(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
