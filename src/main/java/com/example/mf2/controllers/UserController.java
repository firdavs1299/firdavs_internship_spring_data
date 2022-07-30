package com.example.mf2.controllers;

import com.example.mf2.entities.Response;
import com.example.mf2.entities.User;
import com.example.mf2.entities.UserWithRole;
import com.example.mf2.repositories.UserRepository;
import com.example.mf2.repositories.UserWithRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userlist")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserWithRoleRepository userWithRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/getUsers")
    public List<UserWithRole> getUsers(){
        return userWithRoleRepository.findAll();
    }
    @GetMapping("/getUser/{id}")
    public Response getUserById(@PathVariable("id") Long id){
        if(userWithRoleRepository.existsById(id))
            return new Response(0,String.format("User with id: %s",id),userWithRoleRepository.findById(id).get());
        else return new Response(2,String.format("User with id %s doesn't exists",id),null);
    }
    @PostMapping("/addUser")
    public Response createUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Long userId = userRepository.save(user).getId();
        if(userId!=null)
        return new Response(0,"User was successfully created",userRepository.findById(userId).get());
        else return new Response(3, "Couldn't create new user",null);
    }
    @PutMapping("/editUser/{id}")
    public Response updateUser(@PathVariable("id") Long id, @RequestBody User user){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            Long userId = userRepository.save(user).getId();
            User editedUser = userRepository.findById(userId).get();
            return new Response(0,"User was edited successfully",user);

        }
        else return new Response(2,String.format("User with id %s doesn't exists",id),null);

    }
    @DeleteMapping("/deleteUser/{id}")
    public Response deleteUser(@PathVariable("id") Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            boolean isDeleted = userRepository.existsById(id);
            if(!isDeleted){
                return new Response(0,"User was successfully deleted",null);
            }
            else return new Response(1,"An error occured while deleting user",null);
        }
        else return new Response(2,String.format("User with id %s doesn't exists",id),null);
    }

}
