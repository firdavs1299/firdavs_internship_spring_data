package com.example.mf2.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "interns")
public class Intern {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
    private String hobby;
}
