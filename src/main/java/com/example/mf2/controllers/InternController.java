package com.example.mf2.controllers;

import com.example.mf2.entities.Intern;
import com.example.mf2.repositories.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/interlist")
public class InternController {
    @Autowired
    InternRepository internRepository;
    @GetMapping()
    public List<Intern> getInternList(){
        try{
            return internRepository.findAll();
        }
        catch (Exception exception){
            return null;
        }

    }
}
