package com.example.mf2.rest;

import com.example.mf2.entities.User;
import com.example.mf2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        System.out.println("users get"+users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAdmins(){
        List<User> admins = userService.getAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }


    @GetMapping(value = "/manager", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<User>> getManagers() {
        List<User> managers = userService.getManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }


    @GetMapping(value = "/mentor",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getMentors() {
        List<User> mentors = userService.getMentors();
        return new ResponseEntity<>(mentors, HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
