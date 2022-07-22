package com.example.mf2.controllers;

import com.example.mf2.entities.Employee;
import com.example.mf2.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employeelist")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping()
    public List<Employee> getEmployeeList(){
        try{
            return employeeRepository.findAll();
        }
        catch (Exception e){
            return null;
        }

    }
}
