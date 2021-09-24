package com.denin.socialmediaapp.controllers;

import com.denin.socialmediaapp.models.User;
import com.denin.socialmediaapp.models.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable Integer id){
        return userDaoService.findOne(id);
    }

    @PostMapping(path = "/users")
    public void createUser(@RequestBody User user){
        User savedUser = userDaoService.save(user);
    }



}
