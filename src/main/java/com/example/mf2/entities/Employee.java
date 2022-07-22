package com.example.mf2.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "employees")
public class Employee {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private String position;
}
