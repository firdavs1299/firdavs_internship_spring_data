package com.example.mf2.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InternControllerTest {

    @Autowired
    InternController internController;
    @Test
    void getInternList() {
        Assertions.assertNotNull(internController.getInternList());
    }
}