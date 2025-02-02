package com.example.demo.repository;


import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepo extends MongoRepository<User, String> {

    public List<User> findByName(String name);
}
