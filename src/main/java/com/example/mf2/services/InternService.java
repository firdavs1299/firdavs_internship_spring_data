package com.example.mf2.services;

import com.example.mf2.entities.Intern;
import com.example.mf2.repositories.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternService {
    @Autowired
    InternRepository internRepository;
    public List<Intern> getInterns() {
        return internRepository.findAll();
    }

    public void delete(Long internId) {
        internRepository.deleteById(internId);
    }
}
