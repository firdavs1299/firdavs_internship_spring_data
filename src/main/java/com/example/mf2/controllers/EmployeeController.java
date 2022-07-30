package com.example.mf2.controllers;

import com.example.mf2.entities.Employee;
import com.example.mf2.entities.Intern;
import com.example.mf2.entities.Response;
import com.example.mf2.repositories.EmployeeRepository;
import com.example.mf2.repositories.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employeelist")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    @GetMapping("/getEmployee/{id}")
    public Response getEmployeeById(@PathVariable("id") Long id){
        if(employeeRepository.existsById(id))
            return new Response(0,"Employee with id: "+id,employeeRepository.findById(id).get());
        else return new Response(2,"Employee with id "+id+" doesn't exists",null);
    }
    @PostMapping("/addEmployee")
    public Response createEmployee(@RequestBody Employee employee){
        Long userId = employeeRepository.save(employee).getId();
        if(userId!=null)
            return new Response(0,"Employee was successfully created",employeeRepository.findById(userId).get());
        else return new Response(3, "Couldn't create new Employee",null);
    }
    @PutMapping("/editEmployee/{id}")
    public Response updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            Long userId = employeeRepository.save(employee).getId();
            Employee editedEmployee = employeeRepository.findById(userId).get();
            return new Response(0,"Employee was edited successfully",employee);

        }
        else return new Response(2,"Employee with id "+id+" doesn't exists",null);

    }
    @DeleteMapping("/deleteEmployee/{id}")
    public Response deleteEmployee(@PathVariable("id") Long id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            boolean isDeleted = employeeRepository.existsById(id);
            if(!isDeleted){
                return new Response(0,"Employee was successfully deleted",null);
            }
            else return new Response(1,"An error occured while deleting Employee",null);
        }
        else return new Response(2,"Employee with id "+id+" doesn't exists",null);
    }

}
