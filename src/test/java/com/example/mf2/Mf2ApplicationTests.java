package com.example.mf2;

import com.example.mf2.controllers.EmployeeController;
import com.example.mf2.controllers.InternController;
import com.example.mf2.entities.Employee;
import com.example.mf2.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Mf2ApplicationTests {
	@Autowired
	EmployeeController employeeController;
	@Autowired
	InternController internController;
	@Autowired
	EmployeeRepository employeeRepository;
	@Test
	void contextLoads() {
		Assertions.assertNotNull(employeeController.getEmployees());
		Assertions.assertNotNull(internController.getInterns());
	}
	@Test
	void ConnectionTesting(){
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
