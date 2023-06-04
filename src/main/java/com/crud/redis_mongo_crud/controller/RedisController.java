package com.crud.redis_mongo_crud.controller;

import com.crud.redis_mongo_crud.model.User;
import com.crud.redis_mongo_crud.repository.UserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    UserDBRepository repository;

    @PostMapping("/user")
    @CachePut(value = "user", key = "#user.id")
    public User addNewUser(@RequestBody User user) {
        User userNew = repository.save(user);

        return userNew;
    }

    @GetMapping("/getUserById")
    @Cacheable(value = "user", key = "#id")
    public User getUserById(@RequestParam String id){
        return  repository.findById(id)!=null? repository.findById(id).get():null;
    }

    @PostMapping("/update")
    @CachePut(value = "user", key = "#user.id")
    public User updateUser(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/delete")
    @CacheEvict(value = "user", key = "#id")
    public String deleteUserById(@RequestParam String id) {
        repository.deleteById(id);
        return "Successfully Deleted";
    }

}
