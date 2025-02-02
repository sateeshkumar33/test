package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.repository.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    private final DemoRepo repository;

    @Autowired
    public DemoService(DemoRepo demoReo){
        this.repository = demoReo;
    }


    public User createUser(User newUser){
        return this.repository.save(newUser);
    }


    public List<User> getUsersByUserName(String name){
        return repository.findByName(name);
    }
}
