package com.example.mf2.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = InternRestController.class)
class InternRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getInterns() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/interns").contentType("application/json")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    void deleteIntern() {
    }
}