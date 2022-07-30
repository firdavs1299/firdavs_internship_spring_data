package com.example.mf2.controllers;

import com.example.mf2.entities.Intern;
import com.example.mf2.entities.Response;
import com.example.mf2.entities.User;
import com.example.mf2.repositories.InternRepository;
import com.example.mf2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/interlist")
public class InternController {
    @Autowired
    InternRepository internRepository;

    @GetMapping("/getInterns")
    public List<Intern> getInterns(){
        return internRepository.findAll();
    }
    @GetMapping("/getIntern/{id}")
    public Response getInternById(@PathVariable("id") Long id){
        if(internRepository.existsById(id))
            return new Response(0,"Intern with id: "+id,internRepository.findById(id).get());
        else return new Response(2,"Intern with id "+id+" doesn't exists",null);
    }
    @PostMapping("/addIntern")
    public Response createIntern(@RequestBody Intern intern){
        Long userId = internRepository.save(intern).getId();
        if(userId!=null)
            return new Response(0,"Intern was successfully created",internRepository.findById(userId).get());
        else return new Response(3, "Couldn't create new Intern",null);
    }
    @PutMapping("/editIntern/{id}")
    public Response updateIntern(@PathVariable("id") Long id, @RequestBody Intern intern){
        if(internRepository.existsById(id)){
            internRepository.deleteById(id);
            Long userId = internRepository.save(intern).getId();
            Intern editedIntern = internRepository.findById(userId).get();
            return new Response(0,"Intern was edited successfully",intern);

        }
        else return new Response(2,"Intern with id "+id+" doesn't exists",null);

    }
    @DeleteMapping("/deleteIntern/{id}")
    public Response deleteIntern(@PathVariable("id") Long id){
        if(internRepository.existsById(id)){
            internRepository.deleteById(id);
            boolean isDeleted = internRepository.existsById(id);
            if(!isDeleted){
                return new Response(0,"Intern was successfully deleted",null);
            }
            else return new Response(1,"An error occured while deleting Intern",null);
        }
        else return new Response(2,"Intern with id "+id+" doesn't exists",null);
    }

}
