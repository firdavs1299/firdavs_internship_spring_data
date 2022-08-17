package com.example.mf2.rest;

import com.example.mf2.auth.ApplicationUser;
import com.example.mf2.auth.ApplicationUserDaoService;
import com.example.mf2.entities.Task;
import com.example.mf2.entities.User;
import com.example.mf2.repositories.JwtTokenRepository;
import com.example.mf2.repositories.TaskRepository;
import com.example.mf2.security.jwtUtil;
import com.example.mf2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;
    @Autowired
    TaskRepository repository;
    @Autowired
    jwtUtil jwtUtil;
    @Autowired
    JwtTokenRepository jwtTokenRepository;

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

    @PostMapping( value = "/createTask/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> createTask(@PathVariable Integer id, @RequestBody Task task, HttpServletRequest request) {
        Object userDetails = (Object) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username1 = userDetails.toString();

        System.out.println("This is real user name "+username1);
        String authHeader = request.getHeader("x-csrf-token");
        String username = null;
        String jwt = null;
        System.out.println("this is principal");

        //System.out.println((UserForMongo) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (authHeader != null) {
            jwt = authHeader;
            username = jwtUtil.extractUsername(jwt);
            System.out.println("This is user name "+username);
        }

        task.setExecutor_id(id);
        task.setDate_created(LocalDateTime.now());
        Task generated_task = repository.insert(task);
        return new ResponseEntity<>(generated_task, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
