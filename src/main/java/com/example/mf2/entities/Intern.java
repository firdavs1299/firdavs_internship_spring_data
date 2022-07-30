package com.example.mf2.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "interns")
public class Intern {
    @Id
    @SequenceGenerator(
            name = "intern_sequence",
            sequenceName = "intern_sequence",
            allocationSize = 1,
            initialValue = 12
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "intern_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
    private String hobby;
}
