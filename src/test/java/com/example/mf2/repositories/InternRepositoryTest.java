package com.example.mf2.repositories;

import com.example.mf2.entities.Employee;
import com.example.mf2.entities.Intern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InternRepositoryTest {
    @Autowired
    private InternRepository internRepository;
    @Test
    void injectedComponentsAreNotNull(){
        Date date = new Date();
        Long id = date.getTime();
        id = id%100000000;
        Intern intern = new Intern();
        intern.setId(id);
        intern.setFirstname("Firdavs");
        intern.setLastname("Fozilov");
        intern.setAge(23);
        intern.setHobby("reading");
        Assertions.assertEquals(internRepository.findById(id).stream().count(),0);
        internRepository.save(intern);
        Assertions.assertNotEquals(internRepository.findById(id).stream().count(),0);
    }
}