package com.example.mf2.rest;

import com.example.mf2.entities.Intern;
import com.example.mf2.services.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interns")
public class InternRestController {

    @Autowired
    InternService internService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Intern>> getInterns() {
        List<Intern> interns = internService.getInterns();
        return new ResponseEntity<>(interns, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Intern> deleteIntern(@PathVariable Long internId) {
        internService.delete(internId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
