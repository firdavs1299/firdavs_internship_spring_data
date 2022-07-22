package com.example.mf2.repositories;

import com.example.mf2.entities.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void injectedComponentsAreNotNull(){
        Date date = new Date();
        Long id = date.getTime();
        id = id%100000000;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstname("Firdavs");
        employee.setLastname("Fozilov");
        employee.setPosition("programmer");
        Assertions.assertEquals(employeeRepository.findById(id).stream().count(),0);
        employeeRepository.save(employee);
        Assertions.assertNotEquals(employeeRepository.findById(id).stream().count(),0);
    }
}