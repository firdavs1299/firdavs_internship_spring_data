package com.example.mf2.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1,
            initialValue = 10
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private Long role_id;
    @Column(name = "isactive")
    private boolean isActive;
}
