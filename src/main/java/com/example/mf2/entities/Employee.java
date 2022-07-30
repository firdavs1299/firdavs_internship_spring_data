package com.example.mf2.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "employees")
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1,
            initialValue = 12
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;
    private String position;
}
