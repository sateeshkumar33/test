package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    private final DemoService service;

    @Autowired
    public DemoController(DemoService service){
        this.service = service;
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping("/get-users/{name}")
    public List<User> getUsersByName(@PathVariable String name){
        return service.getUsersByUserName(name);
    }


}
